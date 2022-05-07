package com.ling.Pic.bean;


import java.io.Serializable;
import java.sql.Timestamp;



public class CommentChild extends CommentParent implements Serializable {



   public CommentChild(int cid, int uid, int pid, Timestamp commentDate, String content) {
      super(cid, uid, pid, commentDate, content);
   }

   public CommentChild() {
   }

   @Override
   public String toString() {
      return "CommentChild{" +
              "uid=" + uid +
              ", pid=" + pid +
              ", commentDate=" + commentDate +
              ", content='" + content + '\'' +
              '}';
   }
}
