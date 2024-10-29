# Generador de Templates de Impresión

Aplicación de interfaz gráfica en Java diseñada para procesar y modificar templates específicos de impresión térmica. Permite reemplazar comandos predefinidos en el texto para adecuarlo al formato y a los requisitos de las impresoras térmicas, como control de saltos de línea, corte de papel y comandos de inicialización. Incluye un sistema de logs que documenta errores y excepciones en un archivo local, brindando confiabilidad en la operación y facilitando la detección y corrección de problemas comunes en el procesamiento de templates de impresión térmica.

### Características
- **Interfaz Gráfica con Swing**: Permite ingresar templates y visualizar el resultado en un área de texto.
- **Sistema de Logs**: Registra errores en un archivo application.log con detalles y excepciones.

### Alternativas
Para aquellos que buscan una aplicación robusta para procesamiento de plantillas, también existen frameworks como Apache Velocity o Freemarker en Java, que ofrecen capacidades adicionales de generación de plantillas.

## Insignias

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

## Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal.
- **Swing**: Framework para la creación de la interfaz gráfica.
- **I/O de Archivos**: Para el manejo de logs de errores.

<p align="left">
  <img src="https://github.com/user-attachments/assets/f0c85938-dec6-4471-a8c1-7f7eaf967a04" width="auto" height="90">
  <img src="https://github.com/user-attachments/assets/0e8b5d78-b2e3-441e-9047-216c65683658" width="auto" height="90">
</p>

## Instalación

### Requisitos
- Java JDK 11 o superior.

### Pasos
1. Compila el proyecto:
   ```bash
   $ javac ViewTemplate.java
   ```
3. Ejecuta la aplicación:
   ```bash
   $ java ViewTemplate
   ```

## Uso

1. Ingresa el texto con los comandos de template en el campo de texto superior.
2. Presiona Generar Template para ver el resultado procesado en el área de resultado.
3. Si se produce un error, se registrará en el archivo application.log en la misma carpeta donde se ejecuta el `.jar`.

## Apoyo

Para obtener ayuda, puedes utilizar las siguientes vías:

- [GitHub Issues](https://github.com/sebastiannarvaez23/template-base-express/issues)
- [Correo Electrónico](narvaezsebas8@gmail.com)

## Contribuyendo

¡Contribuciones son bienvenidas! Para contribuir:

1. Realiza un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Autores y Reconocimientos

Desarrollado por [Sebastian Narvaez](https://github.com/sebastiannarvaez23).

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Estado del proyecto

**Estado:** En crecimiento.
