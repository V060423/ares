package com.study.cloud.fallback;

import com.study.cloud.domain.User;
import com.study.cloud.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wangbowen
 * @Description TODO
 * @Date 2018/4/18 11:06
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> find() {
        return null;
    }

    @Override
    public void add(User user) {

    }
}
