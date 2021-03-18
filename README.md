# Taller Segurdidad

Este taller tiene como objetivo poder realizar una practica teniendo en cuenta los principios de seguridad y certificados. 

## Correr proyecto

Primero Clonaremos el repositorio, para eso desde nuestro navegador nos dirigiremos al siguiente link

```sh
git clone https://github.com/SoyTiyi/AREP_Lab-6.git
```

 Y luego entraremos a las carpetas secure-consumer y secure-spark para compilar los proyectos

```sh
cd secure-consumer
mvn package
cd ..
cd secure-spark
mvn package
 ```
Para ejecutar la aplicacion primero entraremos al proyecto secure-consumer y creamos un docker tag para el proyecto

```sh
docker build --tag docker-consumer .
 ```
Luego ejecutamos el docker asignandole el puerto 5001

```sh
docker run -d -p 5001:6000 --name docker-consumer docker-consumer
 ```
Verificamos que se este ejecutando el proceso con el comando

```sh
docker ps
 ```
Ahor nos dirigimos a la carpeta secure-spark para ejecutar el cliente web

```sh
mvn compile exec:java -Dexec.mainClass="eci.escuelaing.arep.app.Spark.SparkWebServer"
```
### Credenciales para acceder al login
* Usuario: user@eci.com
* Contraseña: eci

### Video

[video](https://web.microsoftstream.com/video/040c8f1b-fb97-4fc0-9929-f4ec39a85ac6)

### Prerequisitos

* Docker
* UNIX / Linux
* Java SE Development Kit 8 -Java SE Runtime Environment 8 -Apache Maven.

## Integración Continua

* [![CircleCI](https://circleci.com/gh/SoyTiyi/LoadBalancer.svg?style=svg)](https://circleci.com/gh/SoyTiyi/LoadBalancer)

* [![CircleCI](https://circleci.com/gh/SoyTiyi/LoadBalancer.svg?style=svg)](https://circleci.com/gh/SoyTiyi/LoadBalancer)

## Correr Pruebas

Para correr las pruebas, ejecutamos el siguiente comando

```sh
$ mvn test
 ```

### Generar Javadoc

Para generar el javadoc, corremos el siguiente comando

```sh
$ mvn javadoc:javadoc 
 ```

## Construido con

* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://mvnrepository.com/artifact/junit/junit) - Test framework
* [VIM](https://www.vim.org/download.php) - Editor de Texto VIM

## Author

 - Santiago Martínez Martínez 
 - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito 
 - Noveno Semestre

## License

Este proyecto está licenciado bajo la GNU v3.0 - ver el archivo LICENSE.md para más detalles

