package com.dxh.practice.service;

import com.dxh.practice.annotation.AopAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dongxiaohua
 */
@Service
@Slf4j
public class AnnotationService {

  private static final int mod = 10;

  @AopAnnotation(description = "测试service方法")
  public String getName(String tenantId) {
    return String.valueOf(Math.abs(tenantId.hashCode() % mod));
  }

}
