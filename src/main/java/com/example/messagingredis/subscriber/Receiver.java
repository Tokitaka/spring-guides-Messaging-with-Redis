package com.example.messagingredis.subscriber;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Receiver implements MessageListener{
    
    @Override
    public void onMessage(Message message, byte[] bytes) {
       LOGGER.info("Received <" +message + ">");
        
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger counter = new AtomicInteger();
    
    public void receiveMessage(String message){
        LOGGER.info("Received <" +message + ">");
        counter.incrementAndGet();
    }

    public int getCount(){
        return counter.get();
    }


}
