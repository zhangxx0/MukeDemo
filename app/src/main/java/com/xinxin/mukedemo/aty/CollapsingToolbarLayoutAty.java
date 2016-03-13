package com.xinxin.mukedemo.aty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.xinxin.mukedemo.R;

/**
 * Created by xinxin on 2016/3/13.
 * CollapsingToolbarLayout
 */
public class CollapsingToolbarLayoutAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbarlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.c_toolbar);
        toolbar.setTitle("标题");
        setSupportActionBar(toolbar);



    }
}
