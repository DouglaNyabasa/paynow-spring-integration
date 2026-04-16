# Paynow Integration with Spring Boot

This project demonstrates how to integrate Paynow with a Spring Boot application. 

## Prerequisites

In order to make use of this project, the following prerequisites must be met:

1. **Developer Account**: Set up your developer account to obtain an integration ID and key. You can register [here](https://www.paynow.co.zw/Customer/Register).
2. **Java JDK**: Ensure that you are using Java JDK 7 or higher.

## Setting Up Properties

Set the properties in your `application.yaml` file as follows:

```yaml
spring:
  application:
    name: PaynowSpringBootIntegration

  datasource:
    url: jdbc:h2:mem:paynowdb
    driverClassName: org.h2.Driver
    username: sa
    password: ""
  h2:
    console:
      enabled: true
      path: /h2-console

paynow:
  integration:
    id: ${INTERGRATION_ID}
    key: ${INTERGRATION_KEY}
  result:
    url: http://localhost:8080/api/payments/update
  return:
    url: http://localhost:63342/Paynow-Intergration/paynow-Integration/static/payment-complete.html?_ijt=qeam4s4e8fhs9imbo4qb07r9g7&_ij_reload=RELOAD_ON_SAVE

server:
  port: 8080

spring:
  mvc:
    static-path-pattern: /static/**
  resources:
    static-locations: classpath:/static/
```



## Running the Project

Once you have set up the properties, you can run the project. Ensure that your environment is configured correctly with the necessary dependencies.

## Endpoints
Create Payment
Method: POST
```
URL: http://localhost:8080/api/payments/createPayment
```

## Payload:
Json
  ```{
    "invoiceNumber": "INV-10023",
    "email": "ENTER-YOUR-EMAIL-HERE@gmail.com",
    "cartDescription": "Monthly Grocery Order",
    "items": [
        {
            "name": "Wireless Mouse",
            "price": 1.0
        }
    ]
}
