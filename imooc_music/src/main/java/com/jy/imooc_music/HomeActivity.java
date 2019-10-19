package com.jy.imooc_music;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.widget.TextView;

import com.jy.imooc_music.home.model.CHANNEL;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class HomeActivity extends FragmentActivity {

    private static final CHANNEL[] CHANNELS = new CHANNEL[]{
      CHANNEL.MY,CHANNEL.DISCORY,CHANNEL.FRIEND,CHANNEL.VIDEO
    };
    private TextView mToggleView;
    private TextView mSearchView;
    private DrawerLayout mDrawerLayout;
    private MagicIndicator mMagicIndicator;
    private ViewPager mViewPager;
    private HomePageAdapter mHomePageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initDate();
    }

    private void initDate() {

    }

    private void initView() {
        mToggleView = findViewById(R.id.mToggleView);
        mSearchView = findViewById(R.id.mSearchView);
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        mViewPager = findViewById(R.id.mViewPager);
        mHomePageAdapter = new HomePageAdapter(getSupportFragmentManager(), CHANNELS);
        mViewPager.setAdapter(mHomePageAdapter);
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        mMagicIndicator = findViewById(R.id.mMagicIndicator);

        mMagicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return CHANNELS == null? 0:CHANNELS.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(HomeActivity.this);
                simplePagerTitleView.setText(CHANNELS[index].getName());
                simplePagerTitleView.setTextSize(19);
                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD) );
                simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#333333"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
            @Override
            public float getTitleWeight(Context context, int index) {
                return 1.0f;
            }
        });
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMagicIndicator,mViewPager);
    }


}
