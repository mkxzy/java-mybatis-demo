package com.iblotus.javamybatisdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iblotus.javamybatisdemo.domain.User;
import com.iblotus.javamybatisdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> selectUsers(){
        log.info("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    @GetMapping("/user/findbyname")
    public  List<User> findByName(){

        log.info("----- findByName method test ------");
        List<User> userList = userMapper.selectByName("Jack");
        return userList;
    }

    @GetMapping("/user/findbywrapper")
    public List<User> selectByMyWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "J%");
        List<User> users = userMapper.selectByMyWrapper(wrapper);
        return users;
    }

    @GetMapping("/user/findwithpage")
    public IPage<User> selectWithPage() {
        Page<User> page = new Page<>(3, 2);
        IPage<User> users = userMapper.selectPageVo(page);
        return users;
    }
}
