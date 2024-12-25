# SpringBoot-DTO-DockerCompose-With-Mariadb

## Overview
This project demonstrates a Spring Boot application that uses DTO (Data Transfer Object) patterns, integrated with MariaDB and Docker Compose for containerized deployment.

## Dependencies
The following dependencies are included in the project:

- **Spring Web**: For building REST APIs.
- **Spring Boot DevTools**: For faster development.
- **Spring Data JPA**: For ORM functionality.
- **MariaDB Driver**: For database connectivity.
- **ModelMapper**: For DTO mapping.

## Classes and Interface
- **Book**: Entity class representing the `Book` model.
- **BookController**: REST controller managing the API endpoints.
- **BookRepository**: JPA repository interface for interacting with the database.
- **BookDTO**: Data Transfer Object for the `Book` entity.
- **BookDTO2**: Alternative Data Transfer Object.
- **BookInterface**: Interface representing business logic.

## Endpoints
The following API endpoints are provided:

- `@RequestMapping("/test")`: Test endpoint.

- `@PostMapping("/save")`: Save a new book record.

- `@GetMapping("/all")`: Retrieve all book records.

- `@GetMapping("/{id}")`: Retrieve a book by ID.

- `@GetMapping("/dto/id/{id}")`: Retrieve a book DTO by ID.

## Configuration

### application.properties
```properties
spring.application.name=springboot-Mariadb-DTO-DTO2-Interface-ModelMapper
spring.datasource.url=jdbc:mariadb://localhost:3306/dtodatabase
spring.datasource.username=root
spring.datasource.password=priyanka
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

### Dockerfile
```dockerfile
FROM openjdk:17

ADD target/Bookapptest.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
```

### docker-compose.yml
```yaml
version: "3.8"
services:
  app:
    image: springboot-book-app
    build:
      context: .
    ports:
      - 8989-9000:8080
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mariadb://db:3306/dtodatabase
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: priyanka
      SPRING_JPA_HIBERNATE_DDL_AUTO: update

  db:
    image: mariadb:latest
    container_name: mariadb
    environment:
      MYSQL_ROOT_PASSWORD: priyanka
      MYSQL_DATABASE: dtodatabase
    ports:
      - 3306-4000:3306
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

## Running the Application
1. Clone the repository.
2. Build the Spring Boot application using Maven or Gradle.

3. Build and run the containers with Docker Compose:

   ```bash
   docker-compose up --build
   ```
4. Access the application at `http://localhost:8989`.

## License
This project is licensed under the MIT License. Feel free to use and modify the code as needed.
