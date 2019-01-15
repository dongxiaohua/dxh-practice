package com.dxh.practice.service;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

@Service
public class StreamService {

  public void query(String tenantId, Consumer<Map<String,Object>> consumer){

    int i = 1000;
    while (i > 0) {
      Map<String,Object> map = Maps.newHashMap();
      consumer.accept((Map<String, Object>) map.put("i", i));
    }
  }

}
