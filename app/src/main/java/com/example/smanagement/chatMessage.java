package com.example.smanagement;

import java.util.Date;

public class chatMessage
{
    //vairables
    private String messageText;
    private String messageUser;
    private long messageTime;

    public chatMessage(String messageText, String messageUser)
    {
        this.messageText = messageText;
        this.messageUser = messageUser;

        //setting time
        messageTime = new Date().getTime();
    }

    public chatMessage() {
        //empty constructor
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
