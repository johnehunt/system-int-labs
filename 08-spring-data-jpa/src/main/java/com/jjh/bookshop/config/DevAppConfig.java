package com.jjh.bookshop.config;

@Configuration
@ComponentScan(basePackages = {
        "com.jjh.bookshop.dao",
        "com.jjh.bookshop.service",
        "com.jjh.bookshop.controller"})
@Import(JDBCDatabaseConfig.class)
public class DevAppConfig {}
