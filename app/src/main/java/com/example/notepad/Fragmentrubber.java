package com.example.notepad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmentrubber extends Fragment {
    private onPaintListener onPaintClick;

    View RootView4;

    private TextView rubber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        RootView4 = layoutInflater.inflate(R.layout.fragment_rubber,container,false);
        rubber = (TextView)RootView4.findViewById(R.id.rubber);

        return RootView4;
    }
public void onAttach(Activity activity){
        super.onAttach(activity);
        onPaintClick = (onPaintListener) activity;
}
public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        rubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onPaintClick.onPaintClick(1);
            }
        });
}
}
