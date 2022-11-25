package com.i191980_i192200.a3;

public class MyChat {
    String msg,senderID,receiverID;

    public MyChat(String msg, String senderID, String receiverID) {
        this.msg = msg;
        this.senderID = senderID;
        this.receiverID = receiverID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }
}
