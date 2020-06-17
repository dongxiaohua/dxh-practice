package com.dxh.practice.bilibili;

/**
 * volatile关键词的原子性测试
 */
public class VolatileAtomicTest {
  public static volatile int num = 0;

  public static void increase() {
    num++;
  }

  public static void main(String[] args) throws InterruptedException {

    Thread[] threads = new Thread[10];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 1000; i++) {
            increase();
          }
        }
      });
      threads[i].start();
    }

    for (Thread t : threads) {
      /**
       * join : 等待对应线程执行完并合并到主线程（确保分线程执行完）
       */
      t.join();
    }

    System.out.println(num);
  }
}
