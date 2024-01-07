# Tech Support App Backend Project

Hi! This is the backend part of a fake support application based on Terminator universe. This is also my first project with backend.

This project consists of 2 tables - users and tickets. Each has its' model, repository, service and controller. 

The ticket service includes the find, create, update and delete methods (full C.R.U.D).

## Frontend Link

https://github.com/MarkWebDeveloper/Tech-Support-App-Frontend

## Project Setup

No need to install any dependencies. However, you would need to create application.properties file and configure <b>api-endpoint<b> variable inside of it. It could be something like 
```sh
api-endpoint = /api/v1
```

## Run Server

```sh
mvn spring-boot:run
```

### Thank you!