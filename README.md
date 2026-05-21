# 💳 Smart Wallet Application
A modern **Spring Boot** web application for managing personal finances, including wallet management, subscriptions, and secure fund transfers.
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow?style=flat-square)
---
## 📋 Table of Contents
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Technology Stack](#-technology-stack)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Architecture](#-architecture)
- [Database Models](#-database-models)
- [Running the Application](#-running-the-application)
- [Git Commands](#-git-commands)
- [Contributing](#-contributing)
- [License](#-license)
---
## ✨ Features
### 👤 User Management
- ✅ User registration with secure password encoding (BCrypt)
- ✅ User authentication and login
- ✅ Profile management
- ✅ Role-based access (ADMIN, USER)
- ✅ Multi-country support (Bulgaria, Germany, France)
### 💰 Wallet Management
- ✅ Automatic wallet creation on registration (€20 initial balance)
- ✅ Top-up functionality (add funds)
- ✅ Charge functionality (deduct funds)
- ✅ Wallet status tracking (ACTIVE, INACTIVE)
- ✅ Balance tracking and auditing
### 📅 Subscription System
- ✅ Free DEFAULT subscription on registration
- ✅ Multiple subscription tiers (DEFAULT, STANDARD, PREMIUM, ULTIMATE)
- ✅ Subscription periods (MONTHLY, YEARLY)
- ✅ Automatic renewal for monthly subscriptions
- ✅ Subscription history tracking
### 🔄 Transaction Management
- ✅ Complete transaction logging
- ✅ Transaction types (DEPOSIT, WITHDRAWAL, TRANSFER)
- ✅ Transaction status tracking (SUCCEEDED, FAILED)
- ✅ Balance tracking and auditing
- ✅ Failure reason documentation
---
## 📁 Project Structure
```
smart-wallet-application/
├── src/
│   ├── main/
│   │   ├── java/app/
│   │   │   ├── model/
│   │   │   │   ├── entity/              # JPA Entities
│   │   │   │   │   ├── user/
│   │   │   │   │   ├── wallet/
│   │   │   │   │   ├── subscription/
│   │   │   │   │   └── transaction/
│   │   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   │   └── user/
│   │   │   │   └── mapper/              # Entity-DTO Mapping
│   │   │   │       └── user/
│   │   │   ├── repository/              # Data Access Layer
│   │   │   │   ├── user/
│   │   │   │   ├── wallet/
│   │   │   │   ├── subscription/
│   │   │   │   └── transaction/
│   │   │   ├── service/                 # Business Logic Layer
│   │   │   │   ├── user/
│   │   │   │   ├── wallet/
│   │   │   │   ├── subscription/
│   │   │   │   └── transaction/
│   │   │   ├── config/                  # Configuration Beans
│   │   │   │   └── bean/
│   │   │   ├── web/                     # Controllers (Presentation Layer)
│   │   │   └── Application.java
│   │   └── resources/
│   │       ├── application-dev.properties
│   │       ├── application-prod.properties
│   │       ├── static/                  # CSS, Images, JavaScript
│   │       └── templates/               # Thymeleaf HTML templates
│   └── test/
│       └── java/app/
├── pom.xml
├── WORKFLOW_LECTURE_1.md                # Implementation Step-by-Step Guide
├── INSTRUCTION_LAB.md                   # Technical Specifications
├── GIT_COMMANDS.md                      # Git Commands Reference
└── README.md                            # This file
```
---
## 🛠️ Technology Stack
### Backend Framework
- **Language**: Java 17
- **Framework**: Spring Boot 3.4.0
- **Build Tool**: Maven 3.6+
### Database & ORM
- **Database**: MySQL 8.0.46
- **JDBC Driver**: MySQL Connector/J 9.5.0
- **ORM**: Spring Data JPA / Hibernate
### Security
- **Password Encoding**: BCrypt (Spring Security)
- **Authentication**: Spring Security
### Frontend
- **Template Engine**: Thymeleaf
- **Styling**: CSS3
- **Scripting**: Vanilla JavaScript
### Additional Libraries
- **Lombok**: Reducing boilerplate code
- **Validation**: Spring Validation
- **Development Tools**: Spring DevTools
---
## 📦 Prerequisites
Before starting, ensure you have:
| Requirement | Version | Command |
|-------------|---------|---------|
| Java | 17+ | `java -version` |
| Maven | 3.6+ | `mvn -version` |
| MySQL | 8.0+ | `mysql --version` |
| Git | Latest | `git --version` |
---
## 🚀 Installation
### 1. Clone the Repository
```bash
git clone https://github.com/lefter-lab/SmartWallet.git
cd SmartWallet
```
### 2. Create MySQL Database
```sql
CREATE DATABASE SmartWalletApp_2026;
```
### 3. Configure Application Properties
Edit `src/main/resources/application-dev.properties`:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/SmartWalletApp_2026?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=false
# Application Configuration
spring.application.name=Smart Wallet Application
spring.profiles.active=dev
```
### 4. Build the Project
```bash
mvn clean install
```
### 5. Run the Application
```bash
mvn spring-boot:run
```
The application will be available at: **http://localhost:8080**
---
## ⚙️ Configuration
### Development Profile
```bash
# Option 1: IDE Run Configuration
VM options: -Dspring.profiles.active=dev
# Option 2: Environment Variable
export SPRING_PROFILES_ACTIVE=dev
# Option 3: application.properties
spring.profiles.active=dev
```
### Database Configuration
- **Host**: localhost
- **Port**: 3306
- **Database**: SmartWalletApp_2026
- **DDL auto**: update (automatic table creation)
### Wallet Default Settings
```properties
wallet.default.balance=20.00
wallet.default.currency=EUR
wallet.default.status=ACTIVE
```
### Subscription Default Settings
```properties
subscription.default.type=DEFAULT
subscription.default.price=0.00
subscription.default.period=MONTHLY
subscription.default.renewal=true
```
---
## 🏗️ Architecture
### Layered Architecture Pattern
```
┌─────────────────────────────────────┐
│   Presentation Layer                │
│   (Controllers + Thymeleaf Views)   │
└──────────────────┬──────────────────┘
                   ↓
┌─────────────────────────────────────┐
│   Business Logic Layer              │
│   (Services + DTOs + Mappers)       │
└──────────────────┬──────────────────┘
                   ↓
┌─────────────────────────────────────┐
│   Data Access Layer                 │
│   (Repositories + Entities)         │
└──────────────────┬──────────────────┘
                   ↓
┌─────────────────────────────────────┐
│   Database Layer (MySQL)            │
│   (Persistent Data Storage)         │
└─────────────────────────────────────┘
```
### Entity Relationships
```
User (1) ──── (N) Wallet
 │
 ├── (N) Subscription
 └── (N) Transaction
```
---
## 📊 Database Models
### User Entity
- **id** (UUID) - Primary Key
- **username** (String) - Unique identifier
- **password** (String) - BCrypt encoded
- **firstName, lastName** (String)
- **email** (String)
- **role** (Enum: ADMIN, USER)
- **country** (Enum: BULGARIA, GERMANY, FRANCE)
- **isActive** (Boolean)
- **createdOn, updatedOn** (LocalDateTime)
- **wallets** (One-to-Many relationship)
- **subscriptions** (One-to-Many relationship)
### Wallet Entity
- **id** (UUID) - Primary Key
- **owner** (Foreign Key to User)
- **status** (Enum: ACTIVE, INACTIVE)
- **balance** (BigDecimal)
- **currency** (Enum: EUR)
- **createdOn, updatedOn** (LocalDateTime)
### Subscription Entity
- **id** (UUID) - Primary Key
- **owner** (Foreign Key to User)
- **type** (Enum: DEFAULT, STANDARD, PREMIUM, ULTIMATE)
- **period** (Enum: MONTHLY, YEARLY)
- **price** (BigDecimal)
- **status** (Enum: ACTIVE, COMPLETED, TERMINATED)
- **renewalAllowed** (Boolean)
- **createdOn, completedOn** (LocalDateTime)
### Transaction Entity
- **id** (UUID) - Primary Key
- **owner** (Foreign Key to User)
- **type** (Enum: DEPOSIT, WITHDRAWAL, TRANSFER)
- **status** (Enum: SUCCEEDED, FAILED)
- **amount** (BigDecimal)
- **currency** (Enum: EUR)
- **description** (String)
- **failureReason** (String) - Optional
- **createdOn** (LocalDateTime)
---
## 🎯 Running the Application
### Development Mode
```bash
# With auto-reload (Spring DevTools enabled)
mvn spring-boot:run
# Access: http://localhost:8080
```
### Production Build
```bash
# Build JAR package
mvn clean package
# Run JAR file
java -jar target/smart-wallet-application-0.0.1-SNAPSHOT.jar
# Run with specific profile
java -Dspring.profiles.active=prod -jar target/smart-wallet-application-0.0.1-SNAPSHOT.jar
```
---
## 📡 Git Commands
### First Time Setup
```bash
git init
git add .
git commit -m "Initial commit: Smart Wallet Application"
git branch -M main
git remote add origin https://github.com/lefter-lab/SmartWallet.git
git push -u origin main
```
### Regular Updates
```bash
# Check status
git status
# Add changes
git add .
# Commit with message
git commit -m "Your descriptive message"
# Push to GitHub
git push
```
### Commit Message Examples
```bash
# Feature
git commit -m "feat: Add user registration with BCrypt encoding"
# Bug fix
git commit -m "fix: Resolve wallet balance calculation"
# Documentation
git commit -m "docs: Update README and specifications"
# Configuration
git commit -m "chore: Update MySQL settings"
```
---
## 🔐 Security Features
✅ **Password Security**: BCrypt hashing algorithm
✅ **Unique Constraints**: Username uniqueness enforcement
✅ **Role-Based Access**: ADMIN and USER roles
✅ **Transaction Auditing**: All operations logged with timestamps
✅ **Balance Validation**: Prevent negative balances
✅ **Status Verification**: Wallet and subscription status checks
---
## 📚 Documentation
- **WORKFLOW_LECTURE_1.md** - Complete step-by-step implementation guide
- **INSTRUCTION_LAB.md** - Technical specifications and requirements
- **GIT_COMMANDS.md** - Git command reference
- **README.md** - Project overview (this file)
---
## 🧪 Testing
### Run All Tests
```bash
mvn test
```
### Run Specific Test Class
```bash
mvn test -Dtest=UserServiceTest
```
### View Test Coverage
```bash
mvn test jacoco:report
```
---
## 🛣️ Development Roadmap
- [ ] Complete user registration and login
- [ ] Implement wallet operations (top-up, charge)
- [ ] Add subscription management
- [ ] Create transaction logging
- [ ] Build user dashboard
- [ ] Add admin panel
- [ ] Implement payment gateway
- [ ] Add API documentation (Swagger)
- [ ] Write comprehensive tests
- [ ] Deploy to cloud
---
## 🤝 Contributing
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Make your changes and commit: `git commit -m 'Add amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request
### Code Style Guide
- Follow existing code conventions
- Write meaningful commit messages
- Add tests for new features
- Update documentation
- Use descriptive variable names
---
## 🐛 Troubleshooting
| Problem | Solution |
|---------|----------|
| MySQL connection refused | Verify MySQL is running and credentials are correct |
| Cannot create tables | Check Hibernate DDL is set to 'update' |
| Port 8080 already in use | Change `server.port=8081` in properties |
| Lombok annotations not working | Enable Annotation Processing in IDE |
| SSH connection denied | Generate SSH key with `ssh-keygen -t rsa -b 4096` |
---
## 📄 License
This project is licensed under the MIT License - see the LICENSE file for details.
---
## 👨‍💼 Author
**Todor Lefterov**
- GitHub: [@lefter-lab](https://github.com/lefter-lab)
- Repository: [SmartWallet](https://github.com/lefter-lab/SmartWallet)
---
## 📚 Course Information
- **Course**: Spring Fundamentals (May 2026)
- **Instructor**: Кавян Костадинов
- **University Assignment**: Smart Wallet Application Exercise
- **Date**: May 21, 2026
---
## 🙏 Acknowledgments
- Spring Boot Documentation
- MySQL Community
- University Course Materials
- Contributors and Code Reviewers
---
<div align="center">
**[⬆ Back to Top](#-smart-wallet-application)**
Made with ❤️ for Learning Spring Boot
![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue)
![Last Updated](https://img.shields.io/badge/last%20updated-2026--05--21-green)
</div>
