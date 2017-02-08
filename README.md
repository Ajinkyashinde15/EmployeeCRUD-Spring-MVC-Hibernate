# EmployeeCRUD-Spring-MVC-Hibernate
Demonstrates the capabilities of the Spring MVC web framework through small, simple examples. I have created web services REST API using Spring Web MVC framework with Hibernate technology. REST API tested and constructed requests. No GUI has been created. 

Before going any further, I’d like to talk about the benefits of Spring annotated controllers. The best way to illustrate this is to first look at a piece of code, specifically a bean with Spring annotations. The first annotation is on the class itself, simply indicating that the class is a Spring RestController:

# RestController

@RestController
public class EmployeeCRUDController {

}

# RequestMapping

This is all that is needed for Spring to recognize this class as a Spring MVC controller. Now let’s look at a method and its annotations:

@RequestMapping(method= RequestMethod.GET,value="/newemployee/{id}",headers="Accept=application/xml, application/json")
public @ResponseBody String getHello(@PathVariable String id) {
    return new Employee(id,"Ajinkya","Dublin","DELL","23233");
}

Most of the annotations are the same as in the case of the first method, but you will note that we now have a method parameter called world of type String and that has a @PathVariable annotation. This annotation tells Spring annotations handlers that they will need to resolve the value for this variable from the URL. If you look at the method mapping, we have added a {id} marker that is used to indicate where in the URL we should look for a value for the world method parameter. So for example URLs such as these will match the URL mapping :

http://localhost:8080/Employee/employee/1212323


Technologies/Frameworks Used:-
1. Java
2. JSP 
3. Spring 4
4. Hibernet
5. Maven building project management tool
6. Netbeans IDE

In this project you'll see the following in action:
* The simplest possible @RestController
* Mapping Requests
* Annotation
* Spring Bean XML
* Hibernet Session and Transaction
* Obtaining Request Data
* Generating Responses
* Rendering Views
* Exception Handling

# To get the code:

Clone the repository:

$ git clone git://github.com/Ajinkyashinde15/EmployeeCRUD-Spring-MVC-Hibernate.git
If this is your first time using Github, review http://help.github.com to learn the basics.

# To run the application:

From the command line with Maven:

$ cd spring-mvc-showcase
$ mvn tomcat7:run [-Dmaven.tomcat.port=<port no.>] (In case 8080 is busy] 
or

In your preferred IDE such as SpringSource Tool Suite (STS) or IDEA:

Import spring-mvc-showcase as a Maven Project
Drag-n-drop the project onto the "SpringSource tc Server Developer Edition" or another Servlet 2.5 or > Server to run, such as Tomcat.
Access the deployed web application at: http://localhost:8080/Employee/

# Add new employee:

Markup : ![picture alt](https://github.com/Ajinkyashinde15/EmployeeCRUD-Spring-MVC-Hibernate/blob/master/add%20emp.png "Add new Employee")

# Get employee by ID:

Markup : ![picture alt](https://github.com/Ajinkyashinde15/EmployeeCRUD-Spring-MVC-Hibernate/blob/master/show%20emp1.png " Get employee by ID")

# Show employees:

Markup : ![picture alt](https://github.com/Ajinkyashinde15/EmployeeCRUD-Spring-MVC-Hibernate/blob/master/show%20emp.png "Get Employees")



