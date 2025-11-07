#!/bin/bash

# Development environment stop script

echo "🛑 Stopping Library Management System - Development Environment"
echo "=================================================="

# Stop all services
docker-compose -f docker-compose.dev.yml down

echo "✅ Development environment stopped."
echo ""
echo "📋 Note: Database data is preserved in Docker volumes."
echo "   To remove all data: docker-compose -f docker-compose.dev.yml down -v"
echo ""
echo "🔄 To start again: ./scripts/dev-start.sh"