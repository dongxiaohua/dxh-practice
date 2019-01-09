package com.dxh.practice.aop;

import com.dxh.practice.annotation.AopAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Slf4j
public class AopService {

  @Pointcut(value = "@annotation(com.dxh.practice.annotation.AopAnnotation)")
  void serviceAspect() {
  }

  @Around(value = "controllerAspect()")
  Object getLogAfter(ProceedingJoinPoint joinPoint) throws Throwable {
//    注解说明
    String description = getServiceMethodDescription(joinPoint);

    Object proceed = null;
    try {
      proceed = joinPoint.proceed();
      //todo 获取方法执行状态
    } catch (Exception e) {
      log.error("This method is fail :{}", description);
    }
    return proceed;
  }


  /**
   * 通过反射获取参数
   *
   * @param joinPoint
   * @return
   * @throws Exception
   */
  static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception {
    return ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(AopAnnotation.class).description();
  }

}
