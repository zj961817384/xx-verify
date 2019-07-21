package com.xx.model;

import com.alibaba.fastjson.JSON;

public class ResultModel {

    private int code;

    private String data;

    private String message;

    public static ResultModel SUCCESS(Object object) {
        ResultModel resultModel = new ResultModel();

        resultModel.setCode(200);
        resultModel.setMessage("SUCCESS");
        resultModel.setData(JSON.toJSONString(object));

        return resultModel;
    }

    public static ResultModel ERROR(String message) {
        ResultModel resultModel = new ResultModel();

        resultModel.setCode(500);
        resultModel.setMessage("FAIL: " + message);
        resultModel.setData(null);

        return resultModel;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
