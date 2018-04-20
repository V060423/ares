package com.study.cloud.provider.user;

import com.study.cloud.domain.User;
import com.study.cloud.repository.UserRepository;
import com.study.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author wangbowen
 * @Description 服务提供者
 * @Date 2018/4/18 11:08
 */
@RestController
public class UserProvider implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findById(@PathVariable Long id) {
        Optional<User> option = userRepository.findById(id);
        User user1 = option.get();
        return user1;
    }

    @Override
    public  List<User> find(){
       return userRepository.findAll();
    }

    @Override
    public void add(@RequestBody  User user) {

    }
}
