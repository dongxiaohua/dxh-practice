package com.dxh.practice.service;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 根据给定字符串获取最长回文串
 *
 * @author dongxiaohua
 */
@Service
@Slf4j
public class AlgorithmService {
  /**
   * 最长回文串
   * <p>
   * 根据给定字符串获取最长回文串长度
   * 难度：简单
   * <p>
   * 如果是偶数的话，全部加进去
   * 如果是奇数的话，减一加进去
   * 如果没有加完，说明有奇数的存在，可以将奇数放在中间位置
   *
   * @param s
   */
  public Integer palindrome(String s) {
    int n = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int res = 0;
    for (Character key : map.keySet()) {
      Integer val = map.get(key);
      //      if ((val & 1) == 1) {
      if ((val % 2) == 1) {
        res += val - 1;
      } else {
        res += val;
      }
    }
    if (res < n) {
      return res + 1;
    } else {
      return res;
    }
  }

  /**
   * 两数之和
   * <p>
   * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
   * 难度：简单
   * <p>
   * 反向思维
   *
   * @return
   */
  public int[] sum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      //如果map中存在此差值，则返回
      if (map.containsKey(value)) {
        res[1] = map.get(value);
        res[0] = i;
        break;
      }
      map.put(nums[i], i);
    }
    return res;
  }


  /**
   * 无重复字符串的最长子串
   * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
   *
   * @param s
   * @return
   */
  public int solution(String s) {
    int flag = 0;
    int length = 0;
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      int pos = s.indexOf(s.charAt(i), flag);
      if (pos < i) {
        if (length > result) {
          result = length;
        }
        if (result >= s.length() - pos - 1) {
          return result;
        }
        length = i - pos - 1;
        flag = pos + 1;
      }
      length++;
    }
    return length;
  }

}
