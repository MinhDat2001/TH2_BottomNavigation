package com.example.sqlite_th2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookList extends Fragment {

    RecyclerView bookListRecycleView;
    BookListAdapter bookListAdapter;
    List<Book> mBookList;


    private BookDAO mBookDAO;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_list, container, false);



        mBookDAO = new BookDAO(getContext());
        mBookList = mBookDAO.getAllBooks();


        bookListRecycleView = view.findViewById(R.id.book_list);
        bookListRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        bookListAdapter = new BookListAdapter(getContext(), mBookList);
        bookListRecycleView.setAdapter(bookListAdapter);

        bookListAdapter.setOnItemClickListener(new BookListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                Log.d("Tuan", "onItemClick: " + book.toString());
                intent.putExtra("book", book);
                startActivity(intent);
            }
        });



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mBookDAO.open();
        mBookList = mBookDAO.getAllBooks();
        mBookDAO.close();
        bookListAdapter.setBookList(mBookList);
    }
}
