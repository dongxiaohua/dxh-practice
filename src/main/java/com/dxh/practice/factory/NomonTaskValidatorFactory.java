package com.dxh.practice.factory;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dongxiaohua
 */
@Component
public class NomonTaskValidatorFactory {
  private static final Map<String, TaskValidator> map = Maps.newConcurrentMap();

  TaskValidator get(String biz) {
    return map.get(biz);
  }

  void register(String biz, TaskValidator validator) {
    map.put(biz, validator);
  }

  void unregister(String biz) {
    map.remove(biz);
  }
}
