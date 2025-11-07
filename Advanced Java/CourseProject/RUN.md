# Running the Library Management System

This guide provides instructions for running the Library Management System using Docker only, connecting to your existing PostgreSQL database and pgAdmin.

## Prerequisites

Before running the application, ensure you have:

1. **Docker installed** on your system
2. **PostgreSQL running** (your existing instance)
3. **Database created**: A database named `java_project` 
4. **pgAdmin running** (your existing instance)

## Quick Start

### Development Mode
```bash
# Build and start the development application
docker-compose -f docker-compose.dev.yml up --build

# Or run in background
docker-compose -f docker-compose.dev.yml up -d --build
```

### Production Mode  
```bash
# Build and start the production application
docker-compose -f docker-compose.prod.yml up --build

# Or run in background
docker-compose -f docker-compose.prod.yml up -d --build
```

## Configuration

### Database Connection

Both configurations connect to your existing PostgreSQL using `host.docker.internal:5432`. If your PostgreSQL is running on a different port or host, update the environment variables in the respective `docker-compose.yml` files:

```yaml
environment:
  SPRING_DATASOURCE_URL: jdbc:postgresql://your-host:your-port/java_project
  SPRING_DATASOURCE_USERNAME: your-username
  SPRING_DATASOURCE_PASSWORD: your-password
```

### Common Database Configurations

**Default (localhost:5432):**
```yaml
SPRING_DATASOURCE_URL: jdbc:postgresql://host.docker.internal:5432/java_project
```

**Custom host:**
```yaml
SPRING_DATASOURCE_URL: jdbc:postgresql://192.168.1.100:5432/java_project
```

**Different database name:**
```yaml
SPRING_DATASOURCE_URL: jdbc:postgresql://host.docker.internal:5432/your_db_name
```

## Development vs Production

### Development Mode Features
- **Hot Reload**: Code changes automatically restart the application
- **Debug Port**: Available on port 5005 for remote debugging
- **LiveReload**: Frontend changes reload automatically on port 35729
- **Verbose Logging**: Full SQL logging and debug information
- **Volume Mounts**: Source code is mounted for real-time development

### Production Mode Features  
- **Optimized Performance**: Reduced memory usage and better JVM settings
- **Limited Logging**: Only essential logs for performance
- **Security**: Minimal actuator endpoints exposed
- **Caching**: Template and resource caching enabled
- **Validation Mode**: Database schema validation only (no auto-updates)

## Available Endpoints

Once running, the application will be available at:

- **Application**: http://localhost:8080
- **Health Check**: http://localhost:8080/actuator/health
- **Development Info**: http://localhost:8080/actuator/info (dev mode only)

## Managing the Application

### Starting Services
```bash
# Development
docker-compose -f docker-compose.dev.yml up -d

# Production  
docker-compose -f docker-compose.prod.yml up -d
```

### Stopping Services
```bash
# Development
docker-compose -f docker-compose.dev.yml down

# Production
docker-compose -f docker-compose.prod.yml down
```

### Viewing Logs
```bash
# Development
docker-compose -f docker-compose.dev.yml logs -f library-app-dev

# Production
docker-compose -f docker-compose.prod.yml logs -f library-app
```

### Rebuilding the Application
```bash
# Development
docker-compose -f docker-compose.dev.yml up --build

# Production  
docker-compose -f docker-compose.prod.yml up --build
```

## Development Workflow

### 1. Start Development Environment
```bash
docker-compose -f docker-compose.dev.yml up --build
```

### 2. Make Code Changes
- Edit files in `src/` directory
- Application will automatically reload
- Check console logs for any errors

### 3. Debug (if needed)
- Connect your IDE to `localhost:5005` for remote debugging
- Use your existing pgAdmin to inspect database changes

### 4. Test Changes
- Access application at http://localhost:8080
- Verify functionality works as expected

## Troubleshooting

### Connection Issues

**Application can't connect to database:**
```bash
# Check if PostgreSQL is running
docker ps | grep postgres

# Or check system processes
ps aux | grep postgres

# Test connection from host
psql -h localhost -p 5432 -U postgres -d java_project
```

**Docker can't reach host database:**
- On Linux: Use `host.docker.internal:5432` 
- On older Docker versions: Use `172.17.0.1:5432`
- For custom networks: Use your host IP address

### Application Issues

**Application fails to start:**
```bash
# Check logs
docker-compose -f docker-compose.dev.yml logs library-app-dev

# Common issues:
# 1. Database not accessible
# 2. Port 8080 already in use
# 3. Invalid database credentials
```

**Database schema issues:**
```bash
# For development, reset the database if needed
# Connect to your PostgreSQL and run:
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
```

### Port Conflicts

If ports are already in use, modify the docker-compose files:

```yaml
ports:
  - "8081:8080"    # Use 8081 instead of 8080
  - "5006:5005"    # Use 5006 for debugging
```

## Docker Commands Reference

### Basic Commands
```bash
# Build image
docker-compose -f docker-compose.dev.yml build

# Start services
docker-compose -f docker-compose.dev.yml up

# Start in background
docker-compose -f docker-compose.dev.yml up -d

# Stop services
docker-compose -f docker-compose.dev.yml down

# View logs
docker-compose -f docker-compose.dev.yml logs -f

# Restart a service
docker-compose -f docker-compose.dev.yml restart library-app-dev
```

### Cleanup Commands
```bash
# Remove containers and networks
docker-compose -f docker-compose.dev.yml down

# Remove containers, networks, and volumes
docker-compose -f docker-compose.dev.yml down -v

# Remove images as well
docker-compose -f docker-compose.dev.yml down --rmi all

# Clean up unused Docker resources
docker system prune -f
```

## Environment Variables

You can also run with custom environment variables:

```bash
# Set custom database URL
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/my_db \
docker-compose -f docker-compose.dev.yml up
```

Or create a `.env` file:
```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/my_db
SPRING_DATASOURCE_USERNAME=myuser
SPRING_DATASOURCE_PASSWORD=mypass
```

## Performance Tips

### Development
- Use SSD storage for better hot reload performance
- Allocate sufficient memory to Docker (4GB+ recommended)
- Close unnecessary applications to free up system resources

### Production
- Monitor memory usage with `docker stats`
- Use external database connection pooling if needed
- Consider using Docker health checks for automatic restarts

## Next Steps

After successfully running the application:

1. **Test Core Features**: Create, read, update, and delete books
2. **Database Management**: Use your pgAdmin to inspect data
3. **API Testing**: Test REST endpoints with tools like Postman
4. **Customization**: Modify the application for your specific needs

For additional features or issues, refer to the main project documentation or modify the source code as needed.