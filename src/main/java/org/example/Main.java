package org.example;

import org.example.Model.Admin;
import org.example.Model.Book;
import org.example.Model.Student;
import org.example.Service.LibraryManagementSystem;
import org.example.Service.PDFReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        PDFReader pdfReader = new PDFReader();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Add Book");
            System.out.println("5. List Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Read PDF");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Role (Admin/Student): ");
                    String role = scanner.nextLine();
                    if (role.equalsIgnoreCase("Admin")) {
                        System.out.println(library.addUser(userId, new Admin(userId, name, email)));
                    } else if (role.equalsIgnoreCase("Student")) {
                        System.out.println(library.addUser(userId, new Student(userId, name, email)));
                    } else {
                        System.out.println("Invalid role. Please enter Admin or Student.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.println(library.loginUser(userId, email));
                }
                case 3 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.println(library.logoutUser(userId));
                }
                case 4 -> {
                    System.out.print("Enter User ID (Admin): ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.nextLine();
                    System.out.println(library.addBook(userId, new Book(bookId, bookName, authorName, null)));
                }
                case 5 -> library.listBooks();
                case 6 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.println(library.borrowBook(userId, bookId));
                }
                case 7 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.println(library.returnBook(userId, bookId));
                }
                case 8 -> {
                    System.out.print("Enter the file path of the PDF: ");
                    String filePath = scanner.nextLine();
                    System.out.println("\nReading PDF content from: " + filePath);
                    String pdfContent = pdfReader.readPDF(filePath);
                    System.out.println("PDF Content:\n" + pdfContent);
                }
                case 9 -> {
                    exit = true;
                    System.out.println("Exiting Library Management System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
