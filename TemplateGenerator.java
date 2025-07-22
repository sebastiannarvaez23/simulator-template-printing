import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TemplateGenerator {

    private static JTextArea outputTextArea;

    public static String processTemplate(String template) {
    	
        String remplazado1 = template.replace("@{INIT}", "__En columna 1, desde linea 7 letras____\n\n\n\n\n");
        
        String remplazado2 = remplazado1.replace("@{LF}", "\n");
        
        String remplazado3 = remplazado2.replace("@{NT(", "");
        
        String remplazado4 = remplazado3.replace(")}", "");
        
        String remplazado5 = remplazado4.replace("~", "");
        
        String remplazado6 = remplazado5.replace("%%COPIA%%", "");
        
        String remplazado7 = remplazado6.replace("@{CUT(6610", "CORTA");
        
        return remplazado7;
        
    }

    public static void logError(String message, Exception e) {
        try {
            
            String jarDir = new File(TemplateGenerator.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
            File logFile = new File(jarDir, "application.log");

            FileWriter logWriter = new FileWriter(logFile, true);
            BufferedWriter bufferedLogWriter = new BufferedWriter(logWriter);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentTime = LocalDateTime.now().format(dtf);

            bufferedLogWriter.write("[" + currentTime + "] " + message + "\n");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            bufferedLogWriter.write(sw.toString() + "\n");

            bufferedLogWriter.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo escribir en el archivo log: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("Generador de Templates de Impresion");
            frame.setSize(400, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setResizable(false);

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(3, 1));

            JLabel label = new JLabel("Ingrese el template a procesar:");
            JTextField textField = new JTextField();

            JButton generateButton = new JButton("Generar Template");

            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String input = textField.getText();
                        if (input != null && !input.isEmpty()) {
                            String processedContent = processTemplate(input);
                            outputTextArea.setText(processedContent);  
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cadena válida.");
                        }
                    } catch (Exception ex) {
                        logError("Error al procesar el template: " + ex.getMessage(), ex);
                        JOptionPane.showMessageDialog(null, "Error al procesar el template.");
                    }
                }
            });

            topPanel.add(label);
            topPanel.add(textField);

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
            buttonPanel.add(generateButton);

            JButton clearButton = new JButton("Limpiar Template");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText("");
                    outputTextArea.setText("");
                }
            });
            buttonPanel.add(clearButton);

            topPanel.add(buttonPanel);

            JPanel outputPanel = new JPanel();
            outputPanel.setLayout(new BorderLayout());
            outputPanel.setPreferredSize(new Dimension(300, 200));  

            JLabel outputLabel = new JLabel("Resultado:");
            outputTextArea = new JTextArea();  
            outputTextArea.setEditable(false);  
            outputTextArea.setLineWrap(true);   
            outputTextArea.setWrapStyleWord(true);

            outputPanel.add(outputLabel, BorderLayout.NORTH);
            outputPanel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(outputPanel, BorderLayout.CENTER);  

            frame.setVisible(true);
        } catch (Exception e) {
            logError("Error al inicializar la aplicación: " + e.getMessage(), e);
            JOptionPane.showMessageDialog(null, "Error al inicializar la aplicación.");
        }
    }
}
