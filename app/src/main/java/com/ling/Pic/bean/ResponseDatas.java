package com.ling.Pic.bean;

import java.io.Serializable;




public class ResponseDatas<T> implements Serializable {
    private T data;
    private int errorCode;
    private String errorMsg;

    public T getDatas() {
        return data;
    }

    public void setDatas(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
