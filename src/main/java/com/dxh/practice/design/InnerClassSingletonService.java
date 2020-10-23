package com.dxh.practice.design;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式 静态内部类
 *
 * @author dongxiaohua
 */
public class InnerClassSingletonService {
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    new Thread(() -> {
      InnerClassSingleton instance = InnerClassSingleton.getInstance();
      System.out.println(instance);
    }).start();

    new Thread(() -> {
      InnerClassSingleton instance = InnerClassSingleton.getInstance();
      System.out.println(instance);
    }).start();

    //反射攻击
    //拿到构造函数
    Constructor<InnerClassSingleton> declaredConstrutor = InnerClassSingleton.class.getDeclaredConstructor();
    //设置accessible为true，拿到访问权
    declaredConstrutor.setAccessible(true);
    InnerClassSingleton innerClassSingleton = declaredConstrutor.newInstance();

  }
}


class InnerClassSingleton {
  /**
   * 静态内部类，在调用getInstance才会初始化
   */
  private static class InnerClassHolder {
    private static InnerClassSingleton instance = new InnerClassSingleton();
  }

  /**
   * 私有构造函数 不能在外部初始化
   */
  private InnerClassSingleton() {
    //防止反射攻击导致的多例实例化
    if (InnerClassHolder.instance != null) {
      throw new RuntimeException("单例不允许多个实例");
    }
  }

  /**
   * 全局访问点
   *
   * @return
   */
  public static InnerClassSingleton getInstance() {
    return InnerClassHolder.instance;
  }
}

