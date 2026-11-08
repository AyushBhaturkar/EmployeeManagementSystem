# Employee Management System (Spring Boot REST API)

Java 17 | Spring Boot 3 | Spring Data JPA (Hibernate) | MySQL | Swagger UI

Layered architecture: Controller -> Service -> Repository -> MySQL

## Features
- CRUD APIs for employees
- Filter employees by department
- Bean Validation on request body
- Global exception handling (@RestControllerAdvice)
- Swagger UI for API docs and testing

## Run kaise karein
1. Install: JDK 17, Maven (ya IDE ka built-in Maven), MySQL
2. `src/main/resources/application.properties` mein apna MySQL password daalo
3. Terminal mein project folder ke andar:
   ```
   mvn spring-boot:run
   ```
   (Eclipse/STS: Import -> Existing Maven Project -> EmployeeManagementApplication.java -> Run As -> Java Application)
4. App chalu hoga: http://localhost:8080
5. Swagger UI: http://localhost:8080/swagger-ui.html

## API endpoints
| Method | URL | Kaam |
|--------|-----|------|
| POST   | /api/employees | Naya employee add |
| GET    | /api/employees | Sab employees |
| GET    | /api/employees?department=IT | Department filter |
| GET    | /api/employees/{id} | Ek employee |
| PUT    | /api/employees/{id} | Update |
| DELETE | /api/employees/{id} | Delete |

## Sample request (POST /api/employees)
```json
{
  "name": "Ravi Sharma",
  "email": "ravi@example.com",
  "department": "IT",
  "salary": 45000
}
```

## curl se test
```
curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d "{\"name\":\"Ravi Sharma\",\"email\":\"ravi@example.com\",\"department\":\"IT\",\"salary\":45000}"
curl http://localhost:8080/api/employees
curl http://localhost:8080/api/employees/1
curl -X DELETE http://localhost:8080/api/employees/1
```
