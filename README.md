```markdown
# Student Management System

## Project Overview

The **Student Management System** is a console-based Java application designed to manage student records using a MySQL database. The system provides functionalities such as adding, viewing, updating, and deleting student details, offering a simple way for administrators to manage student data.

## Features

- **Add Student**: Allows adding a new student record to the system.
- **View Students**: Displays a list of all students in the system.
- **Update Student**: Allows updating the details of an existing student.
- **Delete Student**: Enables deletion of a student record from the system.

## Technologies

- **Java**: Main programming language used for backend logic.
- **MySQL**: Relational database used for storing student records.
- **Eclipse IDE**: Used to write and run the Java application.

## Database Schema

The following SQL script will set up the required database and table for the Student Management System.

### SQL Script

```sql
-- Create Database
CREATE DATABASE student_management;

-- Use the Database
USE student_management;

-- Create Table for Students
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique ID for each student
    name VARCHAR(50) NOT NULL,          -- Name of the student
    age INT NOT NULL,                   -- Age of the student
    email VARCHAR(100) NOT NULL UNIQUE  -- Email (unique) of the student
);
```

### Explanation:

- **students** table contains the following columns:
  - `id`: Auto-incremented integer, acts as a unique identifier for each student.
  - `name`: A string representing the student's name (required field).
  - `age`: An integer representing the student's age (required field).
  - `email`: A unique email address associated with the student.

## Setup Instructions

### 1. Clone the Repository

Clone the repository to your local machine using Git:

```bash
git clone https://github.com/SanthoshD123/StudentManagementSystem.git
```

### 2. Database Setup

- Install MySQL on your local machine.
- Log into MySQL and run the following SQL commands to create the database and the `students` table:

```sql
CREATE DATABASE student_management;
USE student_management;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);
```

### 3. Update Database Connection

In the `DatabaseConnection.java` file, make sure to update the following variables with your MySQL credentials:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/student_management?useSSL=false";
private static final String USER = "root";        // Your MySQL username
private static final String PASSWORD = "yourpassword";  // Your MySQL password
```

### 4. Running the Application

- Open the project in Eclipse.
- Make sure you have added the MySQL JDBC driver to your project.
- Run the `StudentManagementSystem.java` class.

The system will present a simple text-based menu to perform the following actions:
- **1**: Add Student
- **2**: View Students
- **3**: Update Student
- **4**: Delete Student
- **5**: Exit

## Usage

### Menu Options:

1. **Add Student**: Allows the administrator to input a student's details and add them to the database.
2. **View Students**: Displays a list of all students currently stored in the database.
3. **Update Student**: Allows the administrator to update any student's information such as name, age, or email.
4. **Delete Student**: Deletes a student's record based on their unique ID.

### Example:

```bash
=== Student Management System ===
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice: 1

Enter student name: John Doe
Enter student age: 20
Enter student email: john.doe@example.com

Student added successfully!
```

## Future Improvements

- Add **search functionality** to view a specific student's details.
- Implement **user authentication** for access control.
- Build a **GUI** (Graphical User Interface) using JavaFX for a better user experience.

## License

This project is licensed under the MIT License.

## Acknowledgements

- Thanks to the open-source community for providing resources that made this project possible.
- Inspiration drawn from various online tutorials for learning Java and MySQL integration.
```
