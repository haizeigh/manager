package com.group5.manager.utils;

import com.google.gson.Gson;

/**
 * @author yl
 * @date 2020-06-19
 */
public class GsonUtil {

    public static String toJsonString(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }


    public static <T> T fromJsonString(String jsonString, Class<T> classOfT){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, classOfT);
    }

}
