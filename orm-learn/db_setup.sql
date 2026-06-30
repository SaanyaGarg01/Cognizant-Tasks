-- MySQL database initialization script for orm-learn project

-- Create Database Schema
CREATE DATABASE IF NOT EXISTS ormlearn;
USE ormlearn;

-- Create Country Table
CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50) NOT NULL
);

-- Insert Sample Seeds
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India') ON DUPLICATE KEY UPDATE co_name='India';
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States of America') ON DUPLICATE KEY UPDATE co_name='United States of America';

-- Verify entries
SELECT * FROM country;
