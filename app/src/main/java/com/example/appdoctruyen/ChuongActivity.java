package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyen.adapter.ChuongItemAdapter;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.fragment.MainFragment;
import com.example.appdoctruyen.model.Chuong;
import com.example.appdoctruyen.model.Truyen;

import java.util.List;

public class ChuongActivity extends AppCompatActivity {
    DBHandler dbHandler;
    private RecyclerView recyclerView;
    private ChuongItemAdapter chuongItemAdapter;
    TextView txtTen, txtTacGia, txtSoChuong,txtTheLoai;
    ImageView imageView;
    Button btnBack, btnBinhLuan;
    private List<Chuong> chuongList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong);
        txtTen = findViewById(R.id.textViewTen);
        txtTacGia = findViewById(R.id.textViewTacGia);
        txtSoChuong = findViewById(R.id.textViewSoChuong);
        txtTheLoai = findViewById(R.id.textViewTheLoai);
        imageView = findViewById(R.id.imageView);
        btnBack = findViewById(R.id.button2);
        btnBinhLuan = findViewById(R.id.button3);
        recyclerView = findViewById(R.id.listChuongRecycle);
        // Nhận truyenId từ intent
        Intent intent = getIntent();
        int idTruyen = intent.getIntExtra("IdTruyen", -1);
        dbHandler = new DBHandler(this);
        Truyen truyen = dbHandler.getTruyen(idTruyen);
        chuongList = dbHandler.getChuongListByIdTruyen(idTruyen);
        txtTen.setText(truyen.getTen());
        txtTacGia.setText("Tac Gia: " + truyen.getTacGia());
        txtSoChuong.setText("So Chuong: " + String.valueOf(truyen.getSoChuong()));
        txtTheLoai.setText("The Loai: "+ truyen.getTheLoai());
        String[] imageName = truyen.getImage().split("[.]");
        String imageNameFormat = imageName[0].toLowerCase();
        int resID = this.getResources().getIdentifier(imageNameFormat , "drawable" , this.getPackageName());
        imageView.setImageResource(resID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chuongItemAdapter = new ChuongItemAdapter(this,chuongList);
        recyclerView.setAdapter(chuongItemAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnBinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinhLuanActivity.class);
                intent.putExtra("idTruyen", idTruyen);
                startActivity(intent);
                finish();
            }
        });

    }
}