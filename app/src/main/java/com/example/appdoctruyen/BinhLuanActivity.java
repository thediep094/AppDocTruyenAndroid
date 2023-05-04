package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appdoctruyen.adapter.BinhLuanItemAdapter;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.BinhLuan;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class BinhLuanActivity extends AppCompatActivity {
    DBHandler dbHandler;
    private RecyclerView recyclerView;
    private BinhLuanItemAdapter binhLuanItemAdapter;
    EditText comment;
    FirebaseAuth auth;
    FirebaseUser user;
    Button submit, btnBack;

    private List<BinhLuan> binhLuanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binh_luan);
        dbHandler = new DBHandler(this);
        recyclerView = findViewById(R.id.recyclerView1);
        comment = findViewById(R.id.editComment);
        submit = findViewById(R.id.buttonSubmit);
        btnBack = findViewById(R.id.button2);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        // Nhận truyenId từ intent
        Intent intent = getIntent();
        int idTruyen = intent.getIntExtra("idTruyen", -1);
        binhLuanList = dbHandler.getAllBinhLuan(idTruyen);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binhLuanItemAdapter = new BinhLuanItemAdapter(this, binhLuanList);
        recyclerView.setAdapter(binhLuanItemAdapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChuongActivity.class);
                intent.putExtra("IdTruyen", idTruyen);
                startActivity(intent);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenNguoiDung = user.getEmail();
                String noiDung = comment.getText().toString();
                BinhLuan binhLuan = new BinhLuan(idTruyen, tenNguoiDung, noiDung);
                dbHandler.addBinhLuan(binhLuan);
                binhLuanList.add(binhLuan);
                binhLuanItemAdapter.notifyDataSetChanged();
                comment.setText("");
            }
        });
    }
}