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
- Configure the Application(application.properties)	

```
# Database Configuration
spring.datasource.url = jdbc:mysql://localhost:3306/experiment1
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

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
```

6. <font size="5">Create the Main Application Class</font>

- Modify the main application class to call the service methods based on user input.

```java
@SpringBootApplication
public class Experiment3Application implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Experiment3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new Student");
            System.out.println("2. Show all Students");
            System.out.println("3. Exit");
            System.out.println("\nChoose the given Option");

            int x = sc.nextInt();
            sc.nextLine();  // Consume the newline left-over after nextInt()

            switch (x) {
                case 1:
                    String name, address;
                    Student student = new Student();
                    System.out.println("Enter the Student Name");
                    name = sc.nextLine();
                    System.out.println("Enter the Student Address");
                    address = sc.nextLine();
                    student.setName(name);
                    student.setAddress(address);
                    studentService.insertStudent(student);
                    System.out.println("Student Saved Successfully");
                    break;

                case 2:
                    List<Student> students = studentService.getStudents();
                    System.out.println("All Students");
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Address: " + s.getAddress());
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;  

                default:
                    System.out.println("Please choose a correct option");
            }
        }
    }
}
```

7. <font size="5">Run The Application</font>
- Run the Application using your IDE or the command line:

8. <font size="5">Test The Application</font>
- Use tools like Postman to test the endpoints:



