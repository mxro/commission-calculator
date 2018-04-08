[![Build Status](https://travis-ci.org/mxro/commission-calculator.svg?branch=master)](https://travis-ci.org/mxro/commission-calculator)

[![Known Vulnerabilities](https://snyk.io/test/github/mxro/commission-calculator/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/mxro/commission-calculator?targetFile=pom.xml)

# commission-calculator

A web-based calculator for commissions implemented using Spring 5.

The Maven site for this project is available here:

[https://mxro.github.io/commission-calculator/](https://mxro.github.io/commission-calculator/)

## Environment

This application requires:

- Java 1.8+
- Maven 3.5.0+

## Build

To build this application, check out the source code and run:

```
mvn package
```

## Test

To run the unit tests defined for this project:

```
mvn test
```

## Run Embedded Server

To launch the application using an embedded Jetty server:

```
mvn jetty:run
```

## Maven Site

This project can generate a Maven site and upload it automatically to GitHub pages. This requires that a valid `github` server is defined in the Maven settings.

```
mvn site
```

## Deployment

Building this application using `mvn package` will yield in the creation for a war file in the `target/` folder. This war file can be deployed on Jetty/Tomcat etc. servers.

