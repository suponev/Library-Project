package ru.library.models;

public class Book {
    String isbn ;
    String title;
    String author;
    String username;
    public Book(){}
    public Book(String isbn, String title, String author, String username) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.username = username;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
