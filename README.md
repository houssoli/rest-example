Note that this is a fork from the project rest-example:

[REST-Example](https://github.com/krizsan/rest-example.git)

Example RESTful web service implemented with Spring Boot, JAX-RS and RxJava.
This is the version with asynchronous JAX-RS server-side request processing and with RxJava.
Please refer to the "before" branch for the version without asynchronous JAX-RS and RxJava.

To load-test this application, first start the RestExampleApplication and then start the load-tests using mvn gatling:test.
The load-test report can be found in the target/gatling directory.

The articles for which this example program was developed can be found here:
- [rest-with-asynchronous-jersey-and-rxjava-part-1](ttps://www.ivankrizsan.se/2016/11/19/rest-with-asynchronous-jersey-and-rxjava-part-1/)
- [rest-with-asynchronous-jersey-and-rxjava-part-1](https://www.ivankrizsan.se/2016/11/25/rest-with-asynchronous-jersey-and-rxjava-part-2/)
- [rest-with-asynchronous-jersey-and-rxjava-part-1](https://www.ivankrizsan.se/2016/12/17/rest-with-asynchronous-jersey-and-rxjava-part-3/)
- [rest-with-asynchronous-jersey-and-rxjava-part-1](https://www.ivankrizsan.se/2016/12/29/rest-with-asynchronous-jersey-and-rxjava-part-4/)

It should soon offer in addition a GraphQL implementation of the Rest-Example API like, based on :
- [GraphQL API](http://graphql.org/)
- [GraphQL JAVA](https://github.com/graphql-java/graphql-java.git)

Running the example :

At this point our application should work. Since we have used the spring-boot-starter-parent POM we have a useful run goal that we can use to start the application.
Type `mvn spring-boot:help` to for more details.
Type `mvn spring-boot:run` from the root project directory to start the application:

`$ mvn spring-boot:run -Dserver.port=8080`

The server should now be waiting requests at `localhost:8080`.
To gracefully exit the application hit `ctrl-c`.