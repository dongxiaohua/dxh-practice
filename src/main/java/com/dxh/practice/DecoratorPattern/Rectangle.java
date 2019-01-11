package com.dxh.practice.DecoratorPattern;

/**
 * @author dongxiaohua
 */
public class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Shape: Rectangle");
  }
}
