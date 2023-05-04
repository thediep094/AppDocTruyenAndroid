package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.Chuong;
import com.example.appdoctruyen.model.Truyen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NoiDungChuongActivity extends AppCompatActivity {
    DBHandler dbHandler;
    TextView txtNoiDung,txtTenChuong;
    Button btnBack, btnNextChapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_chuong);
        dbHandler = new DBHandler(this);
        txtNoiDung = findViewById(R.id.textViewNoiDung);
        txtTenChuong = findViewById(R.id.textViewName);
        btnBack = findViewById(R.id.button2);
        btnNextChapter = findViewById(R.id.button3);
        // Nhận truyenId từ intent
        Intent intent = getIntent();
        int idChuong = intent.getIntExtra("idChuong", -1);
        dbHandler = new DBHandler(this);
        Chuong chuong = dbHandler.getChuong(idChuong);
        txtTenChuong.setText(chuong.getTen());
        txtNoiDung.setText(chuong.getNoiDung());
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();
        // Lưu lịch sử đọc
        DBHandler dbHelper = new DBHandler(this);
        Truyen truyen = dbHelper.getTruyen(chuong.getIdTruyen());
        dbHelper.addOrUpdateLichSuDoc(truyen.getId(), currentUser.getEmail(), truyen.getTen(), chuong.getTen(), chuong.getId(), truyen.getImage());
        //Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChuongActivity.class);
                intent.putExtra("IdTruyen", chuong.getIdTruyen());
                startActivity(intent);
                finish();
            }
        });


        //Next chapter
        btnNextChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextChapId = dbHandler.getNextChapterId(chuong.getSoThuTu(), chuong.getIdTruyen());
                if (nextChapId == -1) {
                    Toast.makeText(getApplicationContext(), "This is the last chapter", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), NoiDungChuongActivity.class);
                    intent.putExtra("idChuong", nextChapId);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}