package com.group5.manager.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author yl
 * @date 2020-06-19
 */
@Slf4j
public class HttpUtil {



    private final static OkHttpClient client = new OkHttpClient.Builder()
            .connectionPool( new ConnectionPool(20, 5, TimeUnit.MINUTES))
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build();

    static MediaType JSON_MediaType = MediaType.parse("application/json; charset=utf-8");

    public static String doGet(String url, Map<String, String> header){

        log.info("get请求地址{},请求头{}", url, new Gson().toJson(header));
        Request request = new Request.Builder()
                .get()
                .url(url)
                .headers(Headers.of(header))
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            byte[] bytes = response.body().bytes();

            String result = new String(bytes, Charset.forName("utf8") );
            log.info("get请求地址{}, 结果是{}", url,  result);
            response.close();
            judgeResponse(response);
            return result;
        } catch (IOException e) {
            log.error("get请求地址{}, 出现异常", url,  e);
            throw new RuntimeException(e);
        }

    }


    public static String doPost(String url, Map<String, String> header, String jsonContent){

        log.info("post请求地址{},请求头{}, 请求内容{}", url, GsonUtil.toJsonString(header), jsonContent);
        Request request = new Request.Builder()
                .post(RequestBody.create(JSON_MediaType, jsonContent))
                .url(url)
                .headers(Headers.of(header))
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();

            byte[] bytes = response.body().bytes();
            String result = new String(bytes, Charset.forName("utf8") );
            log.info("post请求地址{}, 结果是{}", url,  result);
            response.close();
            judgeResponse(response);
            return result;
        } catch (Exception e) {
            log.error("post请求地址{}, 出现异常", url,  e);
            throw new RuntimeException(e);
        }

    }

    private static void judgeResponse(Response response){

        if (200 != response.code()){
            log.error("响应码={}异常", response.code());
            throw new RuntimeException("响应码异常");
        }

    }

}
