package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_name;
    private TextView tv_date;
    private Button btn_newpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_newpage = (Button)findViewById(R.id.btn_newpage) ;

        tv_name = (TextView)findViewById(R.id.tv_Name);
        tv_date = (TextView)findViewById(R.id.tv_Date);

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_name.setBackgroundResource(R.drawable.selector_text_background);
                tv_date.setBackgroundResource(R.drawable.selector_text_background2);
            }
        });
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_date.setBackgroundResource(R.drawable.selector_text_background);
                tv_name.setBackgroundResource(R.drawable.selector_text_background2);
            }
        });


        btn_newpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NewpageDialog.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}
