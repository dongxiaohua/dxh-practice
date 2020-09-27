package com.dxh.practice.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实例
 *
 * @author dongxiaohua
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NomonTask {
  /**
   * 任务ID
   */
  private String id;
  /**
   * 模板ID
   */
  private String biz;
  /**
   * 租户Id
   */
  private String tenantId;
  /**
   * 数据ID
   */
  private String dataId;
  /**
   * 任务Id
   */
  private String taskId;
  /**
   * header
   */
  private String headerArg;
  /**
   * 请求参数
   */
  private String callArg;
  /**
   * 重试次数
   */
  private Integer retries;
  /**
   * 修改版本
   */
  private Integer taskVersion;
  /**
   * 循环任务定时器
   */
  private String cronExp;
  /**
   * cron模式
   * 第一次执行时间不能大于这个时间,相当于init-delay
   */
  private Long firstAfter;
  /**
   * cron模式
   * 最后一次执行时间不能大于当前时间
   */
  private Long lastBefore;
  /**
   * 计划执行时间(如果是多次循环任务，就是下次执行时间)
   */
  private Long executeTime;
  /**
   * 固定间隔时间（只有指定了executeTime才会有效， 并且cronExp是null的时候）
   */
  private Long intervalInSeconds;
  /**
   * 创建时间
   */
  private Long createTime;
  /**
   * 修改时间
   */
  private Long modifyTime;

  /**
   * MQ回调的时候取模的值
   */
  private Integer callQueueMod;
}
