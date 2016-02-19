package com.qianfeng.liu.itrip.others;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.qianfeng.liu.itrip.R;

public class MainActivity extends Activity {

    private Dialog dialog;
    private ImageView mIcon;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIcon = (ImageView) findViewById(R.id.main_guide_iv);
        if (isNetworkAvailable()) { // 判断网络可用
            if (isFirstUsed()) { // 第一次加载
                mIcon.setBackgroundResource(R.drawable.loading_default);
            } else {
                mIcon.setBackground(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.raw.loading)));
                mIcon.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.raw.yyb_activity));
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            popupNetDialog();
        }


    }

    /**
     * 判断用户是否第一次使用
     *
     * @return boolean true第一次使用
     */
    public boolean isFirstUsed() {
        SharedPreferences sharedPreferences = getSharedPreferences("ITrip", MODE_PRIVATE);
        return sharedPreferences.getBoolean("firstUsed", false);
    }


    /**
     * 判断当前网络是否可用
     *
     * @return boolean true可用
     */
    protected boolean isNetworkAvailable() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        if (connManager != null) {
            // 获取链接的所有信息
            NetworkInfo[] networkInfo = connManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /** 弹出对话框Button的监听器*/
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.network_cancel_btn:
                    System.exit(0);
                    break;
                case R.id.network_reset_btn:
                    dialog.dismiss();
                    onCreate(null);
                    break;
                case R.id.network_set_btn:
                    break;
            }

        }
    };


    /**
     * 没有网络是弹出对话框
     */
    protected void popupNetDialog() {
        View contentView = getLayoutInflater().inflate(R.layout.dialog_network, null);

        dialog = new Dialog(this, R.style.upgrade_dialog_style);


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(350, 200);
        dialog.addContentView(contentView, params);

        // 设置点击屏幕dialog不消失
        dialog.setCanceledOnTouchOutside(false);
        Button btnCancel = (Button) dialog.findViewById(R.id.network_cancel_btn);
        Button btnSet = (Button) dialog.findViewById(R.id.network_set_btn);
        Button btnReset = (Button) dialog.findViewById(R.id.network_reset_btn);
        btnReset.setOnClickListener(btnListener);
        btnCancel.setOnClickListener(btnListener);
        btnSet.setOnClickListener(btnListener);
        dialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
