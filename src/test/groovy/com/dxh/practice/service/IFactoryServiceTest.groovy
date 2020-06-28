package com.dxh.practice.service

import com.dxh.practice.initializing.IExecute
import com.dxh.practice.initializing.IFactoryService
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class IFactoryServiceTest extends Specification {
  @Resource
  IFactoryService service


  def "execute"() {
    when:
    IExecute iExecute = service.get("registered3")
    iExecute.execute("registered3")
    then:
    1 == 1
  }

}
