#!/bin/bash

# Reset development environment (clean slate)

echo "🔄 Resetting Library Management System - Development Environment"
echo "=================================================="
echo ""
echo "⚠️  This will:"
echo "   - Stop all containers"
echo "   - Remove all containers and networks"
echo "   - Remove all volumes (database data will be lost)"
echo "   - Remove Docker images"
echo ""

read -p "Are you sure you want to reset everything? (y/N): " -n 1 -r
echo
if [[ $REPLY =~ ^[Yy]$ ]]; then
    echo "🗑️  Removing everything..."
    
    # Stop and remove everything
    docker-compose -f docker-compose.dev.yml down -v --rmi all --remove-orphans
    
    # Remove any dangling volumes
    docker volume prune -f
    
    echo "✅ Development environment reset complete."
    echo ""
    echo "🚀 To start fresh: ./scripts/dev-start.sh"
else
    echo "❌ Reset cancelled."
fi