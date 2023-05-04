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
import com.example.appdoctruyen.NoiDungChuongActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.Chuong;
import com.example.appdoctruyen.model.Truyen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ChuongItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Chuong> chuongList;

    public ChuongItemAdapter(Context context, List<Chuong> chuongList) {
        this.context = context;
        this.chuongList = chuongList;
    }

    @NonNull
    @Override
    public ChuongItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chuong_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi người dùng click vào item
                int position = viewHolder.getAdapterPosition();
                Chuong chuongItem = chuongList.get(position);
                Intent intent = new Intent(context, NoiDungChuongActivity.class);
                intent.putExtra("idChuong", chuongItem.getId());
                context.startActivity(intent);
                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = auth.getCurrentUser();
                // Lưu lịch sử đọc
                DBHandler dbHelper = new DBHandler(context);
                Truyen truyen = dbHelper.getTruyen(chuongItem.getIdTruyen());
                dbHelper.addOrUpdateLichSuDoc(truyen.getId(), currentUser.getEmail(), truyen.getTen(), chuongItem.getTen(), chuongItem.getId(), truyen.getImage());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chuong chuongItem = chuongList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(chuongItem.getTen());
    }


    @Override
    public int getItemCount() {
        return chuongList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTenChuong);
        }
    }
}
