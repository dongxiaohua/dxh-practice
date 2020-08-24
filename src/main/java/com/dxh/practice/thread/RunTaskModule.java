package com.dxh.practice.thread;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dongxiaohua
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunTaskModule {
  private String name;
  private Integer arg;
}
