package com.example.notepad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tuyaview extends View {
    private Context context;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mBitmapPaint;//画布的画笔
    private Paint mPaint;//真实的画笔
    private float mX,mY;
    private static final float TOUCH_TOLERANCE = 4;
    // 保存Path路径的集合
    private static List<DrawPath> savePath;
    // 保存已删除Path路径的集合
    private static List<DrawPath> deletePath;
    // 记录Path路径的对象
    private DrawPath dp;
    private int screenWidth, screenHeight;
    private int currentColor = Color.RED;
    private int currentSize = 5;
    private int currentStyle = 1;
    private int[] paintColor;//颜色集合
    //设置画图样式
    private static final int DRAW_PATH = 01;

    private int[] graphics = new int[]{DRAW_PATH};
    private int currentDrawGraphics = graphics[0];//默认画线

    private class DrawPath{
         public Path path;
         public Paint paint;
    }

    public tuyaview(Context context,int w,int h){
        super(context);
        this.context = context;
        screenWidth = w;
        screenHeight = h;
        paintColor = new int[]{Color.RED,
                               getResources().getColor(R.color.Orange),
                               Color.YELLOW,
                               Color.GREEN,
                               getResources().getColor(R.color.LightBlue),
                               Color.BLUE,
                               getResources().getColor(R.color.Pink),
                               Color.BLACK,
                               Color.WHITE,
                               Color.GRAY,
                               getResources().getColor(R.color.Brown),
                               Color.TRANSPARENT};
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        initCanvas();
        savePath = new ArrayList<DrawPath>();
        deletePath = new ArrayList<DrawPath>();
    }

    public void initCanvas(){
        setPaintStyle();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
        mBitmap = Bitmap.createBitmap(screenWidth,screenHeight,Bitmap.Config.ARGB_8888);
        mBitmap.eraseColor(Color.argb(0,0,0,0));
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.TRANSPARENT);
    }

    private void setPaintStyle(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);//外边缘
        mPaint.setStrokeCap(Paint.Cap.ROUND);//形状
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setDither(true);
        if(currentStyle == 1){
            mPaint.setStrokeWidth(currentSize);
            mPaint.setColor(currentColor);
        }else if (currentStyle == 2){
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            mPaint.setColor(Color.TRANSPARENT);
            mPaint.setStrokeWidth(currentSize);
            mPaint.setAlpha(0);
        }else if (currentStyle == 3){
            mPaint.setStrokeWidth(currentSize);
            mPaint.setColor(currentColor);
            mPaint.setMaskFilter(new BlurMaskFilter(30,BlurMaskFilter.Blur.SOLID));
            mPaint.setAlpha(160);
        }
    }

    @Override
    public void onDraw(Canvas canvas){
        //将前面画过的显示出来
        canvas.drawBitmap(mBitmap,0,0,mBitmapPaint);
        if(mPath != null){
            //实时显示
            canvas.drawPath(mPath,mPaint);
        }
    }

    private void touch_start(float x,float y){
        mPath.moveTo(x,y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x,float y){
        float dx = Math.abs(x-mX);
        float dy = Math.abs(mY-y);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE){
            if (currentDrawGraphics == DRAW_PATH){
                mPath.quadTo(mX,mY,(x+mX)/2,(y+mY)/2);
                mX = x;
                mY = y;
            }
        }
    }

    private void touch_up(){
        if(currentDrawGraphics == DRAW_PATH){
            mPath.lineTo(mX,mY);
        }
        mCanvas.drawPath(mPath,mPaint);
        //保存路径
        savePath.add(dp);
        mPath = null;//重新置空
    }

    //撤销
    public void undo(){
        if (savePath != null && savePath.size()>0){
            DrawPath drawPath = savePath.get(savePath.size()-1);
            deletePath.add(drawPath);
            savePath.remove(savePath.size()-1);
            redrawOnBitmap();
        }
    }

    //重做
    public void redo(){
        if(savePath != null && savePath.size()>0){
            savePath.clear();
            redrawOnBitmap();
        }
    }

    private void redrawOnBitmap(){
        initCanvas();
        Iterator<DrawPath>iter = savePath.iterator();
        while (iter.hasNext()){
            DrawPath drawPath = iter.next();
            mCanvas.drawPath(drawPath.path,drawPath.paint);
        }
        invalidate();//刷新
    }

    //恢复
    public void recover(){
        if(deletePath.size()>0){
            DrawPath dp = deletePath.get(deletePath.size()-1);
            savePath.add(dp);
            mCanvas.drawPath(dp.path,dp.paint);
            deletePath.remove(deletePath.size()-1);
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //每次down下去重新new一个Path
                mPath = new Path();
                //每一次记录的路径对象都不一样
                dp = new DrawPath();
                dp.path = mPath;
                dp.paint = mPaint;
                touch_start(x,y);
                invalidate();
                break;
                case  MotionEvent.ACTION_MOVE:
                    touch_move(x,y);
                    invalidate();
                    break;
                    case MotionEvent.ACTION_UP:
                        touch_up();
                        invalidate();
                        break;
        }
        return true;
    }

    //设置画笔格式
    public void selectPaintStyle(int which){
        //普通画笔
        if (which == 0){
            currentStyle = 1;
            setPaintStyle();
        }
        //当选择橡皮擦的时候颜色为白色
        if (which == 1){
            currentStyle = 2;
            setPaintStyle();
        }
        //荧光笔
        if (which == 2){
            currentStyle = 3;
           setPaintStyle();
        }
    }

    //选择画笔大小
    public void selectPaintSize(int which){
        currentSize = which+10;
        setPaintStyle();
    }

    //设置画笔颜色
    public void selectPaintColor(int which){
        currentColor = paintColor[which];
        setPaintStyle();
    }
}


