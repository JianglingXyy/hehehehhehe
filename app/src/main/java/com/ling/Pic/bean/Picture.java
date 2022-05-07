package com.ling.Pic.bean;


import java.io.Serializable;
import java.sql.Timestamp;




public class Picture implements Serializable {
    private int pid;
    private  String location;
    private  int creator;
    private  int type;
    private String description;
    private Timestamp createDate;
    private int likes;
    private int collections;

    @Override
    public String toString() {
        return "Picture{" +
                "pid=" + pid +
                ", location='" + location + '\'' +
                ", creator=" + creator +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", likes=" + likes +
                ", collections=" + collections +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getCollections() {
        return collections;
    }

    public void setCollections(int collections) {
        this.collections = collections;
    }

    public Picture(int pid, String location, int creator, int type, String description, Timestamp createDate, int likes, int collections) {
        this.pid = pid;
        this.location = location;
        this.creator = creator;
        this.type = type;
        this.description = description;
        this.createDate = createDate;
        this.likes = likes;
        this.collections = collections;
    }
}
