package com.dxh.practice.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohua
 */
@Service
@Slf4j
public class DoTaskService {

  Integer doTask(RunTaskModule runTaskModule) {
    return runTaskModule.getArg();
  }
}
