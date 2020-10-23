package com.dxh.practice.design;

/**
 * 单例模式 饿汉模式
 *
 * @author dongxiaohua
 */
public class HungrySingletonService {

  public static void main(String[] args) {
    HungrySingleton instance = HungrySingleton.getInstance();
    HungrySingleton instance1 = HungrySingleton.getInstance();
    System.out.println(instance == instance1);
  }
}


/**
 * 饿汉模式
 */
class HungrySingleton {
  private static HungrySingleton instance = new HungrySingleton();

  /**
   * 私有构造函数，不能在外部初始化
   */
  private HungrySingleton() {
    //防止反射攻击导致的多例实例化
    if (HungrySingleton.instance != null) {
      throw new RuntimeException("单例不允许多个实例");
    }
  }

  /**
   * 全局访问点
   *
   * @return
   */
  public static HungrySingleton getInstance() {
    return instance;
  }
}