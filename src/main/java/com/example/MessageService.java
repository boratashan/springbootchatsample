package com.example;

import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bora on 26/12/16.
 */
public class MessageService
{
    private static List<Message> messageList = new ArrayList<Message>();

    public static void postNewMessage(Message message){
        messageList.add(message);
    }

    public static List<Message> getLastMessages() {
        return messageList;
    }
}
