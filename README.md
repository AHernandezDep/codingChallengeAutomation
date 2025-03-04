# Coding Challenge Automation
## Resumen
Se ha desarrollado un framework integral, con una arquitectura en capas, siguiendo buenas prácticas de codificación, capaz de ejecutar automatizaciones tanto en backend (APIs) como en interfaz de usuario (UI), proporcionando una solución versátil y eficiente para pruebas automatizadas. A continuación, se documenta el stack tecnológico y los patrones utilizados en su implementación:
- Java
- Maven
- Rest Assured
- TestNG
- Cucumber (Gherkin)
- POM (Page Object Moodel)
- Arquitectura de tres capas (Feature - Steps - Services). Test Logic separada de Test Implementation.
- Selenium WebDriver

Además, se han implementado diferentes tipos de reportes para proporcionar una visualización clara y detallada de los resultados de las pruebas automatizadas. Estos reportes permiten un análisis exhaustivo, facilitando la identificación de fallos, la optimización de procesos y la toma de decisiones basada en datos precisos:

Cucumber reports: Al finalizar la ejecución de los tests automatizados, se disponibiliza una URL, la cual está bajo el texto: View your Cucumber Report at:. Ingresando a esta URL se podrá consultar el resultado de la ejecución de los tests automatizados.
Extent reports: Al finalizar la ejecución de los tests automatizados, se disponibiliza un HTML, el cual se puede abrir con Chrome. Este HTML se encuentra bajo la ruta: target/extent-reports/ExtentReport.html. Abriendo este HTML se podrá consultar el resultado de la ejecución de los tests automatizados.

Por otro lado, en este repositorio existe una colección de Postman de nombre (Pokemon.postman_collection.json), la cual contiene los requests manuales que posteriormente fueron automatizados. Se puede realizar una importación desde Postman para visualizar el trabajo realizado. Como complemento a esta solicitud, se crearon tests (Pre-req and Post-res) para los diferentes requests, en donde se contemplan los requerimientos. Se puede consultar este desarrollo en la pestaña Scripts."

## Ejecutar Test Automation Suite 
- Abrir IntelliJ IDEA.
- Instalar Java 15 y setearla al proyecto.
- Instalar Apache Maven 3.9.9.
- Clonar repositorio de la rama *main*. Nota: El proyecto de automation se encuentra bajo la carpeta: *automationChallenge*.
- Esperar unos minutos hasta que el proyecto resuelva las depedencias necesarias e indexe la java version correspondiente.
- Posicionado en la raiz del proyecto ejecutar el siguiente comando: *mvn clean install -U*. Debemos obtener BUILD SUCCESS.
- Ir a TestRunner, indicar el TAG que se quiere ejecutar. Click derecho sobre la clase TestRunner y seleccionamos la opcion *Run 'TestRunner'*.

El framework cuenta con un TestRunner, el cual, mediante la utilización de TestNG y Cucumber, ejecuta la suite de tests automatizados en base a lo que se necesite ejecutar. En este caso, utilizamos @TAGS en nuestros features para indicar los tests que se quieren ejecutar. Se puede indicar un TAG en un Scenario en particular o también se puede crear un TAG a nivel de feature completo. El TAG se debe indicar bajo el parámetro tags en las @CucumberOptions del archivo TestRunner, por ejemplo: tags = @POKEMON. Luego de indicar el TAG correspondiente, estamos en condiciones de ejecutar los tests automatizados desde nuestro TestRunner. Comenzará la ejecución de la suite automatizada.

- Para los scenarios que se corresponden con API automation, se creó un TAG @POKEMON, el cual ejecuta toda la suite de tests automatizados. El feature se llama: Pokemon.feature.
- Para los scenarios que se corresponden con UI automation, se creó un TAG @TOOLSSHOP, el cual ejecuta toda la suite de tests automatizados. El feature se llama: ToolsShopDemo.feature.

En resumen:
- Ejecutar Suite API Automation: tags = @POKEMON. Guardamos cambios. Click derecho sobre la clase TestRunner y seleccionamos la opción Run 'TestRunner'.
- Ejecutar Suite UI Automation: tags = @TOOLSSHOP. Guardamos cambios. Click derecho sobre la clase TestRunner y seleccionamos la opción Run 'TestRunner'.

Se podrá visualizar en consola el proceso de la ejecución de los tests automatizados, información de los steps ejecutados e información de valor, como por ejemplo, los requests que se van realizando. Adjunto documento en donde se evidencia el correcto funcionamiento del framework, así como también de la suite automatizada tanto para APIs como UI: https://docs.google.com/document/d/1I-wm6VzCn8-aPunKSDGLdlDKzQMoy8bKO49fEYU3Lbs.
