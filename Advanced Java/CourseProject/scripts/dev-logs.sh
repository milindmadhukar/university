#!/bin/bash

# View development environment logs

echo "📋 Library Management System - Development Logs"
echo "=================================================="
echo ""
echo "🔍 Showing logs for all services. Press Ctrl+C to exit."
echo ""

# Follow logs for all services
docker-compose -f docker-compose.dev.yml logs -f