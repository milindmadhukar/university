-- Database initialization script for development
-- This script runs when the PostgreSQL container is first created

-- Create the java_project database if it doesn't exist
-- (This is already handled by POSTGRES_DB environment variable)

-- Enable UUID extension for future use
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create any additional database configurations for development
-- Set timezone
SET timezone = 'UTC';

-- Log the initialization
\echo 'Database initialization completed for development environment'