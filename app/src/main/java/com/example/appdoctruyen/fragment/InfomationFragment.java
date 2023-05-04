package com.example.appdoctruyen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.appdoctruyen.LoginActivity;
import com.example.appdoctruyen.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InfomationFragment extends Fragment {
    FirebaseAuth auth;
    Button buttonLogout;
    TextView textView;
    FirebaseUser user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_infomation, container, false);
        textView = v.findViewById(R.id.textViewInformation);
        buttonLogout = v.findViewById(R.id.btn_logout);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user != null) {
           textView.setText(user.getEmail());
        }
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return v;
    }
}