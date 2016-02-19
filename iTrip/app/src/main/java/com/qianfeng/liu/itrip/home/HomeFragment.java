package com.qianfeng.liu.itrip.home;

import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.qianfeng.liu.itrip.R;
import com.qianfeng.liu.itrip.home.adapter.HomeViewPagerAdapter;
import com.qianfeng.liu.itrip.home.bean.Trip;
import com.qianfeng.liu.itrip.others.BaseFragment;
import com.qianfeng.liu.itrip.others.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * home页面的fragment
 * <p/>
 * Created by wangxiong
 *
 * @date 2016/2/1 0001.
 */
public class HomeFragment extends BaseFragment {

    private ViewPager vpBanner;
    private String httpUrl = "http://mobile.itrip.com/index/adp?id=0&channel=3000";
    private List<ImageView> ivList;
    private HomeViewPagerAdapter adapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        vpBanner = (ViewPager) root.findViewById(R.id.fragment_banner_vp);
    }

    @Override
    protected void initData() {
        ivList = new ArrayList<>();
        getHttpString();

    }

    @Override
    protected void initEvent() {

    }

    protected void getHttpString() {
        StringRequest request = new StringRequest(httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("tag", response);
                Gson gson = new Gson();
                Trip trip = gson.fromJson(response, Trip.class);
                getImageView(trip.getResult().getBanners());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.i("tag",error.getMessage());
            }
        });
        MyApplication.mQueue.add(request);
    }

    protected void getImageView(List<Trip.ResultEntity.BannersEntity> list) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (Trip.ResultEntity.BannersEntity banner : list) {
            ImageView iv = new ImageView(getActivity());
            getBitmap(iv, banner.getImg());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            ivList.add(iv);
        }
        adapter = new HomeViewPagerAdapter(ivList);
        vpBanner.setAdapter(adapter);
    }



    protected void getBitmap(ImageView iv, String url) {
        int iMaxMen = (int) Runtime.getRuntime().maxMemory();

        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(iMaxMen / 8) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
        ImageLoader imageLoader = new ImageLoader(MyApplication.mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url, bitmap);
            }
        });

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv, R.drawable.ic_launcher, R.drawable.ic_launcher);

        imageLoader.get(url, listener);
        // adapter.notifyDataSetChanged();
    }
}
