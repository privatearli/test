package com.woniu.controller;

import com.woniu.domain.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserControllrt {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
     @GetMapping("set/{name}")
    public String  testSpringRedis(@PathVariable String name){
         ValueOperations valueOperations = redisTemplate.opsForValue();
         User user=new User();
         valueOperations.set("name",name,2);
         String o = (String)valueOperations.get(name);
         System.out.println(o);
         return "session";
    }
}
