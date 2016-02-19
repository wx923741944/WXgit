package com.qianfeng.liu.itrip.others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangxiong
 *
 * @date 2016/2/1 0001.
 */
public abstract class BaseFragment extends Fragment {

    /** 加载的根布局*/
    protected View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(getLayout(),container,false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

        initData();

        initEvent();

    }

    /**
     * 加载对应的布局文件的id
     * @return R管理的布局文件的id
     */
    protected abstract int getLayout();

    /**
     * 控件出事化
     */
    protected abstract void initView();

    /**
     * 数据初始化
     */
    protected abstract void initData();

    /**
     * 绑定事件
     */
    protected abstract void initEvent();
}
