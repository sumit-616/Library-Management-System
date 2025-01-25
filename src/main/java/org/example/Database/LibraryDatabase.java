package org.example.Database;
import org.example.Model.Admin;
import org.example.Model.Book;
import org.example.Model.Student;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private List<Book> books;
    private List<User> users;

    public LibraryDatabase(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getName());
    }

    public void removeBook(String bookId){
        books.removeIf(book -> book.getBookId().equals(bookId));
        System.out.println("Book removed: " + bookId);
    }

    public Book findBookById(String bookId){
        for(Book book : books){
            if(book.getBookId().equals(bookId)){
                return book;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

    public User findUserById(String userId){
        for(User user : users){
            if(user instanceof Admin && ((Admin) user).returnRole().equals("Admin") && user.getUserid().equals(userId)){
                return user;
            }else if(user instanceof Student && ((Student) user).returnRole().equals("Student") && userId.equals(userId)){
                return  user;
            }
        }
        return null;
    }

    public void listBooks(){
        for(Book book : books){
            System.out.println("ID: " + book.getBookId() + ", Name: " + book.getName() + ", Author: " + book.getAuthor());
        }
    }

    public void listUsers(){
        for(User user : users){
            System.out.println("ID: " + user.returnRole() + ", Name: " + user.getName());
        }
    }
}