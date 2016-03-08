package com.xinxin.mukedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinxin.mukedemo.R;

import java.util.List;

/**
 * Created by xinxin on 2016/3/8.
 */
public class SimpleRecAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<String> datas;
    private LayoutInflater layoutInflater;

    public SimpleRecAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    // 创建ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_simplerec_text, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }



}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv_simplerec);
    }
}
