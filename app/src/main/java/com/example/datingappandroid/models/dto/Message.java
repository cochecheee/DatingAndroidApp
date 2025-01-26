package com.example.datingappandroid.models.dto;
public class Message {
    private String message;
    private long time;
    private boolean seen;
    private String from;
    // default constructor
    public Message() {
    }

    // constructor
    public Message(String message, String type, long time, boolean seen, String from) {
        this.message = message;
        this.time = time;
        this.seen = seen;
        this.from = from;
    }

    // getter & setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
