package com.example.sqlite_th2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private SQLiteDatabase db;
    private final BookDatabaseHelper dbHelper;

    public BookDAO(Context context) {
        dbHelper = new BookDatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public int getMaxId() {
        open();
        int maxId = 0;

        Cursor cursor = db.rawQuery("SELECT MAX(id) FROM " + BookDatabaseHelper.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            maxId = cursor.getInt(0);
        }
        cursor.close();
        close();

        return maxId;
    }


    public void addBook(Book book) {
        open();
        ContentValues values = new ContentValues();
        values.put(BookDatabaseHelper.COLUMN_ID, book.getId());
        values.put(BookDatabaseHelper.COLUMN_NAME, book.getName());
        values.put(BookDatabaseHelper.COLUMN_AUTHOR, book.getAuthor());
        values.put(BookDatabaseHelper.COLUMN_RELEASE_DATE, book.getReleaseDate());
        values.put(BookDatabaseHelper.COLUMN_PUBLISHER, book.getPublisher());
        values.put(BookDatabaseHelper.COLUMN_PRICE, book.getPrice());

        db.insert(BookDatabaseHelper.TABLE_NAME, null, values);
        close();
    }

    public void updateBook(Book book) {
        open();
        ContentValues values = new ContentValues();
        values.put(BookDatabaseHelper.COLUMN_NAME, book.getName());
        values.put(BookDatabaseHelper.COLUMN_AUTHOR, book.getAuthor());
        values.put(BookDatabaseHelper.COLUMN_RELEASE_DATE, book.getReleaseDate());
        values.put(BookDatabaseHelper.COLUMN_PUBLISHER, book.getPublisher());
        values.put(BookDatabaseHelper.COLUMN_PRICE, book.getPrice());

        db.update(BookDatabaseHelper.TABLE_NAME, values, BookDatabaseHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(book.getId())});
        close();
    }

    public void deleteBook(Book book) {
        open();
        db.delete(BookDatabaseHelper.TABLE_NAME, BookDatabaseHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(book.getId())});
        close();
    }

    public List<Book> getAllBooks() {
        open();
        List<Book> bookList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + BookDatabaseHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String releaseDate = cursor.getString(3);
                String publisher = cursor.getString(4);
                double price = cursor.getDouble(5);
                Book book = new Book(id, name, author, releaseDate, publisher, price);
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        close();
        return bookList;
    }

    public List<Book> searchByPrice(double minPrice, double maxPrice) {
        open();
        List<Book> books = new ArrayList<>();

        String[] columns = {BookDatabaseHelper.COLUMN_ID, BookDatabaseHelper.COLUMN_NAME, BookDatabaseHelper.COLUMN_AUTHOR, BookDatabaseHelper.COLUMN_RELEASE_DATE, BookDatabaseHelper.COLUMN_PUBLISHER, BookDatabaseHelper.COLUMN_PRICE};
        String selection = BookDatabaseHelper.COLUMN_PRICE + " >= ? AND " + BookDatabaseHelper.COLUMN_PRICE + " <= ?";
        String[] selectionArgs = {String.valueOf(minPrice), String.valueOf(maxPrice)};

        Cursor cursor = db.query(BookDatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String releaseDate = cursor.getString(3);
                String publisher = cursor.getString(4);
                double price = cursor.getDouble(5);

                Book book = new Book(id, name, author, releaseDate, publisher, price);
                books.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        close();
        return books;
    }

    public List<Book> searchByPublisher(String pub) {
        open();
        List<Book> books = new ArrayList<>();

        String[] columns = {BookDatabaseHelper.COLUMN_ID, BookDatabaseHelper.COLUMN_NAME, BookDatabaseHelper.COLUMN_AUTHOR, BookDatabaseHelper.COLUMN_RELEASE_DATE, BookDatabaseHelper.COLUMN_PUBLISHER, BookDatabaseHelper.COLUMN_PRICE};
        String selection = BookDatabaseHelper.COLUMN_PUBLISHER + "=?";
        String[] selectionArgs = {pub};

        Cursor cursor = db.query(BookDatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String releaseDate = cursor.getString(3);
                String publisher = cursor.getString(4);
                double price = cursor.getDouble(5);

                Book book = new Book(id, name, author, releaseDate, publisher, price);
                books.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        close();
        return books;
    }

    public List<Book> searchByPriceAndPublisher(double minPrice, double maxPrice, String publisher) {
        open();
        List<Book> books = new ArrayList<>();

        String[] columns = {BookDatabaseHelper.COLUMN_ID, BookDatabaseHelper.COLUMN_NAME, BookDatabaseHelper.COLUMN_AUTHOR, BookDatabaseHelper.COLUMN_RELEASE_DATE, BookDatabaseHelper.COLUMN_PUBLISHER, BookDatabaseHelper.COLUMN_PRICE};
        String selection = BookDatabaseHelper.COLUMN_PRICE + " >= ? AND " + BookDatabaseHelper.COLUMN_PRICE + " <= ? AND " +
                BookDatabaseHelper.COLUMN_PUBLISHER + "=?";
        String[] selectionArgs = {String.valueOf(minPrice), String.valueOf(maxPrice), publisher};

        Cursor cursor = db.query(BookDatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String releaseDate = cursor.getString(3);
                String publisherr = cursor.getString(4);
                double price = cursor.getDouble(5);

                Book book = new Book(id, name, author, releaseDate, publisherr, price);
                books.add(book);
            } while (cursor.moveToNext());
        }

        cursor.close();
        close();
        return books;
    }


}
