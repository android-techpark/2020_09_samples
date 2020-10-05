package ru.park.mail.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<DataSource.NewsModel> news =  DataSource.getInstance().getData();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(news);

        recyclerView.setAdapter(adapter);

    }

    public static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<DataSource.NewsModel> mData;

        public MyAdapter(List<DataSource.NewsModel> data) {
            mData = data;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("MyAdapter", "onCreateViewHolder");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Log.d("MyAdapter", "onBindViewHolder with position: " + position);
            DataSource.NewsModel model = mData.get(position);
            holder.mImage.setBackgroundColor(model.getColor());
            holder.mTitle.setText(model.getTitle());
            holder.mDate.setText(model.getDate());
            holder.itemView.setOnClickListener(view -> Toast.makeText(view.getContext().getApplicationContext(), "Clicked on " + position, Toast.LENGTH_SHORT).show());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mImage;
        public final TextView mTitle;
        public final TextView mDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mTitle = itemView.findViewById(R.id.title);
            mDate = itemView.findViewById(R.id.date);
        }
    }
}