###  Spring Boot Application with Spring MVC, REST API, and MySQL Integration

## Objective:

- Create a Spring Boot application that integrates Spring MVC and Spring Data JPA.
- Build a REST API that accepts JSON requests.
- Map JSON data to a Java object using Spring Data JPA.
- Insert the mapped data into a MySQL database table using JPA and Hibernate.



**Tools & Technologies:**

- Spring Boot(Starter Dependency)
- Spring Data JPA(Dependency)
- MYSQL(Database/Connector jar)
- Hibernate
- Maven or Gradle (for dependency management)

## Task Description

1. Set up a Spring Boot project with the necessary dependencies.
2. Configure the application to connect to a MySQL database.
3. Create a JPA entity to map to a MySQL table.
4. Implement a repository interface to handle Read and Insert operations.
5. Create a service class to encapsulate business logic.
6. Develop a REST controller to expose Insert operations as API endpoints.
7. Run and Test the application.

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


2. <font size="10">Configure the Application(application.properties)	</font>
- Open the application.properties file and configure the database connection:

```
# Database Configuration
spring.datasource.url = jdbc:mysql://localhost:3306/experiment3
spring.datasource.username=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

3. <font size="5">Create a Java entity class that maps to the MySQL table</font>

- Create a new Java Entity class `Student.java` with the following code:

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

create a service class that uses the repository to insert data:

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

- create a controller class that performs the insert operation:

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



