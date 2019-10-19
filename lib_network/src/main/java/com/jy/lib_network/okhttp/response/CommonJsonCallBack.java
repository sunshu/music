package com.jy.lib_network.okhttp.response;

import com.jy.lib_network.okhttp.listener.DisposeDataListener;

import java.util.logging.Handler;

public class CommonJsonCallBack {

    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHERS_ERROR = -3;

    private DisposeDataListener mListener;
    private Class<?> mCallBack;
    private Handler mPoster;

//    public CommonJsonCallBack(DisposeDataHandler handler ) {
//    }
}
