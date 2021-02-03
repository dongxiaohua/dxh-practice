package com.dxh.practice.service;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArrayService {
  /**
   * 获取数组中最大值和最小值
   * 取双元素法
   *
   * @param arr
   * @return
   */
  public Map gainMaxAndMin(int[] arr) {
    int max = arr[0];
    int min = arr[0];

    int len = arr.length;

    for (int i = 1; i < len - 1; i = i + 2) {
      if (i + 1 > len) {
        if (arr[i] > max) {
          max = arr[i];
        }
        if (arr[i] < min) {
          min = arr[i];
        }
      }

      if (arr[i] > arr[i + 1]) {
        if (arr[i] > max) {
          max = arr[i];
        }
        if (arr[i + 1] < min) {
          min = arr[i + 1];
        }
      }
      if (arr[i] < arr[i + 1]) {
        if (arr[i + 1] > max) {
          max = arr[i + 1];
        }
        if (arr[i] < min) {
          min = arr[i];
        }
      }
    }

    int finalMax = max;
    int finalMin = min;
    return new HashedMap() {
      {
        put("max", finalMax);
        put("min", finalMin);
      }
    };
  }
}
