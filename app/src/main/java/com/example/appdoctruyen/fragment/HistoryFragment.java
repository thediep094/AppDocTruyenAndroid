package com.example.appdoctruyen.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.LichSuItemAdapter;
import com.example.appdoctruyen.adapter.TruyenItemAdapter;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.LichSuDoc;
import com.example.appdoctruyen.model.Truyen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private LichSuItemAdapter lichSuItemAdapter;
    private TruyenItemAdapter truyenItemAdapter;
    private List<LichSuDoc> lichSuDocList;
    private List<Truyen> truyenList;
    private DBHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        Context context = getActivity();
        db = new DBHandler(context);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();
        lichSuDocList = db.getAllLichSuByIdUser(currentUser.getEmail());
        recyclerView = v.findViewById(R.id.listLichSu);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LichSuItemAdapter adapter = new LichSuItemAdapter(context, lichSuDocList);
        recyclerView.setAdapter(adapter);

        return v;
    }
}