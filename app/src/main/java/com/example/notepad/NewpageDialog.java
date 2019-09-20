package com.example.notepad;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class NewpageDialog extends AppCompatActivity {
    private RadioButton rb_basic;
    private RadioButton rb_color;
    private TextView tv_cancel;
    ViewPager myviewpager;
    MyFragmentPaperAdapter myadapter;
    RadioGroup myradiogroup;



    protected  void  onCreate(Bundle  savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.newpage_dialog);
        rb_basic = (RadioButton)findViewById(R.id.rb_basic);
        rb_color = (RadioButton)findViewById(R.id.rb_color_paper);
        tv_cancel = (TextView)findViewById(R.id.tv_cancel);

        myviewpager = findViewById(R.id.viewpager);
        myradiogroup = findViewById(R.id.rg1);
        myradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.rb_basic:myviewpager.setCurrentItem(0);break;
                    case R.id.rb_color_paper:myviewpager.setCurrentItem(1);break;
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
                    case 0:myradiogroup.check(R.id.rb_basic);break;
                    case 1:myradiogroup.check(R.id.rb_color_paper);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        List<Fragment>myfragment = new ArrayList<>();
        myfragment.add(new MainFragmentBasic());
        myfragment.add(new MainFragmentColor());
        myadapter = new MyFragmentPaperAdapter(getSupportFragmentManager(),myfragment);
        myviewpager.setAdapter(myadapter);

        rb_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_basic.setBackgroundResource(R.drawable.selector_text_background3);
                rb_color.setBackgroundResource(R.drawable.selector_text_background4);
            }
        });

        rb_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_color.setBackgroundResource(R.drawable.selector_text_background3);
                rb_basic.setBackgroundResource(R.drawable.selector_text_background4);
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_cancel.setBackgroundResource(R.drawable.selector_text_background3);
                Intent intent=new Intent(NewpageDialog.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
