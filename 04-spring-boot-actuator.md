# Spring Boot Actuator

## Install Spring Boot Actuator Plugin

- Add `spring-boot-starter-actuator` to [pom.xml](/pom.xml).

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
  ```

## Spring Boot Actuator Endpoint

- [There are number of endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.endpoints).
- [Enable Endpoint](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.endpoints.enabling) using [application.properties](/src/main/resources/application.properties) file.
- Enable all endpoints in actuator - `management.endpoints.web.exposure.include=*`.
- The [default endpoint](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#application-properties.actuator.management.endpoints.web.base-path) in `/actuator`.
- [***Custom management server port***](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.monitoring.customizing-management-server-port). 

## Monitor and Management Over HTTP.

- Using promtheus to grab a metrics from spring boot actuator.
- Enable prometheus support by adding `micrometer-registry-prometheus` dependency to a [pom.xml](pom.xml).
- The endpoint `/actuator/prometheus`.

## Create Custom Metrics

- [Getting started](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.metrics.getting-started).
- [Prometheus metric types](https://prometheus.io/docs/concepts/metric_types/).
    1. Counter. Example of [StudentController](/src/main/java/com/github/alochym/student/StudentsController.java) with URL `api/v1/student/`.
        1. Create a Counter - `studentCounter`.
        1. Initial constructor with `studentCounter`
        1. Register `studentCounter` to `MeterRegistry`.
    1. Gauge.
    1. Histogram.
    1. Summary.
- [Micrometer metric Types]().
    1. [Counter](https://micrometer.io/docs/concepts#_counters).
    1. [Gauges](https://micrometer.io/docs/concepts#_gauges).
    1. [Timer](https://micrometer.io/docs/concepts#_timers).
## Enable Tracing

- TODO in future.