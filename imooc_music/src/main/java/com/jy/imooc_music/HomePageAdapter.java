package com.jy.imooc_music;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jy.imooc_music.home.DiscoryFragment;
import com.jy.imooc_music.home.FriendFragment;
import com.jy.imooc_music.home.MineFragment;
import com.jy.imooc_music.home.VideoFragment;
import com.jy.imooc_music.home.model.CHANNEL;

public class HomePageAdapter extends FragmentPagerAdapter {
    private CHANNEL[] mList;

    public HomePageAdapter(FragmentManager fm, CHANNEL[] channels) {
        super(fm);
        mList = channels;
    }

    @Override
    public Fragment getItem(int i) {
        int type = mList[i].getId();
        switch (type){
            case CHANNEL.MINE_ID:
                return MineFragment.newInsatence();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInsatence();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInsatence();
            case CHANNEL.VIDEO_ID:
                return VideoFragment.newInsatence();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null?0:mList.length;
    }
}
