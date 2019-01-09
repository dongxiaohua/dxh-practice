package com.dxh.practice.service

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(value = ["classpath:applicationContext-test.xml"])
class AnnotationServiceTest extends Specification {

  @Resource
  AnnotationService annotationService

  def "getName"() {
    given:
    def tenantId = '53395'
    expect:
    annotationService.getName(tenantId)
  }

}
