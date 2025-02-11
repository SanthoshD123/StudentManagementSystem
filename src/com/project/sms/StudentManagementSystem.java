package com.project.sms;

import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        String query = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            if (conn == null) {
                System.out.println("Unable to connect to the database.");
                return;
            }

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Student added successfully!" : "Failed to add student.");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void viewStudents() {
        String query = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Unable to connect to the database.");
                return;
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                System.out.println("\n=== Student List ===");
                while (rs.next()) {
                    System.out.printf("ID: %d, Name: %s, Age: %d, Email: %s\n",
                            rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"));
                }

            } catch (SQLException e) {
                System.out.println("Error retrieving students: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        String query = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Unable to connect to the database.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, email);
                stmt.setInt(4, id);

                int rows = stmt.executeUpdate();
                System.out.println(rows > 0 ? "Student updated successfully!" : "Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Unable to connect to the database.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);

                int rows = stmt.executeUpdate();
                System.out.println(rows > 0 ? "Student deleted successfully!" : "Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
