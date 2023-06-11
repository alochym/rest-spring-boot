# Spring Boot logging JSON format

- [Reference Logger](https://stackify.com/logging-logback/).
- [https://community.pivotal.io/s/article/how-to-configure-access-log-entries-for-a-spring-boot-app?language=en_US](https://community.pivotal.io/s/article/how-to-configure-access-log-entries-for-a-spring-boot-app?language=en_US).
- [https://logback.qos.ch/](https://logback.qos.ch/).
- [loback-access](https://github.com/jochenchrist/spring-boot-access-logs-demo).
- [logstash-logback-encoder](https://github.com/logfellow/logstash-logback-encoder).
- [logback-acces Access Pattern](https://logback.qos.ch/manual/layouts.html#AccessPatternLayout).
- Logging 
- Log Level
    1. FATAL.
    1. ERROR.
    1. WARN.
    1. INFO.
    1. DEBUG.
    1. TRACE.
    1. OFF.

## Using Maven CLI

- Check packages dependency - `.\mvnw dependency:tree`

## Spring Boot Access Log

1. Logging to console.
1. Add dependency `logback-access` and `loggstash-logback-encoder` to a [pom.xml](./pom.xml).

   ```xml
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-access</artifactId>
    </dependency>

    <dependency>
        <groupId>net.logstash.logback</groupId>
        <artifactId>logstash-logback-encoder</artifactId>
        <version>6.2</version>
    </dependency>  
   ```

1. [Add logback=access.xml](/src/main/resources/logback-access.xml). 
1. Logback configuration hase there layer;
    1. Logger.
    1. Appender.
    1. Layout.
1. Add [AccessLogsConfiguration.java](/src/main/java/com/github/alochym/AccessLogsConfiguration.java) for logback-access to tomcat web server log

   ```java
    package com.github.alochym;

    import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
    import org.springframework.boot.web.server.WebServerFactoryCustomizer;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    import ch.qos.logback.access.tomcat.LogbackValve;

    @Configuration
    public class AccessLogsConfiguration {

        @Bean
        public WebServerFactoryCustomizer<TomcatServletWebServerFactory> accesslogsCustomizer() {
            return factory -> {
                var logbackValve = new LogbackValve();
                logbackValve.setFilename("logback-access.xml");
                logbackValve.setAsyncSupported(true);
                factory.addContextValves(logbackValve);
            };
        }
    }
   ```

1. Start spring boot app - `.\mvnw spring-boot:run`.

## Spring Boot App Log

- Create [logback-spring.xml](/src/main/resources/logback-spring.xml).
- In StudentController class

  ```java
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  ...
  private Logger logger = LoggerFactory.getLogger(StudentsController.class);
  // logging custom headers
  logger.error(headers.toString());
  ```

- Using curl cli - `curl.exe -XGET localhost:8080/api/v1/students/ -vvv`.

### Mapped Diagnostic Context (MDC)

- TODO: need an example
- [MDC reference example](https://www.innoq.com/en/blog/structured-logging/#mdc).
