package com.dxh.practice.service

import com.dxh.practice.map.MapTestService
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class MapTestServiceTest extends Specification {

  @Resource
  private MapTestService mapTestService

  def "process"(){
    expect:
    mapTestService.process()
  }
}
