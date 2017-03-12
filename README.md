# MYAPP-1.0.0-SNAPSHOT

Single page web application which uses nowadays known technologies.

## Used technologies
- Spring Web MVC
- Spring Security
- Mybatis
- JAXB
- Liquibase
- AngularJS

## Application features
* Authentication
* CSRF protection
* Role based authorization (ADMIN, CUSTOMER)
* Admin role:
 * Customer management (Edit, Delete(logical, physical))
 * Email sending
 * Logout
 * View Profile
* Customer role:
 * Logout
* Registration (With email notification)
* Reset password (With email notification)

## Requirements
- Application server e.g: Tomcat
- MySQL database server
- Mail server e.g: Mercury
- Mail client e.g: Thunderbird

## Configuration guide
Add the following tag to your tomcat **context.xml** with your valid db details:

    <Resource
      name="jdbc/YourDatabaseName"
      auth="Container"
      type="javax.sql.DataSource"
      maxActive="100"
      maxIdle="30"
      maxWait="10000"
      driverClassName="com.mysql.jdbc.Driver"
      url="jdbc:mysql://localhost:3306/YourDatabaseName"
      username="username"
      password="password" 
     />
  
 Mercury mail server & Mozilla Thunderbird configuration: [Mercury & Thunderbird configuration](https://schophel.wordpress.com/2015/10/14/set-up-mercury-mail-for-mailing-in-localhost-with-thunderbird-xampp/)
 
Update **liquibase.properties** with valid details in core module under **src/main/resources/properties/liquibase/** folder

    url=jdbc:mysql://localhost:3306/YourDatabaseName?useUnicode=true&characterEncoding=UTF-8
    username=username
    password=password
    driver=com.mysql.jdbc.Driver
    changeLogFile=liquibase/liquibase-master.xml 
 
Update **mail.properties** with valid details in core module under **src/main/resources/properties/mail/** folder

    mail.host=127.0.0.1
    mail.port=25
    mail.protocol=smtp
    mail.username=admin@localhost.com
    mail.password=admin
    mail.auth=mail.smtp.auth

For db deployment use the following command on core artifact:
```ruby
resources:resources liquibase:update
```

For db purge use the following command on core artifact:
```ruby
resources:resources liquibase:dropAll
```
## Demo users for the application

|   Username    |  Password    |   Role   | Account Status |
|---------------|--------------|----------|----------------|
|     admin     |  password    |  ADMIN   |     ENABLED    |
|   customer1   |  password    | CUSTOMER |    DISABLED    |
|   customer2   |  password    | CUSTOMER |     ENABLED    |

## Class diagramm
### Service Layer (Business Logic)
![Service](http://users.iit.uni-miskolc.hu/~karolyi/development/classdiagram/service.png)
### DAO Layer
![DAO](http://users.iit.uni-miskolc.hu/~karolyi/development/classdiagram/dao.png)
