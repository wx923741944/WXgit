package com.qianfeng.liu.itrip.others;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.qianfeng.liu.itrip.R;
import com.qianfeng.liu.itrip.found.FoundFragment;
import com.qianfeng.liu.itrip.home.HomeFragment;
import com.qianfeng.liu.itrip.my.MyFragment;
import com.qianfeng.liu.itrip.trip.TripFragment;

/**
 * 首页
 *
 * Created by wangxiong
 *
 * @date 2016/2/1 0001.
 */

public class HomeActivity extends FragmentActivity {

    private Fragment[] mFragments;
    private FragmentManager manager;
    private FrameLayout flContent;
    Toolbar mToolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFragments = new Fragment[]{new HomeFragment(),new FoundFragment(),new TripFragment(),new MyFragment()};
        flContent = (FrameLayout) findViewById(R.id.home_fl);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < mFragments.length; i++) {
            Fragment fragment = mFragments[i];
            transaction.add(R.id.home_fl,fragment);
            transaction.hide(fragment);
        }
        transaction.show(mFragments[0]);
        transaction.commit();

    }


}
