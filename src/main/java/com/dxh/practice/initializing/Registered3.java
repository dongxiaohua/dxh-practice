package com.dxh.practice.initializing;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Registered3 implements IExecute, InitializingBean {

  @Resource
  IFactoryService iFactoryService;

  @Override
  public void afterPropertiesSet() throws Exception {
    iFactoryService.registered("registered3", this);
  }

  @Override
  public void execute(String id) {
    System.out.println("registered3");
  }
}
