🍔 Food Delivery Application

A Java Spring Boot–based backend system for managing food delivery operations — including menus, orders, and restaurants.
It provides a RESTful API with database integration and automated testing.

🚀 Features

🧾 Manage menus (CRUD for food items)

🛍️ Place and track orders

👨‍🍳 Add or remove restaurants

🧠 Layered architecture (Controller → Service → Repository)

🧪 Unit tests with JUnit and Spring Boot Test

📘 Swagger UI for interactive API documentation

💾 H2 (in-memory) or MySQL database support

Tech Stack
Category	Technology
Language	Java 17+
Framework	Spring Boot
Build Tool	Maven
Database	MySQL
Testing	JUnit 5
Documentation	Swagger / Springdoc OpenAPI
 Setup Instructions
 Clone the Repository
git clone https://github.com/your-username/food-delivery-application.git
cd food-delivery-application

Build the Project
./mvnw clean install

Run the Application
./mvnw spring-boot:run


The app runs by default at:
http://localhost:8080

🧩 Project Structure
food-delivery-application/
├── src/
│   ├── main/
│   │   ├── java/com/example/fooddelivery/   # Application code
│   │   └── resources/
│   │       ├── application.properties       # Configurations
│   │       ├── static/                      # Static files (if any)
│   │       └── templates/                   # Thymeleaf (if UI used)
│   └── test/java/com/example/fooddelivery/  # JUnit tests
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md

Database Configuration

🐬 MySQL

To use MySQL instead, update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

 API Documentation (Swagger Setup)

Swagger UI is automatically enabled using Springdoc OpenAPI.

Add Dependency (in pom.xml)
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>

 Access the Swagger UI

Once the app is running, open:

 http://localhost:8080/swagger-ui.html

You’ll see all endpoints for menu, order, and restaurant management.

Example API Endpoints
Method	Endpoint	Description
GET	/api/menu	Retrieve all menu items
POST	/api/menu	Add a new item
PUT	/api/menu/{id}	Update existing item
DELETE	/api/menu/{id}	Delete item
GET	/api/orders	List all orders
POST	/api/orders	Place an order
Running Tests

Run the test suite with:

./mvnw test


Example test class:

FoodDeliveryApplicationTests.java

🧠 Future Improvements

Authentication & role-based access

Payment gateway integration

Delivery tracking

Frontend (React or Angular)

👩‍💻 Author
Amirkhan Nurgul
nurgulamirkhanb@gmail.com

