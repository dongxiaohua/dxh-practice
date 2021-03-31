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
   * 第一轮，从第一个元素开始，与每个元素对比，符合条件的则替换位置(提前定义min存储下标和内容)，最终让最小的放在第一位
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
    int min_value;
    int min_index;
    int n = a.length;
    for (int i = 0; i < n; i++) {
      min_value = a[i];
      min_index = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < min_value) {
          min_value = a[j];
          min_index = j;

          if (min_index != i) {
            a[min_index] = a[i];
            a[i] = min_value;
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
    i = l;
    j = r;
    if (l < r) {
      //确定中心轴
      int pivot = array[i];
      while (i < j) {
        // r位置大于等于pivot值，则指针向左移动，找到比pivot小的位置
        while (i < j && array[j] >= pivot) {
          j--;
        }
        //当前j位置值小于pivot
        if (i < j) {
          // 将当前j位置的值放到i位置，并且移动左侧i指针
          array[i] = array[j];
          i++;
        }
        // l位置值小于等于pivot值则移动指针（找到大于pivot值的位置）
        while (i < j && array[i] <= pivot) {
          i++;
        }
        if (i < j) {
          //将当前i的值放到j的位置,并且移动右侧j指针
          array[j] = array[i];
          j--;
        }
      }
      //当i=j重合，则停止 把pivot放到正确的位置
      array[i] = pivot;
      //重复左侧列
      quickSort(array, l, i - 1);
      //重复右侧列
      quickSort(array, i + 1, r);
    }
  }
}
