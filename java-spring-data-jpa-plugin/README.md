## Java Spring Data JPA Plugin

The **java-spring-data-jpa-plugin** is a plugin to enable and configure Spring Data JPA in Spring Boot Java applications.

Applying this plugin into a Spring Boot project will prepare and configure it for all those features:

1. Enables and configures Spring Data JPA using the specified database;
2. Configures Hibernate following good practices for high performance and throughput;
3. Configures HikariCP connection pool following good practices for high performance and throughput;
4. Configures application to run Spring Boot integration tests using TestContainers so that you can write good tests to validate properly your persistence layer and SQL queries;
5. Configures Docker Compose so that you can run your application locally;

All configuration and tuning is done for the specified database. At this moment, these are the supported databases:

- H2
- PostgreSQL
- MySQL

New databases will be supported soon 😊

[See here the benefits and how to use the Java Spring Data JPA Plugin](https://www.youtube.com/watch?v=amlI3pHkyh8)

## Support

If you need any help, please open an [issue on Plugin's Github repository](https://github.com/rafaelpontezup/java-spring-data-jpa-plugin/issues).