package com.dxh.practice.design.responsibility;

/**
 * 责任链
 *
 * @author: dongxiaohua
 * @date: 2022-09-12 23:14:46
 */
public abstract class AbstractCheckHandler implements ICheckHandler {

  private AbstractCheckHandler nextHandler;

  public void setNextHandler(AbstractCheckHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public AbstractCheckHandler getNextHandler() {
    return this.nextHandler;
  }


  @Override
  public Boolean check(long id) {
    Boolean b = handler(id);
    if (!b) {
      if (getNextHandler() != null) {
        b = getNextHandler().check(id);
      }
    }
    return b;
  }

  protected abstract Boolean handler(long id);


}
