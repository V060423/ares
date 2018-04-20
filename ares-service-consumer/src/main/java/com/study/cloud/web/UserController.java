package com.study.cloud.web;

import com.study.cloud.domain.User;
import com.study.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/18 11:17
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User find(@PathVariable("id") Long  id){
        return userService.findById(id);
    }

    @GetMapping("/user/all")
    public List<User> findAll(){
        return  userService.find();
    }

    @PostMapping("/user/add")
    public void  add(@RequestBody User user){
        userService.add(user);
    }
}
