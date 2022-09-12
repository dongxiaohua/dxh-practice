package com.dxh.practice.design.responsibility;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author: dongxiaohua
 * @date: 2022-09-12 23:26:37
 */
@Component
@Order(1)
public class CheckOneHandler extends AbstractCheckHandler{
  @Override
  protected Boolean handler(long id) {
    return false;
  }
}
