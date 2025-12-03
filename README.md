MI PROYECTO
Lo he desarrolado en Java + Spring Boot siguiendo la arquitectura que se pide: Controlador – Servicio – Repositorio.
El servidor permite gestionar:
Proyectos


Tecnologías


Desarrolladores


Estados de los proyectos


Toda la información está almacenada en MySQL y se consume mediante peticiones HTTP.

Estructura del Proyecto 
 src/main/java/com/example/proyectos_rest
     controller     - Para los Endpoints.
     service        - Para la lógica de negocio.
     repository     - Para acceder a la base de datos.
     entity         -Para las entidades que representan tablas de MySQL.

Con esto tenemos un código limpio, mantenible y escalable.







Base de Datos: proyectosdb
Esta es la base de datos con la que hemos trabajado con la API que contiene las siguientes tablas:
projects
Incluye relaciones con:
status


technologies


developers


developers
Información básica de cada programador.
technologies
Lista de tecnologías disponibles.
status
Estados posibles del proyecto:
En desarrollo


Finalizado


En pausa


Tablas intermedias
developers_worked_on_projects


technologies_used_in_projects



Cómo ejecutamos el servidor
En mi proyecto se hace de manera muy sencilla. En VSCode pulsamos el boton run sobre la clase principal que es la siguiente: ProyectosRestApplication.java. Y con esto como se pide el servidor se queda siempre activo hasta que no se cierre la ventana. Por lo tanto mientras la ventana esté abierta la API sigue activa.
Endpoints disponibles
GET /api/v1/projects
Devuelve todos los proyectos incluyendo:
Estado


Tecnologías asociadas


Desarrolladores asignados


En mi proyecto lo usamos así:
GET http://localhost:8080/api/v1/projects

GET /api/v1/projects/{word}

Devuelve los proyectos cuyo nombre contenga la palabra indicada.
En mi proyecto lo usamos así:
GET http://localhost:8080/api/v1/projects/tareas
POST /api/v1/projects
Inserta un proyecto nuevo.
En el cuerpo JSON añadimos esto para crearlo:
{
  "name": "Nuevo Proyecto API",
  "description": "Creado desde Thunder Client",
  "startDate": "2024-05-01",
  "endDate": "2024-06-01",
  "demoUrl": "https://demo.com",
  "picture": "img.png",
  "status": { "id": 3 },
  "technologies": [
    { "id": 3 },
    { "id": 4 }
  ],
  "developers": [
    { "id": 1 },
    { "id": 2 }
  ]
}
PUT /api/v1/projects/{id}
Edita un proyecto que ya existe.
En mi proyecto lo usamos así:
PUT http://localhost:8080/api/v1/projects/1
DELETE /api/v1/projects/{id}
Elimina un proyecto por su ID.
En mi proyecto lo usamos así:
DELETE http://localhost:8080/api/v1/projects/1
POST /api/v1/developers
Inserta un desarrollador.
En el cuerpo JSON añadimos esto para crearlo:
{
  "name": "Pedro",
  "surname": "Martínez",
  "email": "pedro@example.com",
  "linkedinUrl": "https://linkedin.com/pedro",
  "githubUrl": "https://github.com/pedro"
}
DELETE /api/v1/developers/{id}
Elimina un desarrollador.
En mi proyecto lo usamos así:
DELETE http://localhost:8080/api/v1/developers/1
POST /api/v1/technologies
Inserta una tecnología.
En el cuerpo JSON añadimos esto para crearlo:
{
  "name": "Python"
}
 DELETE /api/v1/technologies/{id}
Elimina una tecnología.
En mi proyecto lo usamos así:
DELETE http://localhost:8080/api/v1/technologies/7
