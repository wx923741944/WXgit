package com.qiangfeng.wujiaoxin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangxiong
 *
 * @data 16-1-15.
 */
public class couston extends View {

    private Paint paint;
    private int count = 5;
    private int selected = 9;
    private Bitmap bmSelected ;
    private Bitmap bmNormol;
    private int width;
    private int height;
    public couston(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
       paint = new Paint();
        bmSelected = BitmapFactory.decodeResource(getResources(), R.drawable.ic_star_selected);
        bmNormol = BitmapFactory.decodeResource(getResources(), R.drawable.ic_star_unselecte);
        width = bmNormol.getWidth();
        height = bmNormol.getHeight();
    }

    public couston(Context context) {
        super(context);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect src = new Rect();// 图片
        Rect dst = new Rect();// 屏幕位置及尺寸
        //src 这个是表示绘画图片的大小
        src.left = 0;   //0,0
        src.top = 0;
        src.right = width/2;// mBitDestTop.getWidth();,这个是桌面图的宽度，
        src.bottom = height;//mBitDestTop.getHeight()/2;// 这个是桌面图的高度的一半
        // 下面的 dst 是表示 绘画这个图片的位置
        dst.left = 10;    //miDTX,//这个是可以改变的，也就是绘图的起点X位置
        dst.top = 10;    //mBitQQ.getHeight();//这个是QQ图片的高度。 也就相当于 桌面图片绘画起点的Y坐标
        dst.right =  10+width/2;    //miDTX + mBitDestTop.getWidth();// 表示需绘画的图片的右上角
        dst.bottom = 10+height;    // mBitQQ.getHeight() + mBitDestTop.getHeight();//表示需绘画的图片的右下角

        for (int i = 0; i < count; i++) {
            if (selected%2 == 0){
                canvas.drawBitmap(bmSelected,width*i,0,paint);
            } else {
                if (selected / 2 == i) {
                    dst.left = width*i-width;    //miDTX,//这个是可以改变的，也就是绘图的起点X位置
                    dst.top = 0;    //mBitQQ.getHeight();//这个是QQ图片的高度。 也就相当于 桌面图片绘画起点的Y坐标
                    dst.right =  width*i-width/2;    //miDTX + mBitDestTop.getWidth();// 表示需绘画的图片的右上角
                    dst.bottom = width;    // mBitQQ.getHeight() + mBitDestTop.getHeight();//表示需绘画的图片的右下角
                    canvas.drawBitmap(bmSelected,src,dst,paint);
                    src.left = width/2;   //0,0
                    src.right = width;// mBitDestTop.getWidth();,这个是桌面图的宽度，
                    dst.left = width*i-width/2;    //miDTX,//这个是可以改变的，也就是绘图的起点X位置
                    dst.top = 0;    //mBitQQ.getHeight();//这个是QQ图片的高度。 也就相当于 桌面图片绘画起点的Y坐标
                    dst.right =  width*i;    //miDTX + mBitDestTop.getWidth();// 表示需绘画的图片的右上角
                    dst.bottom = height;    // mBitQQ.getHeight() + mBitDestTop.getHeight();//表示需绘画的图片的右下角
                    canvas.drawBitmap(bmNormol,src,dst,paint);
                }
            }


                //canvas.drawBitmap(bmNormol,width*i,0,paint);


        }






       // Canvas c = canvas;//实例Canvas

       // c.save();//记录原来的canvas状态
        //c.clipRect(100,100,200,300);//显示从(100,100)到(200,300)的区域(单位:象素)

        //c.drawBitmap(bmSelected,10,0,null); //将阉割过的图片画到(10,0)位置
        //c.restore();//恢复canvas状态


        //canvas.drawBitmap(bmSelected,30,30,paint);



    }
}
