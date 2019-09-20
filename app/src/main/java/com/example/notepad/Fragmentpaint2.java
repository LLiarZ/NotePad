package com.example.notepad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmentpaint2 extends Fragment {
    private OnColorListener onColorClick;
    private onPaintListener onPaintClick;

    View RootView3;
    private TextView red2;
    private TextView orange2;
    private TextView yellow2;
    private TextView green2;
    private TextView lightblue2;
    private TextView darkblue2;
    private TextView pink2;
    private TextView black2;
    private TextView white2;
    private TextView grey2;
    private TextView brown2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        RootView3 = layoutInflater.inflate(R.layout.fragment_paint2,container,false);
        red2 = (TextView) RootView3.findViewById(R.id.paint1_red2);
        orange2 = (TextView) RootView3.findViewById(R.id.paint1_orange2);
        yellow2 = (TextView) RootView3.findViewById(R.id.paint1_yellow2);
        green2 = (TextView) RootView3.findViewById(R.id.paint1_green2);
        lightblue2 = (TextView) RootView3.findViewById(R.id.paint1_lblue2);
        darkblue2 = (TextView) RootView3.findViewById(R.id.paint1_dblue2);
        pink2 = (TextView) RootView3.findViewById(R.id.paint1_pink2);
        black2 = (TextView) RootView3.findViewById(R.id.paint1_black2);
        white2 = (TextView) RootView3.findViewById(R.id.paint1_white2);
        grey2 = (TextView) RootView3.findViewById(R.id.paint1_grey2);
        brown2 = (TextView) RootView3.findViewById(R.id.paint1_brown2);

        return RootView3;

    }
    public void onAttach(Activity activity){
        super.onAttach(activity);
        onColorClick = (OnColorListener)activity;
        onPaintClick = (onPaintListener)activity;
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(0);
                onPaintClick.onPaintClick(2);
            }
        });
        orange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(1);
                onPaintClick.onPaintClick(2);
            }
        });
        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(2);
                onPaintClick.onPaintClick(2);
            }
        });
        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(3);
                onPaintClick.onPaintClick(2);
            }
        });
        lightblue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(4);
                onPaintClick.onPaintClick(2);
            }
        });
        darkblue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(5);
                onPaintClick.onPaintClick(2);
            }
        });
        pink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(6);
                onPaintClick.onPaintClick(2);
            }
        });
        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(7);
                onPaintClick.onPaintClick(2);
            }
        });
        white2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(8);
                onPaintClick.onPaintClick(2);
            }
        });
        grey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(9);
                onPaintClick.onPaintClick(2);
            }
        });
        brown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onColorClick.onColorClick(10);
                onPaintClick.onPaintClick(2);
            }
        });





    }
}
