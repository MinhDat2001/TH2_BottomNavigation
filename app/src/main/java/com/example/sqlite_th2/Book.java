package com.example.sqlite_th2;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class Book implements Serializable {
    private static int lastId = 0;
    private int id;
    private String name;
    private String author;
    private String releaseDate;
    private String publisher;
    private double price;

    public Book(String name, String author, String releaseDate, String publisher, double price) {
        lastId++;
        this.id = lastId;
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.price = price;
    }

    public Book(int id, String name, String author, String releaseDate, String publisher, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.price = price;
    }

    public Book() {
        lastId++;
        this.id = lastId;
    }

    public static void setLastId(int lastId) {
        Book.lastId = lastId;
    }

    public static void sortBooksByPriceDescending(List<Book> bookList) {
        Comparator<Book> priceComparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                if (book1.getPrice() < book2.getPrice()) {
                    return 1;
                } else if (book1.getPrice() > book2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        bookList.sort(priceComparator);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", author='" + author + '\'' + ", releaseDate='" + releaseDate + '\'' + ", publisher='" + publisher + '\'' + ", price=" + price + '}';
    }
}
