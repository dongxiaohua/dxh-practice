package com.dxh.practice.web;

/**
 * @author dongxiaohua
 *         Created on 2018/4/2.
 */
public class HelloWorldImpl2 implements HelloWorld {

  @Override
  public void printHelloWorld() {
    System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
  }

  @Override
  public void doPrint() {
    System.out.println("Enter HelloWorldImpl2.doPrint()");
    return;
  }

  @Override
  public void printlnDate() {
  }
}
