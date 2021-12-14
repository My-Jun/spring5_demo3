package com.junjay.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 作为配置类，替代xml配置文件。
@Configuration
// 扫描那些包下的注解
// 等同于xml配置文件中：<context:component-scan base-package="com.junjay.spring5"></context:component-scan>
// 配置文件中名称为 context：上下文，component-scan：扫描包，base-package：扫描包路径
// 对应关系：context——@Configuration component-scan——@ComponentScan；base-package——basePackages =‘数组’
// @Configuration表明了该类是配置类，@ComponentScan 扫描包 basePackages={"com.junjay.spring5"} 扫描那些路径下注解
// 大白话：被@Configuration修饰的类是配置类，开启扫描包，扫描com.junjay.spring5下的注解
@ComponentScan(basePackages = { "com.junjay.spring5", "" })
public class SpringConfig {

}
