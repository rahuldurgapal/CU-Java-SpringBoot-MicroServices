### Spring Boot Application for Inserting and Retrieving Data Using JPA and Hibernate

## Objective:

- Create a Spring Boot application that integrates Spring Data JPA, Hibernate, and either MySQL or PostgreSQL
- Map a database table to a Java object using Spring Data JPA.
- Insert data into the database table using console input
- Retrieve data from the database and display it on the console.


**Tools & Technologies:**

- Java Development Kit (JDK) 8 or higher
- Spring Boot CLI or IDE (e.g., IntelliJ IDEA, Eclipse)
- MySQL or PostgreSQL Database
- Maven or Gradle (for dependency management)

## Task Description

1. Set up a Spring Boot project with dependencies for Spring Data JPA, Hibernate, and either MySQL or PostgreSQL.
2. Configure the database connection in the application.properties file to connect the Spring Boot application to your chosen database.
3. Create a JPA entity class that represents a table in the database. Annotate the class with JPA annotations like @Entity and @Table.
4. Create a JPA repository interface that extends JpaRepository to provide basic CRUD operations for the entity.
5. Develop a service class that handles inserting and retrieving data from the database using console input.
6. Modify the main application class to interact with the service class, allowing users to input data through the console and choose options for data insertion or retrieval.
7. Run the application and test its functionality by entering data via the console, verifying that the data is correctly inserted into the database, and retrieving it for display.

**Step to Folow:**

1. <font size="5">Create a new Spring Boot project with the necessary dependencies</font>

- Open your IDE and create a new Spring Boot project. You can use Spring Initializr or your IDE’s built-in tools.
- Add the following dependencies:
    Spring Data JPA
     MySQL Driver or PostgreSQL Driver (depending on your database choice)

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```


2. <font size="10">Create a new Spring Boot project with the necessary dependencies</font>
- Open the application.properties file and configure the database connection:

```
# Database Configuration
spring.datasource.url = jdbc:mysql://localhost:3306/experiment
spring.datasource.username=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

3. <font size="5">Create a Java entity class that maps to the MySQL table</font>

- Create a new Java Entity class Student.java with the following code:

```java
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    //Getters & Setters
}

```

4. <font size="5">Create a Repository Interface:</font>

- Define a repository interface for the `Student` entity:

```java
 @Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
      
    
}
```

5. <font size="5">Create a Service Class:</font>

create a service class that uses the repository to insert and retrieve data:

```java
@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student) {
       
        return studentRepository.save(student);
    }
}
```

6. <font size="5">Create the Controller Class:</font>

- create a controller class that performs the insert and retrieve operation:

```java
@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);

    }
}
```

7. <font size="5">Run The Application</font>
- Run the Application using your IDE or the command line:

8. <font size="5">Test The Application</font>
- Use tools like Postman to test the endpoints:



