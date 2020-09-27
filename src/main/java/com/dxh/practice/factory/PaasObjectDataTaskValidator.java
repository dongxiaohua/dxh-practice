package com.dxh.practice.factory;

import com.github.autoconf.ConfigFactory;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dongxiaohua
 */
@Component
public class PaasObjectDataTaskValidator {

  public static final String NONE = "none";
  @Resource
  private NomonTaskValidatorFactory nomonTaskValidatorFactory;

  @PostConstruct
  public void init() {
    Map<String, String> bizApiNameMap = new HashMap<String, String>() {
      {
        put("test_biz", "AccountObj");
      }
    };
    bizApiNameMap.forEach((biz, apiName) -> {
      if (NONE.equalsIgnoreCase(apiName)) {
        nomonTaskValidatorFactory.unregister(biz);
      } else {
        nomonTaskValidatorFactory.register(biz, new TaskValidator() {
          @Override
          public boolean validate(NomonTask nomonTask) {
            return PaasObjectDataTaskValidator.this.validate(nomonTask.getTenantId(), apiName, nomonTask.getDataId());
          }

          @Override
          public List<NomonTask> invalidateTasks(List<NomonTask> tasks) {
            if (CollectionUtils.isEmpty(tasks)) {
              return Lists.newArrayList();
            }
            List<NomonTask> result = Lists.newArrayList();
            Map<String, List<NomonTask>> tenantTasksMap = tasks.stream().collect(Collectors.groupingBy(NomonTask::getTenantId));
            tenantTasksMap.forEach((tenantId, tenantTasks) -> {
              Set<String> validateIdSet = findValidateIdSet(tenantId, apiName, tenantTasks.stream().map(NomonTask::getDataId).collect(Collectors.toSet()));
              tenantTasks.forEach(t -> {
                if (!validateIdSet.contains(t.getDataId())) {
                  result.add(t);
                }
              });
            });
            return result;
          }
        });
      }
    });
  }

  public boolean validate(String tenantId, String apiName, String id) {
    //TODO:校验数据是否存在
    return true;
  }

  public Set<String> findValidateIdSet(String tenantId, String apiName, Set<String> idSet) {
    //TODO: 校验数据是否存在，返回存在的Id
    return Sets.newHashSet();
  }
}
