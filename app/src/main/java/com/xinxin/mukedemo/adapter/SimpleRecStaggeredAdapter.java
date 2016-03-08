package com.xinxin.mukedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinxin.mukedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinxin on 2016/3/8.
 */
public class SimpleRecStaggeredAdapter  extends RecyclerView.Adapter<SimpleRecStaggeredAdapter.MyViewHolder>  {

    private Context context;
    private List<String> datas;
    private LayoutInflater layoutInflater;

    private List<Integer> mHeight;

    public SimpleRecStaggeredAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);

        mHeight = new ArrayList<Integer>();
        for (int i = 0; i <= datas.size(); i++) {
            mHeight.add((int) (100+Math.random()*300));
        }
    }

    // 创建ViewHolder
    @Override
    public SimpleRecStaggeredAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_simplerec_text, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(SimpleRecStaggeredAdapter.MyViewHolder holder, int position) {

        // 动态设定高度
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeight.get(position);
        holder.itemView.setLayoutParams(lp);

        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_simplerec);
        }
    }

}
