#!/bin/bash

# Development environment startup script

echo "🚀 Starting Library Management System - Development Environment"
echo "=================================================="

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker is not running. Please start Docker and try again."
    exit 1
fi

# Check if docker-compose is available
if ! command -v docker-compose &> /dev/null; then
    echo "❌ docker-compose is not installed. Please install docker-compose and try again."
    exit 1
fi

echo "✅ Docker is running"
echo "📦 Building and starting development environment..."

# Stop any existing containers
docker-compose -f docker-compose.dev.yml down

# Build and start the development environment
docker-compose -f docker-compose.dev.yml up --build -d

echo ""
echo "🎉 Development environment started successfully!"
echo ""
echo "📋 Services available:"
echo "   🌐 Application: http://localhost:8080"
echo "   🐘 PostgreSQL: localhost:5432"
echo "   🔍 Health Check: http://localhost:8080/actuator/health"
echo "   🐛 Debug Port: 5005 (for IDE remote debugging)"
echo ""
echo "📖 Additional services (optional):"
echo "   To start pgAdmin: docker-compose -f docker-compose.dev.yml --profile pgadmin up -d"
echo "   pgAdmin URL: http://localhost:5050 (admin@library.com / admin)"
echo ""
echo "📝 Useful commands:"
echo "   View logs: docker-compose -f docker-compose.dev.yml logs -f"
echo "   Stop services: docker-compose -f docker-compose.dev.yml down"
echo "   Restart app: docker-compose -f docker-compose.dev.yml restart library-app-dev"
echo ""
echo "💡 Development features enabled:"
echo "   ✨ Hot reload (save files to see changes)"
echo "   🔧 Debug port exposed on 5005"
echo "   📊 Enhanced logging and monitoring"
echo "   🗄️  Database with persistent volumes"
echo ""

# Wait a moment for services to start
echo "⏳ Waiting for services to be ready..."
sleep 10

# Check if application is healthy
if curl -f http://localhost:8080/actuator/health > /dev/null 2>&1; then
    echo "✅ Application is healthy and ready!"
else
    echo "⚠️  Application is starting up... Check logs if it takes too long:"
    echo "   docker-compose -f docker-compose.dev.yml logs library-app-dev"
fi

echo ""
echo "🎯 Happy coding! Your development environment is ready."