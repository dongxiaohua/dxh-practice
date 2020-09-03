package com.dxh.practice.consumer;

import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Consumer<> 接口demo
 *
 * @author dongxiaohua
 */
public class ConsumerInterfaceService {
  public static void demoInfo(List<String> names, Consumer<String> consumer) {
    names.forEach(name -> {
      consumer.accept(name + "demo");
    });
  }

  public static void main(String[] args) {
    List<String> names = Lists.newArrayList("a1","a2","a3");
    demoInfo(names, v -> {
      System.out.println(v);
    });
  }
}
