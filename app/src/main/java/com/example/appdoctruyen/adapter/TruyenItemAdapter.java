package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.ChuongActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.Chuong;
import com.example.appdoctruyen.model.Truyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TruyenItemAdapter extends RecyclerView.Adapter<TruyenItemAdapter.ViewHolder> {

    private Context context;
    private List<Truyen> truyenItemList;

    public TruyenItemAdapter(Context context, List<Truyen> truyenItemList) {
        this.context = context;
        this.truyenItemList = truyenItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.truyen_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi người dùng click vào item
                int position = viewHolder.getAdapterPosition();
                Truyen truyenItem = truyenItemList.get(position);
                Intent intent = new Intent(context, ChuongActivity.class);
                intent.putExtra("IdTruyen", truyenItem.getId());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Truyen truyenItem = truyenItemList.get(position);
        String[] imageName = truyenItem.getImage().split("[.]");
        String imageNameFormat = imageName[0].toLowerCase();
        int resID = context.getResources().getIdentifier(imageNameFormat , "drawable" , context.getPackageName());
        holder.imageView.setImageResource(resID);
        holder.textView.setText(truyenItem.getTen());
    }

    @Override
    public int getItemCount() {
        return truyenItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.truyenImage);
            textView = itemView.findViewById(R.id.truyenName);
        }
    }
}
