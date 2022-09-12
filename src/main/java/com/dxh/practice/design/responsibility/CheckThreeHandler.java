package com.dxh.practice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: dongxiaohua
 * @date: 2022-09-12 23:27:05
 */
@Component
@Order(3)
public class CheckThreeHandler extends AbstractCheckHandler {
  @Override
  protected Boolean handler(long id) {
    return null;
  }
}
