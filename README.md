# Introduction to Back-End Server Application Development using JEE

##  Material and examples project

This project contains the course materials and examples of usage. 

## Prerequisites
You must have an IDE to work with this project. We recommend using the IntelliJ IDEA Community Edition. This IDE has good integration with Maven and JUnit. You can download it from the following address: 

[https://www.jetbrains.com/idea/download/#section=mac](https://www.jetbrains.com/idea/download/#section=mac)

## Installation 

* Download or clone (`git clone`) this project
* Open the project using your IDE

## Compilation

You can compile your project using the ``mvn clean package`` command

## Running the application

The *pom.xml* file of this project has a **jetty plugin**. It allows starting a lightweitgh servlet container and deploy your application. 

To run the project, execute the command ``mvn jetty:run``. The server will start at port 8080.

You can access the application in your local machine using the following address:

[http://localhost:8080/JEECourse](http://localhost:8080/JEECourse)