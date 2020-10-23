package com.dxh.practice.design;

/**
 * 单例模式 懒汉加载
 *
 * @author dongxiaohua
 */
public class LazySingletonService {

  public static void main(String[] args) {
    new Thread(() -> {
      LazySingleton instance = LazySingleton.getInstance();
      System.out.println(instance);
    }).start();

    new Thread(() -> {
      LazySingleton instance = LazySingleton.getInstance();
      System.out.println(instance);
    }).start();
  }
}


class LazySingleton {
  //volatile 保证共享变量在多线程之间的可见性和有序性，但不能保证原子性，需要借助synchronied这样的锁机制
  private volatile static LazySingleton instance;

  private LazySingleton() {
  }
  public static LazySingleton getInstance() {
    if (instance == null) {
      //在判断后加载，是为了防止多线程同时访问方法造成的性能问题以及多次实例化
      //此处并发访问还是寻在性能损耗
      synchronized (LazySingleton.class) {
        //加锁后再次判断，是为了防止不同线程各自进行了实例化
        if (instance == null) {
          instance = new LazySingleton();
          //字节码层面
          //CPU、JIT
          // 1. 分配空间
          // 后续操作可能不按既定顺序，而造成类似赋值却没有引用而被其他线程返回，造成异常，因此volatile保证了执行顺序
          // 2. 初始化
          // 3. 引用赋值
        }
      }
    }
    return instance;
  }
}