package com.example.sqlite_th2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookFavorite extends Fragment {

    private ImageView bookCoverImageView;
    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private TextView bookReviewTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_favorite, container, false);

        bookCoverImageView = view.findViewById(R.id.book_cover);
        bookTitleTextView = view.findViewById(R.id.book_title);
        bookAuthorTextView = view.findViewById(R.id.book_author);
        bookReviewTextView = view.findViewById(R.id.book_review);

        bookTitleTextView.setText("Chúa tể của những chiếc nhẫn");
        bookAuthorTextView.setText("J.R.R. Tolkien");
        bookReviewTextView.setText("\"Chúa tể của những chiếc nhẫn\" (tiếng Anh: \"The Lord of the Rings\") là một tác phẩm văn học viễn tưởng nổi tiếng của nhà văn người Anh J.R.R. Tolkien. Tác phẩm được viết thành ba phần và xuất bản lần đầu tiên vào năm 1954 và 1955.\n" + "\n" + "Câu chuyện của \"Chúa tể của những chiếc nhẫn\" xoay quanh một chiếc nhẫn quý giá và sức mạnh vô song của nó, và những cuộc phiêu lưu của những người cố gắng giành chiếc nhẫn này trước khi nó rơi vào tay kẻ thù Sauron - một ác ma đang tìm cách thu thập những chiếc nhẫn để trở nên bất khả chiến bại và chiếm lấy thế giới.\n" + "\n" + "Trong tác phẩm, J.R.R. Tolkien xây dựng một thế giới giả tưởng tuyệt đẹp với những cảnh đẹp như vườn Shire, núi lửa nguy hiểm, rừng sâu và cả những khu vực đen tối, tăm tối và nguy hiểm. Nhân vật chính Frodo Baggins cùng với những người bạn đồng hành đã phải đối mặt với nhiều khó khăn và nguy hiểm để đến được đích đến cuối cùng.\n" + "\n" + "\"Chúa tể của những chiếc nhẫn\" đã trở thành một tác phẩm văn học kinh điển và được đánh giá cao về cả nội dung và cách viết. Tác phẩm đã được chuyển thể thành phim và trò chơi điện tử, và vẫn là một trong những tác phẩm viễn tưởng nổi tiếng nhất và được yêu thích nhất trên thế giới.");
        return view;
    }
}
