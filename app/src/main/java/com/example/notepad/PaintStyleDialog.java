package com.example.notepad;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class PaintStyleDialog extends DialogFragment{
    private RadioButton paint1;
    private RadioButton paint2;
    private RadioButton paint3;

    private Button clear;

    private View view;
    private ViewPager myviewpager;
    private RadioGroup myradiogroup;
    private MyFragmentPaperAdapter myadapter;

    private MySeekBarListener SeekSizeChange;
    private SeekBar sb_size2;
    private ClearListener onClickClear;


    public void onAttach(Activity activity){
        super.onAttach(activity);
        SeekSizeChange = (MySeekBarListener)activity;
        onClickClear = (ClearListener)activity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.Dialog2);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.paintstyledialog,container);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater Inflater = getActivity().getLayoutInflater();
        paint1 = (RadioButton)view.findViewById(R.id.rb_paint1);
        paint2 = (RadioButton)view.findViewById(R.id.rb_paint2);
        paint3 = (RadioButton)view.findViewById(R.id.rb_rubber);

        sb_size2 = (SeekBar)view.findViewById(R.id.sb_size2);
        sb_size2.setOnSeekBarChangeListener(new MySeekBarListener2());

        clear = (Button)view.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickClear.onClickClear();
                dismiss();
            }
        });

        clear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    v.setBackgroundResource(R.mipmap.clear2);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    v.setBackgroundResource(R.mipmap.clear);
                }
                return false;
            }
        });

        myviewpager = (ViewPager)view.findViewById(R.id.viewpager2);
        myradiogroup = (RadioGroup)view.findViewById(R.id.rg2);
        myradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.rb_paint1:myviewpager.setCurrentItem(0);break;
                    case R.id.rb_paint2:myviewpager.setCurrentItem(1);break;
                    case R.id.rb_rubber:myviewpager.setCurrentItem(2);break;
                }
            }
        });
        myviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:myradiogroup.check(R.id.rb_paint1);break;
                    case 1:myradiogroup.check(R.id.rb_paint2);break;
                    case 2:myradiogroup.check(R.id.rb_rubber);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        List<Fragment> myfragment = new ArrayList<>();
        myfragment.add(new Fragmentpaint1());
        myfragment.add(new Fragmentpaint2());
        myfragment.add(new Fragmentrubber());
        myadapter = new MyFragmentPaperAdapter(getChildFragmentManager(),myfragment);
        myviewpager.setAdapter(myadapter);


        paint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint1.setBackgroundResource(R.drawable.selector_text_background3);
                paint2.setBackgroundResource(R.drawable.selector_text_background4);
                paint3.setBackgroundResource(R.drawable.selector_text_background4);
            }
        });
        paint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint2.setBackgroundResource(R.drawable.selector_text_background3);
                paint1.setBackgroundResource(R.drawable.selector_text_background4);
                paint3.setBackgroundResource(R.drawable.selector_text_background4);
            }
        });
        paint3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint3.setBackgroundResource(R.drawable.selector_text_background3);
                paint1.setBackgroundResource(R.drawable.selector_text_background4);
                paint2.setBackgroundResource(R.drawable.selector_text_background4);
            }
        });

        builder.setView(view);
    }
    public class MySeekBarListener2 implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
            SeekSizeChange.SeekSizeChange(seekBar.getProgress());
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar){
            SeekSizeChange.SeekSizeChange(seekBar.getProgress());
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar){}
    }

    public void onResume(){
        super.onResume();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.LEFT|Gravity.TOP);
        lp.x=0;
        lp.y=300;
        lp.width=700;
        lp.height=550;
        lp.alpha=1f;
        lp.dimAmount=0f;
        window.setAttributes(lp);
    }
}
