package com.dxh.practice.service;

import com.dxh.practice.stramFifltsService.EmployPojo;
import com.google.common.collect.Sets;
import org.apache.commons.collections.map.HashedMap;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 日常
 *
 * @author dongxiaohua
 */
public class DailyService {
  public static void main(String[] args) {

    Long l = 123L;
    Map<String,Object> maps = Maps.newHashMap();
    maps.put("l",l);
    Object l1 = maps.get("l");

    String[] value = new String[10];

    Map<String, List<String>> map = new HashedMap() {
      {
        put("1", Lists.newArrayList("1", "2"));
        put("2", Lists.newArrayList("3", "4"));
        put("3", Lists.newArrayList("5", "6"));
      }
    };

    map.keySet();
    map.values();

    Set<String> s = Sets.newHashSet();
    map.values().stream().forEach(it -> s.addAll(it));
    System.out.println(s);


    List<EmployPojo> list = Lists.newArrayList(EmployPojo.builder().name("a").build(), EmployPojo.builder().name("b").build(), EmployPojo
      .builder()
      .name("c")
      .build(), EmployPojo.builder().name("A").build());
    List<String> list1 = list.stream().map(it -> it.getName()).map(String::toLowerCase).collect(Collectors.toList());
    long count = list1.stream().distinct().count();
    System.out.println(count);
    System.out.println(list);


    List<String> a1 = Lists.newArrayList("a","b","c");
    List<String> a2 = Lists.newArrayList("a","d");
    if (a1.contains(a2)) {
      System.out.println(true);
    }

  }
}