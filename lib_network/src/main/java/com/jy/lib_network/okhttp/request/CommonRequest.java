package com.jy.lib_network.okhttp.request;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 提供 get/post/file 请求
 */
public class CommonRequest {

    /**
     * Post请求
     * @param url
     * @param params
     * @param heads
     * @return
     */
    public static Request createPostRequest(String url, RequestParams params, RequestParams heads){
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null){
            for(Map.Entry<String ,String> entry:params.urlParams.entrySet()){
                builder.add(entry.getKey(),entry.getValue());
            }
        }
        // 创建Header
        Headers.Builder headBuild = new Headers.Builder();
        if (heads != null){
            for(Map.Entry<String ,String> entry:heads.urlParams.entrySet()){
                headBuild.add(entry.getKey(),entry.getValue());
            }
        }
        Request postRequset = new Request.Builder()
                .url(url)
                .headers(headBuild.build())
                .post(builder.build())
                .build();
        return postRequset;
    }

    public static Request createPostRequest(String url, RequestParams params){
       return createPostRequest(url,params,null);
    }


    /**
     * Post请求
     * @param url
     * @param params
     * @param heads
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params, RequestParams heads){
        StringBuilder builder = new StringBuilder();
        if (params != null){
            builder.append(url);
            for(Map.Entry<String ,String> entry:params.urlParams.entrySet()){
                builder.append(entry.getKey()+"="+entry.getValue());
                builder.append("&");
            }
        }
        // 创建Header
        Headers.Builder headBuild = new Headers.Builder();
        if (heads != null){
            for(Map.Entry<String ,String> entry:heads.urlParams.entrySet()){
                headBuild.add(entry.getKey(),entry.getValue());
            }
        }
        Request postRequset = new Request.Builder()
                .url(url)
                .headers(headBuild.build())
                .get()
                .build();
        return postRequset;
    }

    public static Request createGetRequest(String url, RequestParams params){
        return createGetRequest(url, params,null);
    }

    /**
     * File 上传
     */
    public static final MediaType FILE_TYPE = MediaType.parse("application/octet-stream");
    public static Request createMultiPostRequest(String url,RequestParams params,RequestParams headers){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        if (params != null){
            for(Map.Entry<String ,Object> entry:params.fileParams.entrySet()){
                if (entry.getValue() instanceof File){
                    builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(FILE_TYPE, (File) entry.getValue()));
                     builder.addPart(Headers.of("Content-Disposition","form-data; name=\""+entry.getKey()+"\""),RequestBody.create(FILE_TYPE,(File)entry.getValue()));
                }else if (entry.getValue() instanceof String){
                    builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""),
                            RequestBody.create(null, (String) entry.getValue()));
                }
            }
        }
        // 创建Header
        Headers.Builder headBuild = new Headers.Builder();
        if (headers != null){
            for(Map.Entry<String ,String> entry:headers.urlParams.entrySet()){
                headBuild.add(entry.getKey(),entry.getValue());
            }
        }
        Request postRequset = new Request.Builder()
                .url(url)
                .headers(headBuild.build())
                .post(builder.build())
                .build();
        return postRequset;
    }
}
