# Student Management System

Welcome to our Student Management System! This README will guide you through our console-based Java application that helps administrators manage student records efficiently.

## What is it?
A straightforward Java application that connects with MySQL to handle all your student data management needs. Whether you need to add new students, check existing records, make updates, or remove entries, we've got you covered.

## Core Features
Our system lets you:
- Add new students to the database with their details
- View a comprehensive list of all enrolled students
- Update student information when needed
- Remove student records when necessary

## Technology Stack
We've built this using:
- Java for all our core functionality
- MySQL to store and manage the data
- Eclipse IDE as our development environment

## Setting Up the Database
To get started, you'll need to set up your database. Here's the SQL code you'll need:

```sql
-- First, let's create our database
CREATE DATABASE student_management;

-- Switch to using our new database
USE student_management;

-- Now, let's create our students table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- This gives each student a unique ID
    name VARCHAR(50) NOT NULL,            -- Student's name
    age INT NOT NULL,                     -- Student's age
    email VARCHAR(100) NOT NULL UNIQUE    -- Student's email (must be unique)
);
```
