package com.example.notepad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragmentColor extends Fragment {
    View RootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        RootView = layoutInflater.inflate(R.layout.fragment_color,container,false);
        return RootView;
    }

}
