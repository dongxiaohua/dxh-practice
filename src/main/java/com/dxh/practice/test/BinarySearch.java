package com.dxh.practice.test;

/**
 * 数据去重操作一时没整出来...
 */
public class BinarySearch {
  public int search(int[] array, int k) {
    int l = 0;
    int r = array.length - 1;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (array[mid] == k) {
        return mid;
      } else if (array[mid] > k) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  public int search2(int[] nums, int target) {
    return search2(nums, 0, nums.length - 1, target);
  }

  private int search2(int[] nums, int l, int r, int target) {
    //先判断递归终止条件
    if (l > r) {
      return -1;
    }

    int mid = l + (r - l) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] < target) {
      return search2(nums, mid + 1, r, target);
    }
    return search2(nums, 0, mid - 1, target);
  }

}
