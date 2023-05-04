package com.example.appdoctruyen.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.appdoctruyen.LoginActivity;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.TruyenItemAdapter;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.Truyen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


public class MainFragment extends Fragment {
    private RecyclerView recyclerView;
    private TruyenItemAdapter truyenItemAdapter;
    private List<Truyen> truyenList;
    private DBHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Context context = getActivity();
        db = new DBHandler(context);
        truyenList = db.getAllTruyen();
        recyclerView = v.findViewById(R.id.listTruyen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TruyenItemAdapter adapter = new TruyenItemAdapter(context, truyenList);
        recyclerView.setAdapter(adapter);

        return v;
    }
}