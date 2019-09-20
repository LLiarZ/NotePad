package com.example.notepad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Fragmentpaint1 extends Fragment {
    private OnColorListener onColorClick;
    private onPaintListener onPaintClick;
    View RootView2;
     private TextView red;
     private TextView orange;
    private TextView yellow;
    private TextView green;
    private TextView lightblue;
    private TextView darkblue;
    private TextView pink;
    private TextView black;
    private TextView white;
    private TextView grey;
    private TextView brown;

     @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
     ){
         LayoutInflater layoutInflater = LayoutInflater.from(getContext());
         RootView2 = layoutInflater.inflate(R.layout.fragment_paint1,container,false);
         red = (TextView) RootView2.findViewById(R.id.paint1_red);
         orange = (TextView) RootView2.findViewById(R.id.paint1_orange);
         yellow = (TextView) RootView2.findViewById(R.id.paint1_yellow);
         green = (TextView) RootView2.findViewById(R.id.paint1_green);
         lightblue = (TextView) RootView2.findViewById(R.id.paint1_lblue);
         darkblue = (TextView) RootView2.findViewById(R.id.paint1_dblue);
         pink = (TextView) RootView2.findViewById(R.id.paint1_pink);
         black = (TextView) RootView2.findViewById(R.id.paint1_black);
         white = (TextView) RootView2.findViewById(R.id.paint1_white);
         grey = (TextView) RootView2.findViewById(R.id.paint1_grey);
         brown = (TextView) RootView2.findViewById(R.id.paint1_brown);

         return RootView2;
     }

    public void onAttach(Activity activity){
         super.onAttach(activity);
         onColorClick = (OnColorListener)activity;
         onPaintClick = (onPaintListener)activity;
    }

     public void onActivityCreated(final Bundle savedInstanceState){
         super.onActivityCreated(savedInstanceState);
         red.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(0);
                 onPaintClick.onPaintClick(0);
             }
         });
         orange.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(1);
                 onPaintClick.onPaintClick(0);
             }
         });
         yellow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(2);
                 onPaintClick.onPaintClick(0);
             }
         });
         green.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(3);
                 onPaintClick.onPaintClick(0);
             }
         });
         lightblue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(4);
                 onPaintClick.onPaintClick(0);
             }
         });
         darkblue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(5);
                 onPaintClick.onPaintClick(0);
             }
         });
         pink.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(6);
                 onPaintClick.onPaintClick(0);
             }
         });
         black.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(7);
                 onPaintClick.onPaintClick(0);
             }
         });
         white.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(8);
                 onPaintClick.onPaintClick(0);
             }
         });
         grey.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(9);
                 onPaintClick.onPaintClick(0);
             }
         });
         brown.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onColorClick.onColorClick(10);
                 onPaintClick.onPaintClick(0);
             }
         });
     }
}
