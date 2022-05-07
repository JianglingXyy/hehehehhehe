package com.ling.Pic.bean;


import java.io.Serializable;


public class Subscribe implements Serializable {
 private int uid;
 private int uid_follow;

 public Subscribe(int uid, int uid_follow, int status) {
  this.uid = uid;
  this.uid_follow = uid_follow;
  this.status = status;
 }

 @Override
 public String toString() {
  return "Subscribe{" +
          "uid=" + uid +
          ", uid_follow=" + uid_follow +
          ", status=" + status +
          '}';
 }

 public int getUid() {
  return uid;
 }

 public void setUid(int uid) {
  this.uid = uid;
 }

 public int getUid_follow() {
  return uid_follow;
 }

 public void setUid_follow(int uid_follow) {
  this.uid_follow = uid_follow;
 }

 public int getStatus() {
  return status;
 }

 public void setStatus(int status) {
  this.status = status;
 }

 private int status;
}
