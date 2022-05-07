package com.ling.Pic.bean;

import java.io.Serializable;




//存储uid和ip
public class HeartBeat implements Serializable {
    private  int uid;
    private  String ip;

    @Override
    public String toString() {
        return "HeartBeat{" +
                "uid=" + uid +
                ", ip='" + ip + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public HeartBeat(int uid, String ip) {
        this.uid = uid;
        this.ip = ip;
    }
}
