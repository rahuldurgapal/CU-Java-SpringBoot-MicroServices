### Spring MVC Application: User Registration and Login

This documentation will guide you through creating a Spring MVC application that allows users to register and log in. The application will include a registration form for collecting user details and a login form for authenticating users. We'll use Spring Boot, Spring Data JPA, and Thymeleaf for this purpose.

## Objective:

- To create a Spring MVC application that allows users to register with their details and log in using their credentials.



**Tools & Technologies:**

- Spring Boot (Starter Dependency)
- Spring MVC (Web Dependency)
- Spring Data JPA (Dependency)
- MySQL (Database/Connector jar)
- Hibernate (ORM)
- Thymeleaf (Template Engine)
- Maven or Gradle (for dependency management)

## Task Description

1. Set up a Spring Boot project with the necessary dependencies.
2. Configure the application to connect to a MySQL database.
3. Create JPA entities to map to MySQL tables.
4. Implement repository interfaces to handle register operations.
5. Create service classes to encapsulate business logic.
6. Develop controllers for handling registration and login.
7. Develop Thymeleaf templates for registration and login forms.
8. Run and test the application.


**Step to Folow:**

1. <font size="5">Create a new Spring Boot(MVC) Project</font>

- Create a new Spring Boot project using your preferred IDE or by using the Spring Initializer tool. Add the following dependencies to the `pom.xml` file (if using Maven)

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

	<dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-thymeleaf</artifactId>
    <version>3.3.3</version>
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

- Create a new java Entity class `User.java` with the following code:


```java
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    //Getter & Setter Methods
}

```

4. <font size="5">Create a Repository Interface:</font>

- Define a repository interface for the `User` entity:

```java
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String username);
}
```

5. <font size="5">Create a Service Class:</font>

create a service class that uses the repository to insert and check the user authentication

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByName(username);
    }

    public boolean authenticateUser(String username, String password) {
        User user = findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

}
```

6. <font size="5">Create the Controller Class:</font>

- create a controller class that performs the register and login operation:

```java
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
         model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/authenticate")
    public String loginUser(@ModelAttribute User user, Model model) {
        if(userService.authenticateUser(user.getName(), user.getPassword())) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error","Invalid Username and Password");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }

}
```

7. <font size="5">Run The Application</font>
- Run the Application using your IDE or the command line:

8. <font size="5">Test The Application</font>
- Use tools like Postman to test the endpoints:



