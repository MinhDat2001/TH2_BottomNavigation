package com.example.sqlite_th2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BookAddActivity extends AppCompatActivity {

    private Spinner mPublisherSpinner;
    private EditText mNameEditText;
    private EditText mAuthorEditText;
    private EditText mReleaseDateEditText;
    private EditText mPriceEditText;
    private Button buttonDate;
    private Button buttonSave;
    private Button buttonBack;
    private BookDAO mBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);

        mPublisherSpinner = findViewById(R.id.spn_publisher);
        mNameEditText = findViewById(R.id.editTextName);
        mAuthorEditText = findViewById(R.id.editTextAuthor);
        mReleaseDateEditText = findViewById(R.id.editTextReleaseDate);
        mPriceEditText = findViewById(R.id.editTextPrice);
        buttonDate = findViewById(R.id.buttonDate);
        buttonSave = findViewById(R.id.buttonSave);
        buttonBack = findViewById(R.id.buttonBack);
        mBookDAO = new BookDAO(this);

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                final DatePickerDialog datePickerDialog = new DatePickerDialog(BookAddActivity.this, (view, year1, monthOfYear, dayOfMonth) -> {
                    // Đặt ngày được chọn vào EditText
                    String selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
                    mReleaseDateEditText.setText(selectedDate);
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString().trim();
                String author = mAuthorEditText.getText().toString().trim();
                String releaseDate = mReleaseDateEditText.getText().toString().trim();
                String publisher = (String) mPublisherSpinner.getSelectedItem();
                String price = mPriceEditText.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(author) || TextUtils.isEmpty(releaseDate) || TextUtils.isEmpty(publisher) || TextUtils.isEmpty(price))
                    Toast.makeText(BookAddActivity.this, "Hãy điền đầy đủ các mục", Toast.LENGTH_SHORT).show();
                else {
                    Book book = new Book(name, author, releaseDate, publisher, Double.parseDouble(price));
                    Log.d("Tuan", "onClick: " + name + "\n" + author + "\n" + publisher + "\n" + price);
                    mBookDAO.addBook(book);
                    Toast.makeText(BookAddActivity.this, "Thêm thành công sách " + name, Toast.LENGTH_SHORT).show();
                    mNameEditText.setText(null);
                    mAuthorEditText.setText(null);
                    mReleaseDateEditText.setText(null);
                    mPriceEditText.setText(null);
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        List<String> publishers = Arrays.asList(getResources().getStringArray(R.array.publishers_array));
        PublisherAdapter adapter = new PublisherAdapter(this, android.R.layout.simple_spinner_item, publishers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPublisherSpinner.setAdapter(adapter);
    }



}
