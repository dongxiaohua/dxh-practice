package com.dxh.practice.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

  @Resource
  private StreamService streamService;

  public void test() {
    streamService.query("1", data -> System.out.println(data.get("i")));
  }

}
