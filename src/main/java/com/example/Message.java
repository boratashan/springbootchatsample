package com.example;

public class Message {
    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    private final String message;
    private final String userName;


    public Message(String message, String userName) {
        this.message = message;
        this.userName = userName;
    }


}
