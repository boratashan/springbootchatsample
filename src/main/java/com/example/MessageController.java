package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/gms")
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static ArrayList<Message> messages = new ArrayList<Message>();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getMessage(String message) {
        return new ResponseEntity<>(MessageService.getLastMessages(), HttpStatus.ACCEPTED);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void postMessage(@RequestParam String message) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String userName = auth.getName(); //get logged in username
       logger.info(String.format("Invoking gms service with parameters -> message : %s, user : %s", message, userName));
       Message m = new Message(message,userName);
       MessageService.postNewMessage(m);
        logger.info(String.format("Invoking gms service with parameters -> message : %s, user : %s [DONE]", message, userName));
    }



}
