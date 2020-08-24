package com.dxh.practice.stramFifltsService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Lamda表达式练习
 *
 * @author dongxiaohua
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployPojo {
  private String name;
  private String age;
  private String address;
}


class TestService {
  public static void main(String[] args) {
    List<EmployPojo> pojos = Lists.newArrayList();
    pojos.add(EmployPojo.builder().name("dong").age("25").address("china").build());
    pojos.add(EmployPojo.builder().name("xiao").age("26").address("china").build());
    pojos.add(EmployPojo.builder().name("hua").age("27").address("china").build());
    pojos.add(EmployPojo.builder().name("hua").age("3").address("china").build());
    pojos.add(EmployPojo.builder().name("dongxiaohua").age("28").address("china").build());

    List<String> argList = Lists.newArrayList("25", "9", "10");

    /**
     * 将符合表达式的第一个对象返回
     * Optional<EmployPojo> employPojo
     */
    Optional<EmployPojo> employPojo = pojos.stream().filter(pojo -> argList.contains(pojo.getAge())).findFirst();
    List<EmployPojo> employPojos = pojos.stream().filter(pojo -> (argList.contains(pojo.getAge()) || "28".equals(pojo.getAge()))).collect(Collectors.toList());


    List<String> names = pojos.stream().filter(pojo -> argList.contains(pojo.getAge())).map(EmployPojo::getName).collect(Collectors.toList());

    /**
     * 集合根据指定元素转map，key冲突时自定义结果
     */
    Map<String, String> map = pojos.stream().collect(Collectors.toMap(EmployPojo::getName, EmployPojo::getAge, (k1, k2) -> String.valueOf((Integer.valueOf(k1) +
      Integer.valueOf(k2)))));

    employPojo.orElse(null);
  }
}
