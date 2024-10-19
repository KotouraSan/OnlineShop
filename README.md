# Online Shop Backend 🛒

This project is the backend for an **Online Shop** system, developed using **Spring Boot** and **Gradle**. The application provides a robust microservices architecture to manage customers, authentication, shopping, and order processing, with a focus on scalability, performance, and secure user management.

## Technologies Used

- **Java 20**: Primary programming language.
- **Spring Boot**: For building each microservice with REST APIs.
- **Gradle**: For managing project dependencies and build configurations.
- **PostgreSQL**: Used as the primary database for persisting customer, product, and order data.
- **Spring Security 6.1**: For securing API endpoints and managing user authentication.
- **JWT (JSON Web Token)**: For handling stateless authentication and authorization.
- **Redis**: Used for caching and storing session data for performance improvement.
- **Docker**: For containerizing microservices and managing service orchestration.
- **Eureka (Spring Cloud Discovery Service)**: For service discovery, allowing microservices to locate each other dynamically.
- **Spring Cloud Gateway**: For routing requests to the appropriate microservices and providing a unified entry point.
- **Zipkin**: For distributed tracing, allowing monitoring of requests as they flow through microservices.
- **Spring Cloud Config**: For centralized configuration management across all microservices.
- **H2 Database**: In-memory database used for testing and development purposes.
  
## Microservices

1. **Customer Service**: Manages customer profiles, and updates.
2. **Auth Service**: Handles user authentication and JWT token generation.
3. **Shop Service**: Manages the product catalog, inventory, and shopping cart operations.
4. **Order Service**: Responsible for order creation, payment processing, and order tracking.
5. **API Gateway**: Routes client requests to the appropriate microservice, handling load balancing and security.
6. **Discovery Service (Eureka)**: Ensures all microservices can dynamically discover and communicate with each other.
7. **Config Server**: Provides centralized configuration for all microservices, ensuring consistency and easy updates.

## Features

- **JWT-based Authentication**: Secures all microservices using stateless JWT tokens for authentication.
- **Role-Based Access Control**: Different endpoints are secured based on roles (e.g., customer, admin).
- **Distributed Caching**: Redis is used to cache frequently accessed data for improved performance.
- **Service Discovery**: Eureka ensures that services can register and locate each other dynamically.
- **API Gateway**: Provides a single entry point for all external traffic, managing routing and load balancing.
- **Centralized Configuration**: Spring Cloud Config allows for externalized configuration management.
- **Distributed Tracing**: Zipkin traces requests across microservices, providing performance insights.

## Architecture

This project uses a microservices architecture, where each service is independently developed, deployed, and scaled. Each service is containerized using **Docker**, and **Docker Compose** is used to orchestrate the local development environment.

### Key Components:
- **Customer Service**: Manages customer data.
- **Auth Service**: Provides secure login with JWT tokens.
- **Shop Service**: Handles the product catalog and shopping cart.
- **Order Service**: Manages order creation, payment, and status tracking.
- **Eureka Discovery Server**: Manages dynamic service registration and discovery.
- **Spring Cloud Gateway**: Central point of entry for requests, handles routing and load balancing.
- **Redis**: Provides caching for performance optimization.
- **PostgreSQL**: Main relational database system for storing persistent data.

## Running the Project

### Prerequisites
- **Java 20**
- **Docker & Docker Compose**
- **Gradle**
- **Postgres** installed or use Docker for the database
