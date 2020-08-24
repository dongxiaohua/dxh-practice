package com.dxh.practice.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程同步计数
 *
 * @author dongxiaohua
 */
public class CountDownLatchService {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = new ThreadPoolExecutor(0, 100, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadFactoryBuilder()
      .setNameFormat("demo-%d")
      .build());
    /**
     * 定义并发数
     */
    int parallel = 10;
    /**
     * 线程同步计数器
     */
    CountDownLatch latch = new CountDownLatch(parallel);
    for (int i = 0; i < parallel; i++) {
      executor.submit(new Runnable() {
        @Override
        public void run() {
          try {
            // TODO: 2020/8/24 业务逻辑 可接收返回值
          } finally {
            /**
             * 无论此线程的任务完成还是异常，将定义的计数器减1
             */
            latch.countDown();
          }
        }
      });
    }

    /**
     * 主线程等待所有线程任务干完（计数器为0）
     */
    latch.await();
    // TODO: 2020/8/24 处理全部线程的结果
  }
}
