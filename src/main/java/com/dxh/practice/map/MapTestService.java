package com.dxh.practice.map;


import com.dxh.practice.factory.NomonTask;
import com.dxh.practice.thread.RunTaskModule;
import com.fxiaoke.common.Pair;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * map 练习
 *
 * @author dongxiaohua
 */
@Service
public class MapTestService {

  public void process() {
    List<NomonTask> nomonTasks = Lists.newArrayList(NomonTask.builder().dataId("1").tenantId("1").build(), NomonTask
      .builder()
      .dataId("2")
      .tenantId("1")
      .build(), NomonTask.builder().dataId("1").tenantId("3").build());

    Map<String, Set<String>> dataIds = Maps.newHashMap();
    nomonTasks.forEach(task -> {
      Set<String> ids = dataIds.computeIfAbsent(task.getTenantId(), k -> Sets.newHashSet());
      ids.add(task.getDataId());
    });
    System.out.print(dataIds);
  }


  public static void main(String[] args) {
    List<String> ids = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8");
    Iterator<String> dataIds = ids.iterator();
    Set<String> useDataIds = Sets.newHashSet();
    while (dataIds.hasNext()) {
      useDataIds.add(dataIds.next());
      if (useDataIds.size() >= 2) {
        System.out.println(">>>>>" + useDataIds);
        useDataIds.clear();
      }
    }
  }

}
