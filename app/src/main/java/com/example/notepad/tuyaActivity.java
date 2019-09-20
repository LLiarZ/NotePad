package com.example.notepad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class tuyaActivity extends AppCompatActivity implements View.OnClickListener,OnColorListener ,MySeekBarListener,onPaintListener,ClearListener,ShapesListener{
       private FrameLayout frameLayout;
       private RadioGroup mGroup;
       private RadioButton btn_undo;
       private RadioButton btn_recover;
       private tuyaview tuyaview;
       private RadioButton btn_paintstyle;
       private RadioButton btn_shapes;

    private DragView dragView;
    private Context mContext;
    private static final String TAG = "MainActivity";

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tuya);
        initView();
        initData();
        initListener();
           mContext =this;
           dragView = (DragView)findViewById(R.id.dragview);

           btn_shapes = (RadioButton)findViewById(R.id.btn_shapes);
           btn_shapes.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   showShapesDialog(view);
               }
           });
    }

    private void initView(){
        frameLayout = (FrameLayout)findViewById(R.id.f1_boardcontainer);
        mGroup = (RadioGroup)findViewById(R.id.rd_group);
        btn_undo = (RadioButton)findViewById(R.id.btn_undo);
        btn_recover = (RadioButton)findViewById(R.id.btn_recover);
        btn_paintstyle = (RadioButton)findViewById(R.id.btn_paintstyle);
        btn_shapes = (RadioButton)findViewById(R.id.btn_shapes);
    }

    private void initData(){
        //获取屏幕宽高//可以通过framelayout实现控制涂鸦板的大小//
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int screenWidth = defaultDisplay.getWidth();
        int screenHeight = defaultDisplay.getHeight();
        tuyaview = new tuyaview(this,screenWidth,screenHeight);
        frameLayout.addView(tuyaview);
        tuyaview.requestFocus();
    }

    private void initListener(){
        mGroup.setOnClickListener(this);
        btn_undo.setOnClickListener(this);
        btn_recover.setOnClickListener(this);
        btn_paintstyle.setOnClickListener(this);
        btn_shapes.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case  R.id.btn_undo:
                tuyaview.undo();
                break;
            case  R.id.btn_recover:
                tuyaview.recover();
                break;
            case R.id.btn_paintstyle:
                showPaintStyleDialog(v);
                break;
            case R.id.btn_shapes:
                showShapesDialog(v);
                break;
        }
    }

    public void showPaintStyleDialog(View v){
        PaintStyleDialog dialog = new PaintStyleDialog();
        dialog.show(getSupportFragmentManager(),"paintstyledialog");
    }

    public void showShapesDialog(View v){
           ShapesDialog dialog = new ShapesDialog();
           dialog.show(getSupportFragmentManager(),"shapesdialog");
    }

    public void onColorClick(int which){
           tuyaview.selectPaintColor(which);
       }

    public void SeekSizeChange(int which){
        tuyaview.selectPaintSize(which);
    }

    public  void onPaintClick(int which){
        tuyaview.selectPaintStyle(which);
    }

    public void onClickClear(){
           tuyaview.redo();
       }
    public void ShapesClick(){
           dragView.addDragView(R.layout.my_self_view,0,400,380,760,true,false);
    }
}
