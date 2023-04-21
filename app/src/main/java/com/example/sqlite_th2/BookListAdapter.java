package com.example.sqlite_th2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    private List<Book> mBookList;

    private Context context;

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView idTextView;
        public TextView nameTextView;
        public TextView authorTextView;
        public TextView releaseDateTextView;
        public TextView publisherTextView;
        public TextView priceTextView;

        public ViewHolder(View v) {
            super(v);
            idTextView = v.findViewById(R.id.idTextView);
            nameTextView = v.findViewById(R.id.nameTextView);
            authorTextView = v.findViewById(R.id.authorTextView);
            releaseDateTextView = v.findViewById(R.id.releaseDateTextView);
            publisherTextView = v.findViewById(R.id.publisherTextView);
            priceTextView = v.findViewById(R.id.priceTextView);
        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public BookListAdapter(Context context, List<Book> bookList) {
        this.context = context;
        mBookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBookList.get(position);
        holder.idTextView.setText(Integer.toString(book.getId()));
        holder.nameTextView.setText(book.getName());
        holder.authorTextView.setText("Tác giả: " + book.getAuthor());
        holder.releaseDateTextView.setText(book.getReleaseDate());
        holder.publisherTextView.setText(book.getPublisher());
        holder.priceTextView.setText(String.valueOf(book.getPrice()) + " đ");
        holder.bind(book, listener);
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    public void setBookList(List<Book> bookList) {
        mBookList = bookList;
        notifyDataSetChanged();
    }
}
