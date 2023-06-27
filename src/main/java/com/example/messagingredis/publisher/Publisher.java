package com.example.messagingredis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingredis.dto.Product;

@RestController
public class Publisher {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired 
    private ChannelTopic topic;

    @PostMapping("/publish")
    public String publish(Product product){
        redisTemplate.convertAndSend(topic.getTopic(), product);
        return "Published";
    }
}
