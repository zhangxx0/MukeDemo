package com.xinxin.mukedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.xinxin.mukedemo.R;
import com.xinxin.mukedemo.adapter.SimpleRecAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinxin on 2016/3/8.
 * RecyclerView
 *
 * http://www.imooc.com/learn/424
 */
public class RecyclerViewAty extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<String> mData;
    private SimpleRecAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Log.d("++++", "初始化2");

        initView();
        initData();

        simpleAdapter = new SimpleRecAdapter(this, mData);
        recyclerview.setAdapter(simpleAdapter);

        // 设置RecyclerView的布局管理；
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(lm);

        // 设置item间的分割线
        // recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        // 使用默认的背景色；margin

        // 默认的动画效果 https://github.com/gabrielemariotti/RecyclerViewItemAnimators
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        simpleAdapter.setOnItemClickListener(new SimpleRecAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewAty.this,"click:"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewAty.this,"longclick:"+position,Toast.LENGTH_SHORT).show();
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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                simpleAdapter.addData(1);
                break;
            case R.id.action_delete:
                simpleAdapter.deleteData(1);
                break;

            case R.id.action_listview:
                recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
            case R.id.action_gridview:
                recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_hor_gridview:
                // 这个的显示效果和教程的不一致，没有找到相应的原因？？？
                recyclerview.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered_gridview:
                Intent intent = new Intent(this, RecyclerViewStaggeredAty.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
