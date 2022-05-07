package com.ling.Pic.bean;


import java.io.Serializable;
import java.sql.Timestamp;



public class CommentParent implements Serializable {
    private    int cid;
    protected   int uid;
    protected   int pid;
    protected Timestamp commentDate;
    protected   String content;

    public CommentParent(int cid, int uid, int pid, Timestamp commentDate, String content) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.commentDate = commentDate;
        this.content = content;
    }
    public CommentParent(){

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentParent{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", commentDate=" + commentDate +
                ", content='" + content + '\'' +
                '}';
    }
}
