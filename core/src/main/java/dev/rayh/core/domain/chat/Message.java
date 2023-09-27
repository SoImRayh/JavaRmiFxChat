package dev.rayh.core.domain.chat;


import java.io.Serializable;


public class Message implements Serializable {
    private String user;
    private String text;

    public Message(){
        this.user = null;
        this.text = null;
    }

    public Message(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
