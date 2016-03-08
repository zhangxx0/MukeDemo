package com.xinxin.mukedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xinxin.mukedemo.aty.RecyclerViewAty;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        btn_recyclerview = (Button) findViewById(R.id.btn_recyclerview);
        btn_recyclerview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recyclerview:
                Intent i = new Intent(MainActivity.this, RecyclerViewAty.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
