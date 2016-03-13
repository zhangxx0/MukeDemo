package com.xinxin.mukedemo.aty;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xinxin.mukedemo.R;
import com.xinxin.mukedemo.adapter.FragmentAdapter;
import com.xinxin.mukedemo.fragment.AgendaFragment;
import com.xinxin.mukedemo.fragment.InfoDetailsFragment;
import com.xinxin.mukedemo.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinxin on 2016/3/13.
 * CoordinatorLayout
 */
public class CoordinatorLayoutAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Demo");
        setSupportActionBar(toolbar);


        //初始化TabLayout的title数据集
        List<String> titles = new ArrayList<>();
        titles.add("details");
        titles.add("share");
        titles.add("agenda");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        //初始化ViewPager的数据集
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new InfoDetailsFragment());
        fragments.add(new ShareFragment());
        fragments.add(new AgendaFragment());

        ViewPager mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        //创建ViewPager的adapter
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(adapter);
        //千万别忘了，关联TabLayout与ViewPager
        //同时也要覆写PagerAdapter的getPageTitle方法，否则Tab没有title
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);



        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //
                Snackbar.make(view, "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件

                            }
                        })
                        .show();
            }
        });
    }
}
