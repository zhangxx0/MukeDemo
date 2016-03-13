package com.xinxin.mukedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xinxin.mukedemo.aty.CollapsingToolbarLayoutAty;
import com.xinxin.mukedemo.aty.CoordinatorLayoutAty;
import com.xinxin.mukedemo.aty.NavigationViewAty;
import com.xinxin.mukedemo.aty.RecyclerViewAty;
import com.xinxin.mukedemo.aty.ToolBarAty;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_recyclerview, btn_toolbar, btn_NavigationView, btn_CoordinatorLayout, btn_CollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        btn_recyclerview = (Button) findViewById(R.id.btn_recyclerview);
        btn_toolbar = (Button) findViewById(R.id.btn_toolbar);
        btn_NavigationView = (Button) findViewById(R.id.btn_NavigationView);
        btn_CoordinatorLayout = (Button) findViewById(R.id.btn_CoordinatorLayout);
        btn_CollapsingToolbarLayout = (Button) findViewById(R.id.btn_CollapsingToolbarLayout);
        btn_recyclerview.setOnClickListener(this);
        btn_NavigationView.setOnClickListener(this);
        btn_toolbar.setOnClickListener(this);
        btn_CoordinatorLayout.setOnClickListener(this);
        btn_CollapsingToolbarLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recyclerview:
                Intent i = new Intent(MainActivity.this, RecyclerViewAty.class);
                startActivity(i);
                break;
            case R.id.btn_toolbar:
                Intent i1 = new Intent(MainActivity.this, ToolBarAty.class);
                startActivity(i1);
                break;
            case R.id.btn_NavigationView:
                Intent i2 = new Intent(MainActivity.this, NavigationViewAty.class);
                startActivity(i2);
                break;
            case R.id.btn_CoordinatorLayout:
                Intent i3 = new Intent(MainActivity.this, CoordinatorLayoutAty.class);
                startActivity(i3);
                break;
            case R.id.btn_CollapsingToolbarLayout:
                Intent i4 = new Intent(MainActivity.this, CollapsingToolbarLayoutAty.class);
                startActivity(i4);
                break;
            default:
                break;
        }
    }
}
