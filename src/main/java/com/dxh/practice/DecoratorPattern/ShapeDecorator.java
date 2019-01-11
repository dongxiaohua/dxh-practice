package com.dxh.practice.DecoratorPattern;

/**
 * @author dongxiaohua
 */
public abstract class ShapeDecorator implements Shape {
  protected Shape decoratedShape;

  public ShapeDecorator(Shape decoratedShape){
    this.decoratedShape = decoratedShape;
  }

  @Override
  public void draw(){
    decoratedShape.draw();
  }
}