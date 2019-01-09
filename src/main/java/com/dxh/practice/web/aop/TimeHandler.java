package com.dxh.practice.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author dongxiaohua
 *         Created on 2018/4/2.
 */
public class TimeHandler {

  public void printTime(ProceedingJoinPoint joinpoint) {
    System.out.println("4");
    try {
      joinpoint.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    System.out.println("6");
  }

}
