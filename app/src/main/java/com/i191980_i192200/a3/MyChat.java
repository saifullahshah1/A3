package com.i191980_i192200.a3;

public class MyChat {
    String msg;
    Integer senderID,recieverID;

    public MyChat(String msg, Integer senderID, Integer recieverID) {
        this.msg = msg;
        this.senderID = senderID;
        this.recieverID = recieverID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getSenderID() {
        return senderID;
    }

    public void setSenderID(Integer senderID) {
        this.senderID = senderID;
    }

    public Integer getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(Integer recieverID) {
        this.recieverID = recieverID;
    }
}
