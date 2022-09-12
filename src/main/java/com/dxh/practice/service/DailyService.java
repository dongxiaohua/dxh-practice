package com.dxh.practice.service;

import com.dxh.practice.stramFifltsService.EmployPojo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.map.HashedMap;
import org.testng.collections.Maps;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 日常
 *
 * @author dongxiaohua
 */
public class DailyService {
  public static void main(String[] args) {


    Object dou = 0.0;

    Long value1 = ((Double) dou).longValue();
    boolean bo = value1 >= -11676066610000L && value1 <= 253402271999000L;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    String sql = "".trim().toLowerCase();
    List<String> str = Lists.newArrayList("truncate", "update", "insert", "drop", "rename", "alter");
    for (int i = 0; i < str.size(); i++) {
      if (sql.indexOf(str.get(i)) > -1) {
        return;
      }
    }
    if (sql.contains("delete")) {
      Integer index = sql.indexOf("delete");

    }


    List<String> list2312 = Lists.newArrayList("1", "3", "5", "7", "8", "0");

    Map<String, List<String>> asdaMap = Maps.newHashMap();
    list2312.forEach(it -> {
      asdaMap.computeIfAbsent("ada", k -> Lists.newArrayList()).add(it);
    });
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("US/Pacific-New")));
    System.out.println("US/Pacific-New: " + cal.getTime());

    Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
    cal1.setTimeInMillis(1626660000000L);
    System.out.println("Asia/Shanghai: " + cal1.getTime());

    String s1 = "select * from mt_data where tenant_id = '%s'";
    s1 = s1.replace("where", " LEFT JOIN mt_data_extra e ON d.tenant_id = e.tenant_id AND d.id = e.data_id where");


    String sql213 = "select * from mt_data where id in ('%s')";
    List<String> ids = Lists.newArrayList("1", "2", "3", "4");
    String sql1 = String.format(sql, String.join("','", ids));

    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    queue.offer("a");
    queue.offer("b");
    queue.offer("c");
    queue.poll();
    queue.offer("d");
    queue.poll();

    List<EmployPojo> linkedList = Lists.newArrayList();
    linkedList.add(EmployPojo.builder().age(11).build());
    linkedList.add(EmployPojo.builder().age(8).build());
    linkedList.add(EmployPojo.builder().age(18).build());
    Collections.sort(linkedList, new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        EmployPojo entity1 = (EmployPojo) o1;
        EmployPojo entity2 = (EmployPojo) o2;
        if (true ? (entity1.getAge() > entity2.getAge()) : (entity1.getAge() > entity2.getAge())) {
          return -1;
        } else if (true ? (entity1.getAge().equals(entity2.getAge())) : (entity1.getAge().equals(entity2.getAge()))) {
          return 0;
        } else {
          return 1;
        }
      }
    });

    AtomicReference<String> id = new AtomicReference<>();
    id.set("121");
    id.get();
    id.set("342");
    id.get();

    Long l = 123L;
    Map<String, Object> maps = Maps.newHashMap();
    maps.put("l", l);
    Object l1 = maps.get("l");

    String[] value = new String[10];

    Map<String, List<String>> map = new HashedMap() {
      {
        put("1", Lists.newArrayList("1", "2"));
        put("2", Lists.newArrayList("3", "4"));
        put("3", Lists.newArrayList("5", "6"));
      }
    };

    map.keySet();
    map.values();

    Set<String> s = Sets.newHashSet();
    map.values().stream().forEach(it -> s.addAll(it));
    System.out.println(s);


    List<EmployPojo> list = Lists.newArrayList(EmployPojo.builder().name("a").build(), EmployPojo.builder().name("b").build(), EmployPojo
      .builder()
      .name("c")
      .build(), EmployPojo.builder().name("A").build());
    List<String> list1 = list.stream().map(it -> it.getName()).map(String::toLowerCase).collect(Collectors.toList());
    long count = list1.stream().distinct().count();
    System.out.println(count);
    System.out.println(list);


    List<String> a1 = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g");

    Lists.partition(a1, 0 / 100);
    List<String> a2 = Lists.newArrayList("a", "d");
    a1 = a1.stream().filter(it -> a2.contains(it)).collect(Collectors.toList());
    if (a1.contains(a2)) {
      System.out.println(true);
    }


  }
}