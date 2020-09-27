package com.dxh.practice.factory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 业务入口
 *
 * @author dongxiaohua
 */
@Service
public class JobCleanService {

  @Resource
  private NomonTaskValidatorFactory nomonTaskValidatorFactory;

  public void clean() {
    TaskValidator taskValidator = nomonTaskValidatorFactory.get("test_biz");
    taskValidator.validate(NomonTask.builder().build());
  }


  public static void main(String[] args) {
    String s = "test_biz:AccountObj;value_biz:PRM";
    Map<String, String> bizApiNameMap = Splitter.on(CharMatcher.anyOf(", ;")).trimResults().omitEmptyStrings().withKeyValueSeparator(':').split(s);
  }
}
