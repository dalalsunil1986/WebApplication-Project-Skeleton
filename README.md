[![Build Status](https://api.shippable.com/projects/5561a055edd7f2c052f9f34f/badge?branchName=master)](https://app.shippable.com/projects/5561a055edd7f2c052f9f34f/builds/latest)

# Standard Web Application Project Skeleton
### Develop web application with Spring Web MVC, Spring Security, JPA/Hibernate + MySQL, Thymeleaf, Bootstrap, Gradle

Just clone this project from github and start developing your application functionalities without wasting time on writing
configurations and library setup if you are going to use the following technology stack:

1. Spring 4.1.6.RELEASE
2. Spring Security 4.0.1.RELEASE
3. Servlet 3.1.0
4. Thymeleaf 2.1.4.RELEASE
5. JPA/Hibernate 4.3.10.Final
6. Bootstrap 3.3.0
7. Gradle 2.4
8. Joda Time 2.8
9. Tomcat 8.0.23 (Embedded)
10. Slf4j/Logback 1.1.3
11. Junit 4.12
12. spring-test 4.1.6.RELEASE (Spring MVC Test Framework)
13. Mockito 1.10.19

Following features have been configured:

* Spring Security's standard User and Role based authentication system
* Transaction support in Service/Dao layer
* Database connection pooling with enterprise-ready c3p0 library
* Bean Validation to validate model objects
* Internationalization (i18n) with MessageSource
* Templating framework (similar to Apache Tiles) to work with thymeleaf - Thymeleaf Layout Dialect
* Efficiently serving static contents like image/css/js
* Prevent browsers from caching dynamic contents

**Project Done so far:** A standard web application with authentication (login/logout) and User management (create/role assignment) system has been implemented.

## Quick start

First, clone this project from github and navigate to the directory from command line/terminal.

**If you have gradle already installed**, just run `gradle build`
then you will find a **war** file in your project's **build/libs** directory. Deploy it in your favorite container e.g. tomcat.

**If you don't have gradle installed**, well, there is awesome news for you! You don't need to download/install gradle to
build this project! Here, [gradle wrapper](http://java.dzone.com/articles/use-gradle-wrapper-and-stop) has been used to make your life easier ;)
All you have to do is to run the gradlew script, e.g. if you want to build this project, just execute te following command from your terminal:

* `./gradlew build ` (from Unix)
* `gradlew.bat build ` (from Windows)

This script will automatically determine your gradle installation or download & install gradle if required, and then execute
the gradle task, e.g. build war file for the command above. To see the list of tasks available, use `./gradlew tasks` or `gradlew.bat tasks`.


## Database Connection

You need to create a database named **`webapp`** in your local MySQL database to work with this application.
Change corresponding user credential to access database in `persistence-mysql.properties`.

**Note:** There is an `import.sql` file in classpath, which is executed and a user **`admin`** with password **`123456`**
and proper roles is inserted when `hibernate.hbm2ddl.auto` property is set to `create-drop` in `applicationContext-jpa.xml`.


## Quick development -> Direct deploy app on embedded tomcat
Well, building project and deploying manually in app container sometimes become pain as these are repetitive work. To make 
your life easier, embedded tomcat container has been integrated into this project. Just type `gradle tomcatRunWar` from your command line
and your project will build and run automatically on a tomcat container within a minute. You simply have to go to
**[http://localhost:8080/](http://localhost:8080/)** from your browser to see it running. Cool... right? ;)

## Deploy in local Tomcat with JRebel Support
1. Install Tomcat 8 at `/usr/local/tomcat`
2. Copy the script file from `config/catalina-jrebel.sh` in your `/usr/local/tomcat/bin` directory
3. Make sure, you installed jrebel at `/usr/local/JRebel` directory
4. Run **gradle deployWar** in your source code which will copy the war file to tomcat's webapps directory
5. From tomcat/bin, start tomcat server by `./catalina-jrebel.sh run`
6. Access application by browsing [http://localhost:8080/WebApplication-Project-Skeleton-1.0-SNAPSHOT/](http://localhost:8080/WebApplication-Project-Skeleton-1.0-SNAPSHOT/)
