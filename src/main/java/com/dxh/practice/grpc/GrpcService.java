package com.dxh.practice.grpc;

import cn.dxh.practice.UserServiceGrpc;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * grpc服务端
 * @author dongxiaohua
 */
@Component
public class GrpcService {

  private int port = 19090;
  private Server server;

  @Resource
  private UserServiceGrpc.UserServiceImplBase userService;

  @PostConstruct
  public void init() throws IOException {
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true)
                                                            .setNameFormat("grpc-server-thread-%d")
                                                            .build();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                                                         100,
                                                         60L,
                                                         TimeUnit.SECONDS,
                                                         new LinkedBlockingQueue<>(),
                                                         threadFactory,
                                                         new ThreadPoolExecutor.CallerRunsPolicy());
    server = ServerBuilder.forPort(port)
                          .addService(userService)
                          .executor(executor).build();
    server.start();
  }

  @PreDestroy
  public void destroy() {
    if (server != null) {
      server.shutdown();
    }
  }

}
