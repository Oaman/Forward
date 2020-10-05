package com.oman.dispatch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
import java.util.Map;

public class MyPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Map<String, Integer>> mData;


    public MyPagerAdapter(Context context, List<Map<String, Integer>> list) {
        mContext = context;
        mData = list;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item_list, null);
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(new SimpleAdapter(container.getContext(), mData, R.layout.item_base, new String[]{"key"}, new int[]{R.id.iv}));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
