package com.dxh.practice.service;

public class DeadLockService {

  public static Object apple = new Object();
  public static Object banana = new Object();

  public static void main(String[] args) {

    new Thread(new A()).start();
    new Thread(new B()).start();

//    Thread t1 = new Thread(){
//      @Override
//      public void run(){
//        //抢占资源 o1
//        synchronized (o1) {
//          try {
//            Thread.sleep(1000);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//          System.out.println("t1 ---Get o1");
//
//          //需要资源o2 但是 t2 独占(未释放) -->互相竞争资源-->死锁
//          synchronized(o2){
//            System.out.println("t1 ---Get o2");
//          }
//
//
//        }
//      }
//
//    };
//
//
//    Thread t2 = new Thread(){
//      @Override
//      public void run(){
//        //抢占资源o2
//        synchronized (o2) {
//          System.out.println("t2 ---Get o2");
//
//          //需要资源 o1,但是 t1 独占(未释放) -->互相竞争资源-->死锁
//          synchronized (o1) {
//            System.out.println("t2 ---Get o1");
//          }
//        }
//
//      }
//
//    };
//
//
//    t1.start();
//    t2.start();
  }

}


class A implements Runnable {

  @Override
  public void run() {
    synchronized (DeadLockService.apple) {
      System.out.println("A,苹果是我的了");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockService.banana) {
        System.out.println("A,香蕉是我的了");
        System.out.println("A,苹果香蕉在手,世界我有");
      }
    }
  }

}


class B implements Runnable {

  @Override
  public void run() {
    synchronized (DeadLockService.banana) {
      System.out.println("B,香蕉是我的了");
      synchronized (DeadLockService.apple) {
        System.out.println("B,苹果是我的了");
        System.out.println("B,香蕉苹果在手,世界我有");
      }
    }
  }

}
