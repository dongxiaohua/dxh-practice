package com.dxh.practice.stramFifltsService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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
  private Integer age;
  private String address;
}


class TestService {
  public static void main(String[] args) {
    List<EmployPojo> pojos = Lists.newArrayList();
    pojos.add(EmployPojo.builder().name("dong").age(25).address("china").build());
    pojos.add(EmployPojo.builder().name("xiao").age(26).address("china").build());
    pojos.add(EmployPojo.builder().name("hua").age(27).address("china1").build());
    pojos.add(EmployPojo.builder().name("hua").age(3).address("china2").build());
    pojos.add(EmployPojo.builder().name("hua").age(3).address("china3").build());
    pojos.add(EmployPojo.builder().name("dongxiaohua").age(28).address("china").build());

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
    Map<String, Integer> map = pojos.stream().collect(Collectors.toMap(EmployPojo::getName, EmployPojo::getAge, (k1, k2) -> k1 + k2));

    Map<String, EmployPojo> employPojoMap = pojos.stream().collect(Collectors.toMap(EmployPojo::getName, Function.identity(), (k1, k2) -> EmployPojo
      .builder()
      .name(k1.getName())
      .age(k1.getAge() + k2.getAge())
      .address(k1.getAddress())
      .build()));
    List<EmployPojo> employPojosList = Lists.newArrayList(employPojoMap.values());
    employPojo.orElse(null);


    Map<String, List<EmployPojo>> map1 = pojos.stream().collect(Collectors.groupingBy(EmployPojo::getName));
    map1.size();


    List<Map<String, Integer>> maps = Lists.newArrayList();
    Map map2 = Maps.newHashMap();
    map2.put("1", "2");
    map2.put("2", 1);

    Map map3 = Maps.newHashMap();
    map3.put("1", "3");
    map3.put("2", 5);
    maps.add(map2);
    maps.add(map3);

    maps.stream().filter(m -> m.get("2") > 3).collect(Collectors.toSet());

  }
}
