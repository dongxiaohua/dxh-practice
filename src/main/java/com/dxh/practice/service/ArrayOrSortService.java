package com.dxh.practice.service;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 数组或排序相关算法
 *
 * @author dongxiaohua
 */
@Service
public class ArrayOrSortService {


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


  /**
   * 选择排序
   * 第一轮，从第一个元素开始，与每个元素对比，符合条件的则替换位置，最终让最小的放在第一位
   * 第二轮，排除第一轮的最小值，重复第一轮操作
   * 直到最后一个元素
   * <p>
   * 例：{38,65,97,76,13,27,49}
   * 1. 13 [65,97,76,38,27,49]
   * 2. 13 27 [97,76,38,65,49]
   * 3. 13 27 38 [76,97,65,49]
   * ...
   *
   * @param a
   * @return
   */
  public void selectSort(int[] a) {
    int temp = 0;
    int flag = 0;
    int n = a.length;
    for (int i = 0; i < n; i++) {
      temp = a[i];
      flag = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < temp) {
          temp = a[j];
          flag = j;

          if (flag != i) {
            a[flag] = a[i];
            a[i] = temp;
          }
        }
      }
    }
  }


  /**
   * 插入排序
   * 将第一个元素看成有序序列，其余看作无序序列，
   * 每个元素都与有序序列比较，然后插入有序序列
   * 例：{38,65,97,76,13,27,49}
   * 1. [38] 65,97,76,13,27,49
   * 2. [38,65] 97,76,13,27,49
   * 3. [38,65,97] 76,13,27,49
   * 4. [38,65,76,97] 13,27,49
   * 5. [13,38,65,76,97] 27,49
   * ...
   *
   * @param a
   * @return
   */
  public void insertSort(int[] a) {
    if (a != null) {
      for (int i = 1; i < a.length; i++) {
        int temp = a[i];
        int j = i;
        if (a[j - 1] > temp) {
          while (j >= 1 && a[j - 1] > temp) {
            a[j] = a[j - 1];
            j--;
            a[j] = temp;
          }
        }
      }
    }
  }


  /**
   * 冒泡排序
   * <p>
   * 从第一个记录开始，依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时交换位置
   * 例：[36,25,48,12,25,65,43,57]
   * <p>
   * 1. [25,36,48,12,25,65,43,57]
   * 2. [25,12,25,36,43,48] 57,65
   * 3. [12,25,36,43] 48,57,65
   * 4. [12,25,25,36] 43,48,57,65
   * 5. [12,25,25] 36,43,48,57,65
   * ...
   *
   * @param array
   */
  public void bubbleSort(int[] array) {
    int len = array.length;
    int tmp;
    for (int i = 0; i < len - 1; i++) {
      for (int j = len - 1; j > i; j--) {
        if (array[j] < array[j - 1]) {
          tmp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = tmp;
        }
      }
    }
  }

  /**
   * 冒泡2
   *
   * @param array
   */
  public void bubbleSort2(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

}
