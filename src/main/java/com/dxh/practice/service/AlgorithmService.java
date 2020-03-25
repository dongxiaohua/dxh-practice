package com.dxh.practice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据给定字符串获取最长回文串
 *
 * @author dongxiaohua
 */
@Service
@Slf4j
public class AlgorithmService {
  /**
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
   * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
   *
   * @param s
   * @return
   */
  public int solution(String s) {
    if ("".equals(s.trim())) {
      return 1;
    }
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        map.put(s.substring(i, j), (j - i));
      }
    }
    if (map.size() == 0) {
      return 0;
    }
    HashMap<String, Integer> map2 = new HashMap<>();
    map2.put("l", 0);
    map.forEach((k, v) -> {
      boolean b = false;
      char[] chars = k.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        for (int j = i + 1; j < chars.length; j++) {
          if (chars[i] == chars[j]) {
            b = true;
          }
        }
      }
      if (!b && map2.get("l") < k.length()) {
        map2.put("l", k.length());
      }
    });
    return map2.get("l");
  }

}
