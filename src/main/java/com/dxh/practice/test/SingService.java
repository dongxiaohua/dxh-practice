package com.dxh.practice.test;


public class SingService {
  private static SingService singService;

  private SingService(){
  }

  public synchronized SingService getSingService(){
    if (singService == null) {
      return new SingService();
    }
    return singService;
  }

}
