package com.xinxin.mukedemo.aty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xinxin.mukedemo.R;
import com.xinxin.mukedemo.adapter.SimpleRecAdapter;
import com.xinxin.mukedemo.adapter.SimpleRecStaggeredAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinxin on 2016/3/8.
 * RecyclerViewStaggeredAty 瀑布流
 */
public class RecyclerViewStaggeredAty extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<String> mData;
    private SimpleRecStaggeredAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_staggered);

        initView();
        initData();

        simpleAdapter = new SimpleRecStaggeredAdapter(this, mData);
        recyclerview.setAdapter(simpleAdapter);

        // 设置RecyclerView的布局管理；
        // LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(sg);

        // 设置item间的分割线
        // recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        // 使用默认的背景色；margin

        simpleAdapter.setOnItemClickListener(new SimpleRecAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {
                // 长按时删除该项
                simpleAdapter.deleteData(position);
            }
        });

    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

    }

    private void initData() {
        mData = new ArrayList<>();

        for (int i = 'A'; i <= 'z'; i++) {
            mData.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclerview, menu);

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        }

        return super.onOptionsItemSelected(item);
    }
}
