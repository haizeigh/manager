package com.group5.manager.model;

import lombok.Data;


/**
 * 统一响应结果
 *
 */
@Data
public class ManagerResult {

    private int code;
    private String message;
    private Object data;

    private ManagerResult() {
    }

    public ManagerResult(int ret, int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static final ManagerResult SUCCESS = new ManagerResult(0, 0, "success");
    public static final ManagerResult FAIL = new ManagerResult(-1, -1, "fail");

    public static ManagerResult create(Boolean success) {
        return (success != null && success) ? SUCCESS : FAIL;
    }

    public static ManagerResult success() {
        return SUCCESS;
    }

    public static ManagerResult success(Object data) {
        ManagerResult result = new ManagerResult();
        result.setCode(SUCCESS.getCode());
        result.setMessage(SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static ManagerResult fail(String message) {
        ManagerResult result = new ManagerResult();
        result.setCode(FAIL.getCode());
        result.setMessage(message);
        return result;
    }

    public static ManagerResult fail(int code, String message) {
        ManagerResult result = new ManagerResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


}
