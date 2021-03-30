package com.dxh.practice.service;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArrayService {
  /**
   * 获取数组中最大值和最小值
   * 取双元素法
   * 解析：
   * 1. 定义两个变量，max，min
   * 2. 每次取出两个相邻元素并比较
   * 3. 大的与max比，小的与min比
   *
   * @param arr
   * @return
   */
  public Map gainMaxAndMin(int[] arr) {
    int max = arr[0];
    int min = arr[0];

    int len = arr.length;

    for (int i = 1; i < len - 1; i = i + 2) {
      //当i是最后一个元素是时
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


  /**
   * 合并有序数组
   * <p>
   * 归并
   * 1. 首先创建一个结果数组 merge，长度为需要合并的两数组之和
   * 2. 定义 i，j，代表两数组的下标
   * 3. 定义m，代表mrege下标
   * 4. 创建循环，合并，比较arr1和arr2指定元素的大小，谁小，将谁落入结果数组，并将此数组下标+1，m必+1
   * 5. 判断是否有一个数组提前取完，取完，则将另一个数组的剩余元素落入结果数组即可
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] mergeArr(int[] arr1, int[] arr2) {
    int[] merge = new int[arr1.length + arr2.length];
    int i = 0;
    int j = 0;
    int m = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] <= arr2[j]) {
        merge[m] = arr1[i];
        i++;
      } else {
        merge[m] = arr2[j];
        j++;
      }
      m++;
    }

    if (i < arr1.length) {
      while (i < arr1.length) {
        merge[m] = arr1[i];
        i++;
        m++;
      }
    }

    if (j < arr2.length) {
      while (j < arr2.length) {
        merge[m] = arr2[j];
        j++;
        m++;
      }
    }

    return merge;
  }
}
