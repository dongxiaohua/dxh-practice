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
    /**
     * 根据类型获取对应的bean，这样就可以根据类型来走不同bean中的逻辑了
     */
    IExecute iExecute = service.get("registered3")
    iExecute.execute("registered3")
    then:
    1 == 1
  }

}
