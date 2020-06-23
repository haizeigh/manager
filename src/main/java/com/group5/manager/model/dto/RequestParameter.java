package com.group5.manager.model.dto;

import lombok.Data;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yl
 * @date 2020-06-19
 */
@Data
public  class RequestParameter {

    protected Map<String, String> pathMap = new HashMap<>();

    protected Map<String, String> headerMap = new HashMap<>();

    protected String body ;

    {
        headerMap.put("Authorization","5e46871f34a6e5748c2c4171a437ea54017741a2999a2cceb8a9fc05");
    }

    public String translateRequestUrl(String queryUrl){
        if (MapUtils.isNotEmpty(pathMap)){
            String realUrl = "";
            for (Map.Entry<String, String> pathItem : pathMap.entrySet()){
                realUrl = queryUrl.replace(pathItem.getKey(), pathItem.getValue());
            }
            return realUrl;
        }
        return queryUrl;
    }

    public void putHeader(String key, String value) {
        headerMap.put(key, value);
    }

    public void putPath(String key, String value) {
        pathMap.put(key, value);
    }
}
