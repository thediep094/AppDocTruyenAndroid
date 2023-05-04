package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.ChuongActivity;
import com.example.appdoctruyen.NoiDungChuongActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.LichSuDoc;
import com.example.appdoctruyen.model.Truyen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LichSuItemAdapter extends RecyclerView.Adapter<LichSuItemAdapter.ViewHolder>{
    private Context context;
    private List<LichSuDoc> lichSuDocList;

    public LichSuItemAdapter(Context context, List<LichSuDoc> lichSuDocList) {
        this.context = context;
        this.lichSuDocList = lichSuDocList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lich_su_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Xử lý khi người dùng click vào item
//                int position = viewHolder.getAdapterPosition();
//                LichSuDoc lichSuDocItem = lichSuDocList.get(position);
//                Intent intent = new Intent(context, NoiDungChuongActivity.class);
//                intent.putExtra("idChuong", lichSuDocItem.getChapterNumber());
//                context.startActivity(intent);
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LichSuDoc lichSuItem = lichSuDocList.get(position);
        String imageName = lichSuItem.getImage();
        String imageNameFormat = imageName.replace(".jpg","").toLowerCase();
        int resID = context.getResources().getIdentifier(imageNameFormat , "drawable" , context.getPackageName());
        holder.imageView.setImageResource(resID);
        holder.textViewName.setText(lichSuItem.getTenTruyen());
        holder.textViewChapter.setText(lichSuItem.getTenChapter());
        holder.textViewTime.setText(lichSuItem.getReadTime());
    }

    @Override
    public int getItemCount() {
        return lichSuDocList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName,textViewChapter,textViewTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.truyenImage1);
            textViewName = itemView.findViewById(R.id.truyenName1);
            textViewChapter = itemView.findViewById(R.id.textViewChapter1);
            textViewTime = itemView.findViewById(R.id.textViewTime1);
        }
    }

}
