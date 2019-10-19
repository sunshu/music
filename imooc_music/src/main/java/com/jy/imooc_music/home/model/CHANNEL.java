package com.jy.imooc_music.home.model;

public enum CHANNEL {

    MY("我的",0x01),
    DISCORY("发现",0x02),
    FRIEND("朋友",0x03),
    VIDEO("视频",0x04);


    public static final int MINE_ID = 0x01;
    public static final int DISCORY_ID = 0x02;
    public static final int FRIEND_ID = 0x03;
    public static final int VIDEO_ID = 0x04 ;

    private String name = "";
    private int id = 0;

    CHANNEL(String name, int value) {
        this.id = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
