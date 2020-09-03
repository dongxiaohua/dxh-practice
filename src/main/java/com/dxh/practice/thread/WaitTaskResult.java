package com.dxh.practice.thread;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Supplier;

/**
 * @author dongxiaohua
 */
public class WaitTaskResult implements Supplier<Integer> {

  private DoTaskService doTaskService = new DoTaskService();

  @Setter
  @Getter
  private RunTaskModule runTaskModule;

  public WaitTaskResult(RunTaskModule module) {
    this.runTaskModule = module;
  }

  @Override
  public Integer get() {
    return doTaskService.doTask(runTaskModule);
  }
}
