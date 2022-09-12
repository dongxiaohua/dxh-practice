package com.dxh.practice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: dongxiaohua
 * @date: 2022-09-12 23:26:53
 */
@Component
@Order(2)
public class CheckTowHandler extends AbstractCheckHandler {
  @Override
  protected Boolean handler(long id) {
    return false;
  }
}
