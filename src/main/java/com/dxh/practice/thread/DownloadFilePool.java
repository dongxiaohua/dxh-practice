package com.dxh.practice.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dongxiaohua
 */
public class DownloadFilePool {

  private ExecutorService executor = new ThreadPoolExecutor(0, 100, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new ThreadFactoryBuilder()
    .setNameFormat("dong-demo-%d")
    .build());
  /**
   * 网络资源路径
   */
  private String urlLocation;
  /**
   * 存储路径
   */
  private String filePath;
  /**
   * 多少个线程
   */
  private int poolLength;

  public DownloadFilePool(String urlLocation, String filePath, int poolLength) {
    super();
    // 如果 保存路径为空则默认存在 D盘，文件名跟下载名相同
    if (filePath == null) {
      String fileName = urlLocation.substring(urlLocation.lastIndexOf("/") + 1);
      filePath = "D:/" + fileName;
    }

    this.urlLocation = urlLocation;
    this.filePath = filePath;
    this.poolLength = poolLength;
  }

  public void getFile() {
    try {
      // 获取文件长度
      long fileLength = DownloadUtil.getHttpConnection(urlLocation).getContentLengthLong();
      DownloadUtil.sum = fileLength;

      // 获取每片大小
      long slice = fileLength / poolLength;
      for (int i = 0; i < poolLength; i++) {
        long start = i * slice;
        long end = (i + 1) * slice - 1;

        if (i == poolLength - 1) {
          start = i * slice;
          end = fileLength;
        }
        System.out.println(start + "---" + end);
        // 创建下载类
        DownloadFileRang downloadFileRang = new DownloadFileRang(start, end, urlLocation, filePath);
        // 执行线程
        executor.execute(downloadFileRang);
      }
      // 关闭线程池
      executor.shutdown();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Date startDate = new Date();

    DownloadFilePool pool = new DownloadFilePool("https://www.apponic.com/phome/download/95409-2-1598612140-78c460c47cb09e21c02bcf4cf77ddda6/", null, 100);
    pool.getFile();

    long old = 0;
    long now = 0;
    while (DownloadUtil.sum >= DownloadUtil.start) {
      now = DownloadUtil.start - old;
      old = DownloadUtil.start;

      if (DownloadUtil.sum == DownloadUtil.start) {
        long t = System.currentTimeMillis() - startDate.getTime();
        double speed = ((double) DownloadUtil.sum / (t / 1000.0)) / 1024.0 / 1024.0;

        System.out.println("下载完成，用时：" + t / 1000.0 + " s 平均网速：" + speed + " M/s");
        break;
      }

      System.out.println("网速：" + ((double) (now / 0.5)) / 1024.0 / 1024.0 + " M/s,已完成：" + (DownloadUtil.start / (double) DownloadUtil.sum) * 100 + "%");

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
