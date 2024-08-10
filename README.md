# Getting Started

A starter template for java spring boot with Docker

## Requirements
```
Java 17
Gradle 8
Tomcat 10
```

## Run Locally
```
./gradlew bootRun
```

## Run in Docker
```
docker-compose build
docker-compose up -d
```

## Test
```
1. HealthCheck
curl -i -XGET http://localhost:8080/api/v1/hello
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 31
Date: Thu, 08 Aug 2024 15:26:39 GMT

{"message":"Hello, Spring Boot With Docker!"}

2. List Messages
curl -i -XGET http://localhost:8080/api/v1/messages
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 10 Aug 2024 05:22:56 GMT

["{\"message\": \"Test\"}}"]

3. Add Messages
url -i -XPOST -H 'Content-Type: application/json' -d '{"message": "Test"}}'  http://localhost:8080/api/v1/messages
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 35
Date: Sat, 10 Aug 2024 05:22:41 GMT

Message added: {"message": "Test"}}
```