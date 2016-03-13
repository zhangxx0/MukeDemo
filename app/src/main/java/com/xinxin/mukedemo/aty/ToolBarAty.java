package com.xinxin.mukedemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.xinxin.mukedemo.R;

/**
 * Toolbar
 * Created by xinxin on 2016/3/13.
 */
public class ToolBarAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Button btn_toolbar = (Button) findViewById(R.id.btn_toolbar);
        btn_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ToolBarAty.this, ToolBarDemoAty.class);
                startActivity(i);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);

        // 在代码或者布局文件中修改内容
        // App Logo
        // toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        // toolbar.setTitle("App Title");
        // Sub Title
        // toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);
        //Navigation Icon
        // toolbar.setNavigationIcon(R.drawable.ic_toc_white_24dp);

    }
}
