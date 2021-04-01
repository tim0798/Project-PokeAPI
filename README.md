![demo](https://pokeapi.co/static/pokeapi_256.888baca4.png)
# Acerca de MiPokemonAPI
Esta es una API de servicios REST que consume los servicios REST de PokeApi ( https://pokeapi.co/ ) y además extiende algunas funcionalidades para la persistencia de datos en una base de datos en memoria H2.

## Qué hay adentro
Este proyecto se basa en el proyecto [Spring Boot 2.4.4](http://projects.spring.io/spring-boot/) y utiliza los siguientes paquetes:
- Maven
- Spring Data JPA
- H2 Database SQL
- Spring Web
- Validation 
- Spring Boot DevTools
- Thymeleaf

## Instalación 
El proyecto se crea con Maven, por lo que solo necesita importarlo a su IDE y construir el proyecto para resolver las dependencias

## Base de datos H2
Seguir los siguientes pasos para obtener la base de datos que se esta usa en el momento de ejecución del proyecto:

1.- Obtener la credencial aleatoria de la base de datos, esta se muestra en el log al momento de ejecutar el proyecto (Database available at ‘XXXXXXXXX’)
```
2021-04-01 09:00:05.984  INFO 8684 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-04-01 09:00:06.058  INFO 8684 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-04-01 09:00:06.062  INFO 8684 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:d26a346f-b19f-4bb8-b20a-cec37a96700e'
```
2.- Abrir el enlace [http://localhost:8080/MiPokemonAPI/h2-console](http://localhost:8080/MiPokemonAPI/h2-console) (mostrara un Login), poner la credencial copiada anteriormente en el valor JDBC URL y clic en Connect (Conectar solo poniendo la JDBC URL). Ahí encontraremos la tabla POKEMON, en la cual se guardan los datos.


## Como usar 
Ejecute el proyecto a través de su IDE y diríjase a [http://localhost:8080/MiPokemonAPI/help](http://localhost:8080/MiPokemonAPI/help) para obtener documentación sobre el uso de la API

## Obtenga información sobre Generaciones de Pokémones, Rango de Pokémones, Pokémon, etc. 
```
 GET http://localhost:8080/MiPokemonAPI/generaciones/{generacion} 
 GET http://localhost:8080/MiPokemonAPI/listaPokemones/{a}/{b} 
 GET http://localhost:8080/MiPokemonAPI/buscarPokemon/{identificador} 
 PUT http://localhost:8080/MiPokemonAPI/guardarPokemon 
 GET localhost:8080/MiPokemonAPI/obtenerPokemon/{apodo} 
 GET http://localhost:8080/MiPokemonAPI/consultarPokemonesPorEspecie/{especie} 
```

## Preguntas y comentarios: timoteogonzaleznava@gmail.com
