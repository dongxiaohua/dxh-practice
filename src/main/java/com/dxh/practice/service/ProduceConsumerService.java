package com.dxh.practice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

/**
 * 生产者和消费者
 */
@Service
@Slf4j
public class ProduceConsumerService {
  //  队列最大数量
  private final int MAX_NUM = 10;
  // 设置消息队列
  private final LinkedList<String> list = new LinkedList<>();

  /**
   * 生产者
   */
  public void produce() {
    while (true) {
      //      锁住队列
      synchronized (list) {
        //        队列满则等待
        while (list.size() == MAX_NUM) {
          try {
            list.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        //        生产
        list.add("n.1");
        //        唤醒所有等待线程
        list.notifyAll();
        //        线程休眠一会儿给唤醒的线程执行时间
        try {
          Thread.sleep(new Random().nextInt(100));
          //          Uninterruptibles.sleepUninterruptibly(3, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }


  public void consumer() {
    synchronized (list) {
      while (list.size() == 0) {
        try {
          list.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      list.getFirst();
      list.notifyAll();
      try {
        Thread.sleep(new Random().nextInt(100));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
