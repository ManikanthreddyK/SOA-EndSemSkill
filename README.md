# Path Rewriting in Spring Cloud API Gateway

A small two-service Maven project demonstrating public-to-internal URL rewriting.

## Requirements
- JDK 17 or later
- Maven 3.8+
- IntelliJ IDEA / Eclipse (optional)
- Postman or a browser

## Project structure
- `account-service`: backend service on port **8081**
- `api-gateway`: public gateway on port **8080**

## Run the project

Open a terminal in the project root and build:

```bash
mvn clean package
```

Start the Account Service in terminal 1:

```bash
mvn -pl account-service spring-boot:run
```

Start the API Gateway in terminal 2:

```bash
mvn -pl api-gateway spring-boot:run
```

## Test

Send this GET request using Postman or a browser:

```http
http://localhost:8080/accounts/101
```

The gateway matches `/accounts/**` and rewrites the path to:

```http
http://localhost:8081/api/v1/internal/accounts/101
```

Expected response:

```text
Account details for account ID: 101
```

## Important concepts
- `Path=/accounts/**`: route predicate; matches public account URLs.
- `RewritePath`: changes the incoming path before forwarding.
- Port `8080`: API Gateway.
- Port `8081`: Account Service.

Note: This project uses `RewritePath` (not `StripPrefix`) because the target controller
expects the full internal path `/api/v1/internal/accounts/{id}`.
