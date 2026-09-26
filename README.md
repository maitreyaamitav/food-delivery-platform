# Food Delivery Platform

Backend-first microservices architecture for a food delivery application.  
This repository contains multiple Spring Boot services, a shared PostgreSQL schema, and supporting artifacts for QA, DevOps, and future mobile evolution.

---

## 📂 Project Structure
food-delivery-platform/
├── pom.xml                # Parent POM with dependency management
├── api-gateway/           # Spring Cloud Gateway
├── common-library/        # Shared technical contracts (errors, tracing, security helpers)
├── user-service/          # User registration, login, profile, address
├── restaurant-service/    # Restaurant and menu browsing
├── order-service/         # Order lifecycle and outbox events
├── payment-service/       # Payment initiation, callbacks, refunds
├── delivery-service/      # Delivery partner assignment and tracking
├── notification-service/  # Event-driven notifications
├── ui-web/                # Thin React/TypeScript UI for QA
├── database/migration/    # Flyway migration scripts
├── postman/               # API collections
├── jmeter/                # Performance test plans
└── docs/                  # API docs, ADRs, technical design


---

## 🚀 Technology Stack

- **Language/Runtime**: Java 21  
- **Framework**: Spring Boot 3.x  
- **Gateway**: Spring Cloud Gateway  
- **Persistence**: Spring Data JPA / Hibernate  
- **Database**: PostgreSQL 16+  
- **Migration**: Flyway  
- **Messaging**: Kafka (for domain events)  
- **Testing**: JUnit 5, Testcontainers, REST Assured/Karate, Postman, JMeter  
- **UI**: Thin React/TypeScript client (later mobile with Flutter/React Native)  
- **Runtime**: Docker (Kubernetes/OpenShift later)  
- **Observability**: Actuator, Micrometer, OpenTelemetry, Prometheus/Grafana  

---

## ⚙️ Setup Instructions

1. **Clone the repo**
   ```bash
   git clone <repo-url>
   cd food-delivery-platform
2. Configure Java & Maven
  Install JDK 21 and set JAVA_HOME.
  Ensure Maven 3.9+ is installed.
3. Database
  Install PostgreSQL 16+ locally or use Docker Compose.
  Default connection: jdbc:postgresql://localhost:5432/postgres  
  Username: postgres  
  Password: postgres
  Schema: food_delivery
4. Run migrations
  Flyway scripts are located in each service under src/main/resources/db/migration
5. Build all modules
   mvn clean install
6. Run services
  cd user-service
  mvn spring-boot:run
  Repeat for other services (restaurant-service, order-service, etc.).

