package com.ling.Pic.bean;

import java.io.Serializable;






public class LikePicture  implements Serializable {
    private int uid;
    private int pid;
    private int status;

    @Override
    public String toString() {
        return "LikePicture{" +
                "uid=" + uid +
                ", pid=" + pid +
                ", status=" + status +
                '}';
    }

    public LikePicture(int uid, int pid, int status) {
        this.uid = uid;
        this.pid = pid;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
