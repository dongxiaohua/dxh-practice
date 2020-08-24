package com.dxh.practice.thread;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
