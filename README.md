# WebServiceSpringRest
Proyecto desarrolado en Java que aplica Spring Web MVC, que realiza Servicios RESTful a travez de API, implementando las principales anotaciones:
-@GET, @POST, @DELETE, @PUT, @RestController, @RequestMapping y @ResponseBody
-Apache Maven
-Conectado con base de datos MySQL Workbench
Agregar en el archivo "application.properties" lo siguiente: spring.datasource.username="tu usuario" y spring.datasource.password="tu contraseña" (en caso lo tengas)
para que puedas realizar la conexión a la BD.
PRUEBAS EN POSTMAN
Ejemplo para listar datos: http://localhost:8090/andx/locacion/listar
Ejemplo para registrar en formato JSON: http://localhost:8090/andx/locacion/registrar
    {
        "direccion": "Av Los Alisos  365",
        "postalCode": 12,
        "city": "Lima",
        "provincita": "Lima",
        "paisId": 5
    }
Ejemplo para borrar por id: http://localhost:8090/andx/locacion/borrar/(location_id)

