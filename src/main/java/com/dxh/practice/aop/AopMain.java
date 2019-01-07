package com.dxh.practice.aop;

import com.dxh.practice.web.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dongxiaohua
 *         Created on 2018/4/2.
 */
public class AopMain {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop.xml");

    HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
    hw1.printHelloWorld();

  }
}