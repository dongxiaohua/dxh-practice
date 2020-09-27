package com.dxh.practice.factory;

import java.util.List;

/**
 * 注册接口
 *
 * @author dongxiaohua
 */
public interface TaskValidator {
  /**
   * 单个任务是否有效
   *
   * @param nomonTask
   * @return
   */
  boolean validate(NomonTask nomonTask);

  /**
   * 返回已经失效的tasks
   *
   * @param tasks
   * @return
   */
  List<NomonTask> invalidateTasks(List<NomonTask> tasks);
}
