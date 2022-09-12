package com.dxh.practice.design.responsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 责任链入口
 *
 * @author: dongxiaohua
 * @date: 2022-09-12 23:21:27
 */
@Component
public class CheckHandlerChain {
  @Autowired
  private List<AbstractCheckHandler> abstractCheckHandlerList;

  private AbstractCheckHandler abstractCheckHandler;

  @PostConstruct
  public void init() {
    for (int i = 0; i < abstractCheckHandlerList.size(); i++) {
      if (i == 0) {
        abstractCheckHandler = abstractCheckHandlerList.get(0);
      } else {
        AbstractCheckHandler currentHandler = abstractCheckHandlerList.get(i - 1);
        AbstractCheckHandler nextHandler = abstractCheckHandlerList.get(i);
        currentHandler.setNextHandler(nextHandler);
      }
    }
  }

  public boolean check(long id) {
    return abstractCheckHandler.check(id);
  }

  public AbstractCheckHandler getAbstractCheckHandler() {
    return abstractCheckHandler;
  }

  public void setAbstractCheckHandler(AbstractCheckHandler abstractCheckHandler) {
    this.abstractCheckHandler = abstractCheckHandler;
  }

}
