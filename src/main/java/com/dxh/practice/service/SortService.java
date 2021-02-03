package com.dxh.practice.service;

import org.springframework.stereotype.Service;

/**
 * 数组或排序相关算法
 *
 * @author dongxiaohua
 */
@Service
public class SortService {


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
   * 1. [25,36,12,25,48,43,57,65]
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
   * 冒泡排序2
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


  /**
   * 归并排序
   *
   * @param array
   * @param p
   * @param r
   */
  public void mergeSort(int[] array, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(array, p, q);
      mergeSort(array, q + 1, r);
      merge(array, p, q, r);
    }
  }

  /**
   * 归并排序实现
   *
   * @param array
   * @param p
   * @param q
   * @param r
   */
  private static void merge(int[] array, int p, int q, int r) {
    int i, j, k, n1, n2;
    n1 = q - p + 1;
    n2 = r - q;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (i = 0, k = p; i < n1; i++, k++) {
      L[i] = array[k];
    }
    for (i = 0, k = q + 1; i < n2; i++, k++) {
      R[i] = array[k];
    }

    for (k = p, i = 0, j = 0; i < n1 && j < n2; k++) {
      if (L[i] > R[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
      }
    }
    if (i < n1) {
      for (j = i; j < n1; j++, k++) {
        array[k] = L[j];
      }
    }
    if (j < n2) {
      for (i = j; i < n2; i++, k++) {
        array[k] = R[i];
      }
    }
  }


  /**
   * 快速排序
   * 1. 选定pivot中心轴
   * 2. 将大于pivot的数字放在pivot的右边
   * 3. 将小于pivot的数字放在pivot的左边
   * 4. 分别对左右子序列重复前三步
   * <p>
   * 注：选定pivot后，同时确定了L，R（0，length-1）
   * 让R，L位置的元素分别跟pivot元素比较，直到R，L位置重合
   *
   * @param array
   */
  public void quickSort(int[] array, int l, int r) {
    int i, j;
    int index;
    if (l >= r) {
      return;
    }
    i = l;
    j = r;
    index = array[i];
    while (i < j) {
      while (i < j && array[i] >= index) {
        j--;
      }
      if (i < j) {
        array[i++] = array[j];
      }
      while (i < j && array[i] < index) {
        i++;
      }
      if (i < j) {
        array[j--] = array[i];
      }
    }
    array[i] = index;
    quickSort(array, l, i - 1);
    quickSort(array, i + 1, r);

  }
}
