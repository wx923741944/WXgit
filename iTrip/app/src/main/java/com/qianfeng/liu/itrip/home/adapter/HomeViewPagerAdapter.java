package com.qianfeng.liu.itrip.home.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Home页面ViewPager的适配器
 * <p/>
 * Created by wangxiong
 *
 * @date 2011/1/1 0001.
 */
public class HomeViewPagerAdapter extends PagerAdapter {

    // 数据源
    private List<ImageView> list;
    // 加载器

    public HomeViewPagerAdapter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View iv = list.get(position);
        container.addView(iv);
        return iv;
    }


}
