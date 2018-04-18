package com.study.cloud.web;

import com.study.cloud.domain.User;
import com.study.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/18 11:17
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/me/{id}")
    public User find(@PathVariable("id") Long  id){
        return userService.findById(id);
    }
}
