# Coding Challenge Automation
## Resumen
Se ha desarrollado un framework integral, con una arquitectura en capas, siguiendo buenas practicas de codificación, capaz de ejecutar automatizaciones tanto en backend (API's) como en interfaz de usuario (UI), proporcionando una solución versátil y eficiente para pruebas automatizadas. A continuación, se documenta el stack tecnológico utilizado en su implementación:
- Java
- Maven
- Rest Assured
- TestNG
- Cucumber (Gherkin)
- Selenium WebDriver

Además, se han implementado diferentes tipos de reportes para proporcionar una visualización clara y detallada de los resultados de las pruebas automatizadas. Estos reportes permiten un análisis exhaustivo, facilitando la identificación de fallos, la optimización de procesos y la toma de decisiones basada en datos precisos:
- **Cucumber reports:** Al finalizar la ejecucion de los Test automatizados se disponibiliza una URL la cual esta bajo el texto: *View your Cucumber Report at:*. Ingresando a esta URL se podra consultar el resultado de la ejecucion de los test automatizados.
- **Extent reports:** Al finalizar la ejecucion de los Test automatizados se disponibiliza un HTML el cual se puede abrir con Chrome. Este HTML se encuentra bajo la ruta: *target/extent-reports/ExtentReport.html*. Abriendo este HTML se podra consultar el resultado de la ejecucion de los test automatizados.

Por otro lado, en este repositorio existe una coleccion de postman de nombre (*Pokemon.postman_collection.json*) la cual contiene los request manuales que posteriormente fueron automatizados. Se puede realizar una importación desde Postman para visualizar el trabajo realizado. Como complemento a esta solicitud, se crearon test (*Pre-req and Post-res*) para los diferentes request en donde se contemplan los requerimientos. Se pueden consultar este desarrollo en la pestaña *Scripts*. 

## Ejecutar Test Automation Suite 
- Abrir IntelliJ IDEA.
- Clonar repositorio de la rama *master*.
- 

El framework cuenta con un *TestRunner* el cual mediante la utilizacion de TestNG y Cucumber ejecutan la suit de test automatizados en base a lo que se necesite ejecutar. En este caso, utilizamos @TAGS en nuestros features para indicar los test que se quieren ejecutar. Se puede indicar un TAG en un Scenario en particular o tambien se puede crear un TAG a nivel de feature completo. El TAG se debe indicar bajo el parametro *tags* en las *@CucumberOptions* del archivo TestRunner, por ejemplo: *tags = @POKEMON*. Luego de indicar el TAG correspondiente, estamos en condiciones de ejecutar los test automatizados, para esto click derecho sobre la clase TestRunner y seleccionamos la opcion *Run 'TestRunner'*. Comenzará la ejecucion de la suite automatizada. 
- Para los scenarios que se corresponden con API automation, se creo un TAG @POKEMON el cual ejecuta toda la suite de test automatizados. El feature se llama: *Pokemon.feature*.
- Para los scenarios que se corresponden con UI automation, se creo un TAG @TOOLSSHOP el cual ejecuta toda la suite de test automatizados. El feature se llama: *ToolsShopDemo.feature*.

En resumen:
- Ejecutar Suite API Automation: tags = @POKEMON. Guardamos cambios. Click derecho sobre la clase TestRunner y seleccionamos la opcion *Run 'TestRunner'*. 
- Ejecutar Suite UI Automation: tags = @TOOLSSHOP. Guardamos cambios. Click derecho sobre la clase TestRunner y seleccionamos la opcion *Run 'TestRunner'*.

Se pordrá visualizar en consola el proceso de la ejecucion de los Test automatizados. Informacion de los steps ejecutados e informacion de valor, como por ejemplo los request que se van realizado. Adjunto documento en donde se evidencia el correcto funcionamiento del framework asi como tambien de la suite automatizada tanto para API's como UI: https://docs.google.com/document/d/1I-wm6VzCn8-aPunKSDGLdlDKzQMoy8bKO49fEYU3Lbs.
