package com.dxh.practice.test;


import java.util.HashMap;

public class CountService {
  public int count(int[] a, int num) {
    if (a == null) {
      return -1;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }
    for (Integer key : map.keySet()) {
      Integer val = map.get(key);
      if (val % 2 == 1) {
        count++;
      }
    }
    if (count == 0) {
      return -1;
    }
    return count;
  }
}
