Dependencias & Librerias
===========================
A continuacion el listado de librerias usadas en este ejemplo.
	1. spring-boot-starter-data-jpa
	2. spring-boot-starter-web
	3. springdoc-openapi-ui:1.6.11
	4. lombok
	5. h2
	6. lombok
	7. spring-boot-starter-test
  
Diagrama de Datos
================
En la sigueinte imagen vemos las relaciones que tenemos en los datos donde tenemos dos tablas, una apra User Info y User Phone
<img width="747" alt="image" src="https://user-images.githubusercontent.com/5667357/194619426-26eb83aa-0f32-42ba-a99f-b27735c4b605.png">

Swagger
===============
1. En la sigueinte url podremos ver las apis publicadas para crear usuario [http://localhost:8080/swagger-ui/index.html#/user-info-controller/create]

![image](https://user-images.githubusercontent.com/5667357/194615538-d88bd5a2-3add-438a-9944-36f792a952f7.png)

2. Los modelos de datos estan publicados en la pagina de Swagger
![image](https://user-images.githubusercontent.com/5667357/194615635-c3368920-28b1-44c2-a36b-49986b97c284.png)

3. De igual manera podemos ver la estructura JSON para la creacion de usuarios
![image](https://user-images.githubusercontent.com/5667357/194615706-9dad696c-f86c-402e-ba52-f765cc6ad83a.png)


Endpoint BCI User
=====================
1. En el siguiente commando se puede enviar los datos al endpoint.
```
curl --location --request POST 'localhost:8080/api/users' \
--header 'token: abcsecuritycode' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "Hunter2@hg",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}'
```

Endpoint Via Postman
===================
1. Podemos hacer el llamado del endpoint via postman como vemos a continuacion donde indicamos la url y los datos. <img width="858" alt="image" src="https://user-images.githubusercontent.com/5667357/194617388-2f3b6e05-b00f-4fe2-93db-79f365cf663d.png">

2. Como Header ademas, se esta enviando el token <img width="877" alt="image" src="https://user-images.githubusercontent.com/5667357/194617534-8c7c9054-15a7-4e0e-aea7-514de44e3546.png">


2. Recordar que el codigo curl anterior puede ser usado para importarlo directamente en postman. <img width="904" alt="image" src="https://user-images.githubusercontent.com/5667357/194617327-acef9bce-cd2c-4737-b90a-a91ede798049.png">

