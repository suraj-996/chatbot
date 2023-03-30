# README #

## Chatbot Application
*The chatbot application allows user to interact with chatbot first user has to signup and then he can interact with chatbot with asking basic questions and chatbot will be respond to the basic questions.

## Tech Stack

### Frontend

* React JS
* HTML
* CSS

### Backend

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* MySQL

## How to set up

### React App (frontend)

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

### Backend

Configure following variables in application.properties file in "\chatbot\src\main\resources" folder.


    #changing the server port
	server.port=8080                                                    (The application runs on 8080 port)

	#db specific properties
	spring.datasource.url=jdbc:mysql://localhost:3306/{database name}   (Replace the DB name as per MySQL db)
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.datasource.username={db_username}                               (Replace username with MySQL username)
	spring.datasource.password={db_password}                               (Replace password with MySQL password)

	#ORM s/w specific properties
	spring.jpa.hibernate.ddl-auto=update                               
	spring.jpa.show-sql=true

After configuring application.properties file open this file chatbot\src\main\java\com\chatbot\ChatbotApplication.java and run as SpringBootApplication

### Database operations  ###
To create database

* create database chatbot;

To use database

* use chatbot;

To see all the tables present

* show tables;

To retrieve all users:

* select * from user;


To retrive all conversation:

* select * from chat_message;

To retrive chat of particular user

* select c.id,u.username,c.message,c.response from chat_message c inner join user u on c.user_id=u.id where u.id={id of user};