# Library Management System

A comprehensive library management system built with Spring Boot, featuring a modern web interface and complete CRUD operations for managing books.

## Features

### Core Functionality
- **Complete CRUD Operations**: Create, Read, Update, Delete books
- **Search & Filter**: Search books by title, author, or ISBN
- **Book Management**: Track available and total copies
- **Borrow/Return System**: Simple book borrowing and returning functionality

### Technical Features
- **Spring Boot Framework**: Built with Spring Boot 3.2.0
- **Database Integration**: PostgreSQL with JPA/Hibernate
- **Modern UI**: Responsive design with Tailwind CSS
- **REST API**: Complete REST endpoints for all operations
- **Docker Support**: Containerized deployment with Docker
- **Bean Lifecycle**: Demonstrates Spring Bean management
- **Dependency Injection**: Proper Spring DI implementation

## Technology Stack

- **Backend**: Spring Boot 3.2.0, Spring MVC, Spring Data JPA
- **Database**: PostgreSQL
- **Frontend**: Thymeleaf, Tailwind CSS, HTML5
- **Build Tool**: Maven
- **Containerization**: Docker & Docker Compose
- **Java Version**: 17

## Prerequisites

- Java 17 or higher
- PostgreSQL database
- Docker (optional, for containerized deployment)
- Maven (or use included Maven wrapper)

## Database Setup

1. Ensure PostgreSQL is running on your system
2. Create a database named `java_project`:
   ```sql
   CREATE DATABASE java_project;
   ```
3. The application will automatically create the required tables on startup

## Installation & Setup

### Method 1: Running Locally

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd CourseProject
   ```

2. **Configure database connection** (if different from defaults):
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/java_project
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Build and run the application**:
   ```bash
   # Using Maven wrapper (recommended)
   ./mvnw spring-boot:run

   # Or using installed Maven
   mvn spring-boot:run
   ```

4. **Access the application**:
   - Web Interface: http://localhost:8080
   - Health Check: http://localhost:8080/actuator/health

### Method 2: Docker Development Environment (Recommended)

1. **Start the complete development environment** (includes database):
   ```bash
   # Quick start
   ./scripts/dev-start.sh
   
   # Or manually
   docker-compose -f docker-compose.dev.yml up --build
   ```

2. **Access the development environment**:
   - Web Interface: http://localhost:8080
   - Database: localhost:5432 (postgres/password)
   - Debug Port: 5005 (for IDE remote debugging)
   - pgAdmin (optional): http://localhost:5050 (admin@library.com/admin)

3. **Development features**:
   - ✨ **Hot Reload**: Changes to Java files are automatically detected
   - 🔧 **Remote Debugging**: Connect your IDE to port 5005
   - 📊 **Enhanced Logging**: Detailed SQL and application logs
   - 🗄️ **Persistent Database**: Data survives container restarts
   - 🔍 **Health Monitoring**: Built-in health checks

### Method 3: Simple Docker (Database External)

If you already have PostgreSQL running locally:
```bash
# For production-like setup
docker-compose -f docker-compose.prod.yml up --build

# Or simple setup with external database
docker-compose up --build
```

## Development Workflow with Docker

### Quick Commands
```bash
# Start development environment
./scripts/dev-start.sh

# View logs
./scripts/dev-logs.sh

# Stop environment
./scripts/dev-stop.sh

# Reset everything (clean slate)
./scripts/dev-reset.sh
```

### Code Changes and Hot Reload
1. Make changes to Java files in `src/main/java/`
2. Save the file
3. Spring DevTools automatically restarts the application
4. Refresh your browser to see changes

### Database Development
- **pgAdmin**: Start with `docker-compose -f docker-compose.dev.yml --profile pgadmin up -d`
- **Direct Connection**: localhost:5432, username: postgres, password: password
- **Sample Data**: Available in `docker/init-scripts/02-sample-data.sql`

### Remote Debugging
1. Start the development environment
2. In your IDE, create a remote debug configuration:
   - Host: localhost
   - Port: 5005
3. Set breakpoints and start debugging

## API Endpoints

### REST API

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Create new book |
| PUT | `/api/books/{id}` | Update book |
| DELETE | `/api/books/{id}` | Delete book |
| GET | `/api/books/search?q={term}` | Search books |
| POST | `/api/books/{id}/borrow` | Borrow book |
| POST | `/api/books/{id}/return` | Return book |

### Web Interface

| Route | Description |
|-------|-------------|
| `/` | Home page with book list |
| `/books/add` | Add new book form |
| `/books/edit/{id}` | Edit book form |
| `/books/view/{id}` | View book details |

## Usage Guide

### Adding a New Book
1. Click "Add Book" in the navigation
2. Fill in the required fields (Title, Author, ISBN, Total Copies)
3. Optionally add genre, publication date, and description
4. Click "Add Book" to save

### Searching Books
1. Use the search bar on the home page
2. Enter title, author, or ISBN
3. Results will filter automatically

### Managing Book Copies
1. View a book's details page
2. Use "Borrow Book" to decrease available copies
3. Use "Return Book" to increase available copies
4. Edit the book to change total copies

## Spring Framework Concepts Demonstrated

### 1. Bean Scope and Lifecycle
- **Singleton Beans**: Services and repositories are singleton by default
- **Prototype Scope**: Not used in this application but framework supports it
- **Bean Lifecycle**: Dependency injection occurs during application startup

### 2. Bean Definition and Inheritance
- **Component Scanning**: `@Service`, `@Repository`, `@Controller` annotations
- **Configuration**: Auto-configuration through Spring Boot
- **Bean Inheritance**: Service layer inherits from repository abstractions

### 3. Dependency Injection
- **Constructor Injection**: Used in all service and controller classes
- **Autowired Annotation**: Demonstrates different injection methods
- **Interface-based DI**: Repository interfaces injected into services

### 4. Spring MVC
- **Controller Layer**: Handles both web and REST requests
- **Model-View-Controller**: Clear separation of concerns
- **Request Mapping**: Various HTTP methods and URL patterns

### 5. Data Access
- **JPA Integration**: Spring Data JPA for database operations
- **Repository Pattern**: Clean data access layer
- **Transaction Management**: Automatic transaction handling

## Docker Configuration

### Development Docker Setup

The project includes a comprehensive Docker development environment:

#### File Structure
- `Dockerfile.dev` - Development container with hot reload
- `docker-compose.dev.yml` - Full development environment with database
- `docker-compose.yml` - Simple development setup
- `docker-compose.prod.yml` - Production deployment
- `scripts/` - Helper scripts for development

#### Development Dockerfile Features
- **Multi-stage build**: Optimized for production
- **Security**: Non-root user execution
- **Health checks**: Built-in application monitoring
- **Resource optimization**: JVM tuning for containers

### Docker Compose Features
- **Service definition**: Application container configuration
- **Environment variables**: Database connection configuration
- **Health monitoring**: Container health checks
- **Network isolation**: Custom network for services

## Development

### Project Structure
```
src/
├── main/
│   ├── java/com/university/library/
│   │   ├── entity/          # JPA entities
│   │   ├── repository/      # Data access layer
│   │   ├── service/         # Business logic layer
│   │   ├── controller/      # Web and REST controllers
│   │   └── LibraryManagementApplication.java
│   └── resources/
│       ├── templates/       # Thymeleaf templates
│       ├── static/          # Static resources
│       └── application.properties
└── test/                    # Test classes
```

### Key Classes

- **Book.java**: JPA entity with validation annotations
- **BookRepository.java**: Spring Data JPA repository interface
- **BookService.java**: Business logic with transaction management
- **BookController.java**: Combined web and REST controller

## Course Learning Objectives Covered

1. **Spring Framework Introduction**: Bean scope, lifecycle, and dependency injection
2. **Bean Definition and Inheritance**: Component scanning and auto-configuration
3. **Spring MVC**: Building web applications with controllers and views
4. **Creating Controls and Views**: Thymeleaf templates and form handling
5. **Docker Introduction**: Containerization concepts and implementation
6. **Spring Boot with Docker**: Deployment and container orchestration
7. **JDBC API**: Database operations through Spring Data JPA
8. **CRUD Operations**: Complete Create, Read, Update, Delete functionality

## License

This project is created for educational purposes as part of an Advanced Java course.