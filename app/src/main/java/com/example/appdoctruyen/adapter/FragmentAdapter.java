package com.example.appdoctruyen.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appdoctruyen.fragment.HistoryFragment;
import com.example.appdoctruyen.fragment.InfomationFragment;
import com.example.appdoctruyen.fragment.MainFragment;
import com.example.appdoctruyen.fragment.SearchFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private int pageNumber;
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HistoryFragment();
            case 1:
                return new MainFragment();
            case 2:
                return new SearchFragment();
            case 3:
                return new InfomationFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}