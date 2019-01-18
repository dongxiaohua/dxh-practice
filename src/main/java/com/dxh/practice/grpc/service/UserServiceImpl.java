package com.dxh.practice.grpc.service;

import cn.dxh.practice.DeletedByIdRequest;
import cn.dxh.practice.DeletedByIdResponse;
import cn.dxh.practice.FindByAgeRequest;
import cn.dxh.practice.FindByIdRequest;
import cn.dxh.practice.FindByNameRequest;
import cn.dxh.practice.UserEntity;
import cn.dxh.practice.UserServiceGrpc;
import com.dxh.practice.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongxiaohua
 */
@Slf4j
@Service
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

  @Resource
  private UserMapper userMapper;

  /**
   * 简单rpc
   * 其中StreamObserver<UserEntity>是一个应答观察者,用于封装返回的信息,服务器把该信息传给客户端.请求结束要调用onCompleted()方法.
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void findById(FindByIdRequest request, StreamObserver<UserEntity> responseObserver) {
    try {
      long id = request.getId();
      userMapper.findById(id);
      responseObserver.onNext(UserEntity.newBuilder().build());
//      请求结束
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("findById is error");
    }
  }

  /**
   * 服务器端流式 RPC
   *
   * @param request
   * @param responseObserver
   */
  @Override
  public void findByAge(FindByAgeRequest request, StreamObserver<UserEntity> responseObserver) {
    try {
      int age = request.getAge();
      List<UserEntity> userEntities = userMapper.findByAgs(age);
      userEntities.forEach(userEntity -> responseObserver.onNext(UserEntity.newBuilder().build()));
      responseObserver.onCompleted();
    } catch (Exception e) {
      log.error("");
    }
  }


  /**
   * 客户端流式 RPC
   * 服务端就需要一直监控客户端写入情况,因此需要一个StreamObserver接口,其中onNext方法会在客户端每次写入时调用,当写入完毕时调用onCompleted()方法
   *
   * @param responseObserver
   * @return
   */
  @Override
  public StreamObserver<DeletedByIdRequest> deleteById(StreamObserver<DeletedByIdResponse> responseObserver) {
    return new StreamObserver<DeletedByIdRequest>() {
      @Override
      public void onNext(DeletedByIdRequest deletedByIdRequest) {
        userMapper.deletedById(deletedByIdRequest.getId());
      }

      @Override
      public void onError(Throwable throwable) {
        throwable.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(DeletedByIdResponse.newBuilder().build());
        responseObserver.onCompleted();
      }
    };
  }

  /**
   * 双向流式 RPC
   *
   * @param responseObserver
   * @return
   */
  @Override
  public StreamObserver<FindByNameRequest> findByName(StreamObserver<UserEntity> responseObserver) {
    return new StreamObserver<FindByNameRequest>() {
      @Override
      public void onNext(FindByNameRequest findByNameRequest) {
        userMapper.findByName(findByNameRequest.getName());
      }

      @Override
      public void onError(Throwable throwable) {
        throwable.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(UserEntity.newBuilder().build());
        responseObserver.onCompleted();
      }
    };
  }
}
