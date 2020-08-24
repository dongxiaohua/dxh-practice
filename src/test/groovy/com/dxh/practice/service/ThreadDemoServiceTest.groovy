package com.dxh.practice.service

import com.dxh.practice.thread.RunTaskModule
import com.dxh.practice.thread.ThreadDemoService
import org.springframework.test.context.ContextConfiguration
import org.testng.collections.Lists
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class ThreadDemoServiceTest extends Specification {
  @Resource
  ThreadDemoService threadDemoService

  def "start"() {

    given:
    List<RunTaskModule> modules = Lists.newArrayList()
    for (int i = 0; i < 100; i++) {
      modules.add(RunTaskModule.builder().name("dong" + i).arg(i).build())
    }
    expect:
    print "result: "
    print threadDemoService.start(modules)
  }
}
