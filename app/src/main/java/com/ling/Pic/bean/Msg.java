package com.ling.Pic.bean;

import java.io.Serializable;




public class Msg  implements Serializable {
    private int fromUid;
    private int toUid;
    private String msg;
    private String date;

    @Override
    public String toString() {
        return "Msg{" +
                "fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", msg='" + msg + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getFromUid() {
        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }

    public int getToUid() {
        return toUid;
    }

    public void setToUid(int toUid) {
        this.toUid = toUid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Msg(int fromUid, int toUid, String msg, String date) {
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.msg = msg;
        this.date = date;
    }
}
