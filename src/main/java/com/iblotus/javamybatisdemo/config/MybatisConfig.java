package com.iblotus.javamybatisdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@MapperScan("com.iblotus.javamybatisdemo.mapper")
@Configuration
public class MybatisConfig {
}
