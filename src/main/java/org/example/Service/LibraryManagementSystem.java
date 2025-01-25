package org.example.Service;

import org.example.Database.LibraryDatabase;
import org.example.Configuration.Session;
import java.util.ArrayList;
import java.util.List;

import org.example.Model.Admin;
import org.example.Model.Book;
import org.example.Model.Student;
import org.example.Model.User;

public class LibraryManagementSystem {
    private LibraryDatabase libraryDatabase;
    private SessionManager sessionManager;

    public LibraryManagementSystem(){
        this.libraryDatabase = new LibraryDatabase();
        this.sessionManager = new SessionManager();
    }

    public String loginUser(String userId, String email){
        return sessionManager.login(userId, email);
    }

    public String logoutUser(String userId){
        return sessionManager.logout(userId);
    }

    public String addUser(String userId, User user){
        libraryDatabase.addUser(user);
        return "User added";
    }

    public String addBook(String userId, Book book){
        if(!sessionManager.isActive(userId)){
            return "User is not logged in.";
        }

        Session session = sessionManager.getSession(userId);
        if(!session.getEmail().endsWith("@admin.com")){
            return "Only admins can add book";
        }

        libraryDatabase.addBook(book);
        return "Book added successfully: " + book.getName();
    }

    public String borrowBook(String userId, String bookId){
        if(!sessionManager.isActive(userId)){
            return "User is not logged in.";
        }

        User user = libraryDatabase.findUserById(userId);
        Book book = libraryDatabase.findBookById(bookId);

        if(user == null){
            return "User not found";
        }

        if(book == null){
            return "Book not found";
        }
        if (book.getBorrowId() != null && !book.getBorrowId().isEmpty()) {
            return "Book is already borrowed.";
        }

        book.setBorrowId(userId);
        return "Book borrowed successfully by " + user.getName() + ".";
    }

    public String returnBook(String userId, String bookId){
        if(!sessionManager.isActive(userId)){
            return "User is not logged in.";
        }

        User user = libraryDatabase.findUserById(userId);
        Book book = libraryDatabase.findBookById(bookId);

        if(user == null){
            return "User not found";
        }

        if(book == null){
            return "Book not found";
        }

        if(!userId.equals(book.getBorrowId())){
            return "This book was not borrowed by the given user";
        }

        book.setBorrowId(null);
        return "Book returned successfully by " + user.getName() + ".";
    }

    public void listBooks() {
        libraryDatabase.listBooks();
    }
}
