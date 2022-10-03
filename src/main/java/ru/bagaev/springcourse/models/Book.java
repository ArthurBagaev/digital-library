package ru.bagaev.springcourse.models;

public class Book {

    private int bookId;

    private String title;

    private String author;

    private String year_release;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear_release() {
        return year_release;
    }

    public void setYear_release(String year_release) {
        this.year_release = year_release;
    }

    public Book(int bookId, String title, String author, String year_release) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year_release = year_release;
    }
}
