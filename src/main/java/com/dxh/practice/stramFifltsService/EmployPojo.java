package com.dxh.practice.stramFifltsService;

import com.google.common.collect.ArrayListMultimap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class EmployArg {
  private String tenantName;
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


    ArrayListMultimap multimap = ArrayListMultimap.create();
    pojos.forEach(pojo -> multimap.put(pojo.getName(), pojo.getAge()));

    //    List<EmployPojo> studentDistinct2List = pojos.stream().filter(TestService.distinctByKey(EmployPojo::getName)).collect(Collectors.toList());

    List<EmployPojo> studentDistinctList = pojos
      .stream()
      .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(t -> t.getName()))), ArrayList::new));

    Map<String, Boolean> fiflterMap = Maps.newHashMap();
    List<EmployPojo> eps = pojos.stream().filter(it -> {
      Boolean bl = fiflterMap.get(it.getName());
      if (bl == null) {
        fiflterMap.put(it.getName(), true);
        return true;
      }
      return !bl;
    }).collect(Collectors.toList());

    List<EmployArg> employArgs = pojos.stream().map(it -> EmployArg.builder().tenantName(it.getName()).build()).collect(Collectors.toList());

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


  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }
}
