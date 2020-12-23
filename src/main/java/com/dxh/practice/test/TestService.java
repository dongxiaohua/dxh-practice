package com.dxh.practice.test;

import com.dxh.practice.stramFifltsService.EmployPojo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
  public static void main(String[] args) {
    //    OverviewInfoScan overviewInfoScan = new CustomObjectScan();
    //    overviewInfoScan.scan();

    Test test = new Test();
    List<EmployPojo> pojos = Lists.newArrayList(EmployPojo.builder().name("1").build(), EmployPojo.builder().name("2").build(), EmployPojo
      .builder()
      .name("3")
      .build(), EmployPojo.builder().name("4").build());
    List<List<EmployPojo>> p = test.getPartitionList(pojos);
    p.forEach(list -> {
      System.out.println(list);
    });
  }
}


class Test {
  public <T> List<List<T>> getPartitionList(List<T> list) {
    List<List<T>> ptList = Lists.partition(list, 2);
    return ptList;
  }
}
