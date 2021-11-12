![image](https://user-images.githubusercontent.com/42575272/140438438-fbdd8ec9-c545-4647-a299-c6edc2344b7a.png)

# Proxy Server Exercise (Lean Tech - Project 44)

This test is about a simple proxy server that logs the headers of all the HTTP requests ir forwards. For this, I used Java, Spring boot and Zuul Proxy (Spring Cloud Netflix). With Zuul this is very easy to implement because it is perfectly integrated with Spring Boot. The package structure of the project is the following:

![image](https://user-images.githubusercontent.com/42575272/140436833-10acd659-704e-46b2-b2b9-2d96443c69e9.png)

- In the main package we have the SimpleFilter class that extends of ZuulFilter abstract class where the 'run' method is located (overrided) and in this we get the RequestContext for create the logs with the headers and other information.
- In the ... /config package we have the configuration beans for SimpleFilter.
- In the src/main/resources we have the application.properties file where we specify the paths and urls for the proxy server.

![image](https://user-images.githubusercontent.com/42575272/140437283-72d27804-51a9-4286-876a-d05cc74a73ef.png)

## Run the application

For run the application you only need to deploy it from an IDE like Eclipse with the Spring Boot plugin. Then, you can access to 'http://localhost:8080/lean/' or 'http://localhost:8080/google/' to see the logs in the console like this:

![image](https://user-images.githubusercontent.com/42575272/140437663-08f6bc09-7377-463f-b21c-959d163bd0a3.png)

> Accesint to the Lean Tech maing page from the proxy server.

![image](https://user-images.githubusercontent.com/42575272/140437757-dbf85acb-ec6a-4e42-9119-68247254d27c.png)

> Log in the console of eclipse with a simple structure where we have the fields 'Server', 'Method' and 'Path' and all the headers of the request.

![image](https://user-images.githubusercontent.com/42575272/140438100-ca1b4ff2-0bc5-487c-9abd-899080f4724b.png)

> Example with 'http://localhost:8080/lean/nearshore/satellite-office

![image](https://user-images.githubusercontent.com/42575272/140438000-50ab3827-c2f4-47bf-b1a9-741a1ee46e64.png)

> Example with 'http://localhost:8080/google/'

## Comments

I want to thank again for the opportunity. Any questions with the test can contact me at my email. I will be attentive to any questions or steps to follow in the process. All the best!

