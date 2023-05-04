package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.NoiDungChuongActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.BinhLuan;
import com.example.appdoctruyen.model.Chuong;

import java.util.List;

public class BinhLuanItemAdapter extends RecyclerView.Adapter<BinhLuanItemAdapter.ViewHolder> {
    private Context context;
    private List<BinhLuan> binhLuanList;

    public BinhLuanItemAdapter(Context context, List<BinhLuan> binhLuanList) {
        this.context = context;
        this.binhLuanList = binhLuanList;
    }

    @NonNull
    @Override
    public BinhLuanItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.binh_luan_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BinhLuan binhLuanItem = binhLuanList.get(position);
        holder.binhLuanText.setText(binhLuanItem.getNoiDung());
        holder.userText.setText(binhLuanItem.getTenNguoiDung());
    }


    @Override
    public int getItemCount() {
        return binhLuanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView binhLuanText,userText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binhLuanText = itemView.findViewById(R.id.textViewComment);
            userText = itemView.findViewById(R.id.textViewUser);
        }
    }
}
