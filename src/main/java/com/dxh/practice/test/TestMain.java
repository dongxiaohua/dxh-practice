package com.dxh.practice.test;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.testng.collections.Lists;
import retrofit2.http.Url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

public class TestMain {
  public static void main(String[] args) {
    Collection<Field> fields = Lists.newArrayList(Field.builder().fieldNum(1).apiName("a").build(), Field.builder().fieldNum(2).apiName("b").build(), Field
      .builder()
      .fieldNum(3)
      .apiName("c")
      .build());
    byte[] fieldNumArray = new byte[501];
    if (CollectionUtils.isEmpty(fields)) {
      return;
    }
    for (Field field : fields) {
      if (null != field.getFieldNum()) {
        fieldNumArray[field.getFieldNum()] = 1;
      }
    }

    Collection<Field> fields2 = Lists.newArrayList(Field.builder().apiName("a").build(), Field.builder().apiName("b").build(), Field
      .builder()
      .apiName("c")
      .build());

    int i = 1;
    for (Field fieldDescribe : fields2) {
      if ("owner".equals(fieldDescribe.getApiName())) {
        fieldDescribe.setFieldNum(null);
      } else {
        while (i <= 500 && 0 != fieldNumArray[i]) {
          i++;
        }
        if (i > 500) {
          return;
        }
        fieldDescribe.setFieldNum(i++);
      }
    }
    System.out.println(fieldNumArray);
  }
}


@Data
@Builder
class Field {
  private String apiName;
  private Integer fieldNum;
}


class X {
  Y y = new Y();
  public X(){
    System.out.println("X");
  }
}


class Y {
  public Y(){
    System.out.println("Y");
  }
}


class Z extends X {
  Y y = new Y();
  public Z(){
    System.out.println("Z");
  }

  public static void main(String[] args) {
    try {
      URL url = new URL("qweqweq");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    new Z();
  }
}
