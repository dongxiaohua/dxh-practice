package com.dxh.practice.design.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 简单工厂模式
 * <p>
 * 以制作，订购披萨为例
 *
 * @author dongxiaohua
 */
public class SimpleFactoryService {

  /**
   * 你给我一个订购类型，我给你返回一个pizza
   *
   * @param orderType
   * @return
   */
  public Pizza createPizza(String orderType) {
    Pizza pizza = null;
    System.out.println("使用简单工厂模式");
    if ("greek".equals(orderType)) {
      pizza = new GreekPizza();
      pizza.setName("希腊披萨");
    } else if ("cheese".equals(orderType)) {
      pizza = new CheesePizza();
      pizza.setName("奶酪披萨");
    }
    return pizza;
  }
}


/**
 * 相当于一个客户端，发起订购任务
 */
class PizzaStore {
  public static void main(String[] args) {
    //    new OrderPizza();
    //使用简单工厂模式
    new OrderPizza(new SimpleFactoryService());
    System.out.println(">>> 退出程序 <<<");
  }
}


/**
 * 订购
 */
class OrderPizza {
  //构造器
  //  public OrderPizza() {
  //    Pizza pizza = null;
  //    //订购的类型
  //    String orderType;
  //    do {
  //      orderType = getType();
  //      if ("greek".equals(orderType)) {
  //        pizza = new GreekPizza();
  //        pizza.setName("希腊披萨");
  //      } else if ("cheese".equals(orderType)) {
  //        pizza = new CheesePizza();
  //        pizza.setName("奶酪披萨");
  //      } else {
  //        break;
  //      }
  //      //输出pizza制作过程
  //      pizza.prepare();
  //      pizza.bake();
  //      pizza.cut();
  //      pizza.box();
  //    } while (true);
  //  }

  //定义一个简单工厂对象
  SimpleFactoryService simpleFactoryService;
  Pizza pizza = null;

  // 构造器
  public OrderPizza(SimpleFactoryService simpleFactoryService) {
    setFactory(simpleFactoryService);
  }

  public void setFactory(SimpleFactoryService simpleFactoryService) {
    //用户输入类型
    String orderType = "";
    //设置简单工厂对象
    this.simpleFactoryService = simpleFactoryService;
    do {
      orderType = getType();
      pizza = simpleFactoryService.createPizza(orderType);
      //输出pizza制作过程
      if (pizza != null) {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
      } else {
        System.out.println("订购失败");
        break;
      }
    } while (true);
  }

  private String getType() {
    try {
      BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("input pizza type:");
      String str = strIn.readLine();
      return str;
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

}


/**
 * 披萨类
 */
abstract class Pizza {
  String name;

  /**
   * 准备原材料，不同披萨不一样，所以设置为抽象方法
   */
  public abstract void prepare();

  public void bake() {
    System.out.println(name + " baking...");
  }

  public void cut() {
    System.out.println(name + " cutting...");
  }

  public void box() {
    System.out.println(name + " boxing...");
  }

  public void setName(String name) {
    this.name = name;
  }
}


/**
 * 奶酪披萨
 */
class CheesePizza extends Pizza {

  @Override
  public void prepare() {
    System.out.println(" 给制作奶酪披萨 准备原材料 ");
  }
}


/**
 * 希腊披萨
 */
class GreekPizza extends Pizza {

  @Override
  public void prepare() {
    System.out.println(" 给希腊披萨 准备原材料 ");
  }
}
