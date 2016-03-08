package com.xinxin.mukedemo.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinxin on 2016/3/8.
 *
 * 继承simplerecadapter，使之具有接口的功能
 */
public class SimpleRecStaggeredAdapter  extends SimpleRecAdapter  {

    private List<Integer> mHeight;

    public SimpleRecStaggeredAdapter(Context context, List<String> mdatas) {
        super(context, mdatas);

        mHeight = new ArrayList<Integer>();
        for (int i = 0; i <= datas.size(); i++) {
            mHeight.add((int) (100+Math.random()*300));
        }
    }


    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // 动态设定高度
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.itemView.setLayoutParams(lp);

        holder.tv.setText(datas.get(position));

        setUpItemEvent(holder);
    }

}
