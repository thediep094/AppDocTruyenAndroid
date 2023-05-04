package com.example.appdoctruyen.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.TruyenItemAdapter;
import com.example.appdoctruyen.database.DBHandler;
import com.example.appdoctruyen.model.Truyen;

import java.util.List;

public class SearchFragment extends Fragment {
    private DBHandler db;
    private List<Truyen> truyenList;
    private RecyclerView recyclerView;
    private TruyenItemAdapter truyenItemAdapter;
    EditText searchView;
    Button btnSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        Context context = getActivity();
        db = new DBHandler(context);
        searchView = v.findViewById(R.id.searchView);
        btnSearch = v.findViewById(R.id.button);
        recyclerView = v.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchView.getText().toString();
                truyenList = db.searchTruyenByName(query);
                truyenItemAdapter = new TruyenItemAdapter(getActivity(), truyenList);
                recyclerView.setAdapter(truyenItemAdapter);
            }
        });

        return v;

    }
}