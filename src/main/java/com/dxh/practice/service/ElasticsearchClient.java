package com.dxh.practice.service;

import lombok.experimental.Delegate;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @author dongxiaohua
 */
@Service
public class ElasticsearchClient {
  @Delegate
  private RestHighLevelClient client;

  @PostConstruct
  public void init(){

  }

  @PreDestroy
  public void destroy(){
    if (client != null) {
      try {
        client.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
