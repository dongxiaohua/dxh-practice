package com.dxh.practice.bilibili;

/**
 * B站 java内存模型练习（JMM）
 *
 * @author dongxiaohua
 */
public class VolatileVisibilityTest {

  private static volatile boolean initFlag = false;

  public static void main(String[] args) throws InterruptedException {
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("waiting data...");
        while (!initFlag) {
        }
        System.out.println(">>>>> success");
      }
    }).start();

    Thread.sleep(2000);

    new Thread(new Runnable() {
      @Override
      public void run() {
        prepareData();
      }
    }).start();
  }

  private static void prepareData() {
    System.out.println("prepareData data...");
    initFlag = true;
    System.out.println("prepareData data end...");

  }
}
