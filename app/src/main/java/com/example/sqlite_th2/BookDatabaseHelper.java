package com.example.sqlite_th2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "book_db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_RELEASE_DATE = "release_date";
    public static final String COLUMN_PUBLISHER = "publisher";
    public static final String COLUMN_PRICE = "price";

    public BookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_AUTHOR + " TEXT," +
                COLUMN_RELEASE_DATE + " TEXT," +
                COLUMN_PUBLISHER + " TEXT," +
                COLUMN_PRICE + " REAL" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }
}
