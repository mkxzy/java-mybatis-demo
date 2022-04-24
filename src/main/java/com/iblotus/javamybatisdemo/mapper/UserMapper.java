package com.iblotus.javamybatisdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.iblotus.javamybatisdemo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * 如果自定义的方法还希望能够使用MP提供的Wrapper条件构造器，则需要如下写法
     *
     * @param userWrapper
     * @return
     */
    List<User> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<User> userWrapper);

    /**
     * 和Mybatis使用方法一致
     * @param name
     * @return
     */
    List<User> selectByName(@Param("name") String name);
}
