package com.study.cloud.service;

import com.study.cloud.domain.User;
import com.study.cloud.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/18 10:59
 */
@FeignClient(name="provider-user-service",fallback =UserServiceFallback.class)
public interface UserService {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

    @GetMapping("/user/all")
    User find(@RequestParam Map<String,Object> params);

    @PostMapping("/user/add")
    void add(@RequestBody User user);
 }
