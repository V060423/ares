package com.study.cloud.service;

import com.study.cloud.domain.User;
import com.study.cloud.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/18 10:59
 */
@FeignClient(name="user-provider",fallback =UserServiceFallback.class)
public interface UserService {
    @GetMapping("/user/me/{id}")
    User findById(@PathVariable("id") Long id);

    @GetMapping("/user/me/all")
    List<User> find();

    @PostMapping("/user/me/add")
    void add(@RequestBody User user);
 }
