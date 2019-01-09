package com.dxh.practice.web.aop;

/**
 * @author dongxiaohua
 *         Created on 2018/4/2.
 */
public class HelloWorldImpl1 implements HelloWorld {
  @Override
  public void printHelloWorld() {
    System.out.println("1");
    printlnDate();
  }

  @Override
  public void doPrint() {
    System.out.println("1");
    return;
  }

  @Override
  public void printlnDate() {
    System.out.println("2");
  }

}
