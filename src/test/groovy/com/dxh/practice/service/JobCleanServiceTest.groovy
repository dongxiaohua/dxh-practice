package com.dxh.practice.service

import com.dxh.practice.factory.JobCleanService
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class JobCleanServiceTest extends Specification {

  @Resource
  private JobCleanService jobCleanService


  def "clean"() {
    expect:
    jobCleanService.clean()
  }

}
