package com.dxh.practice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(value = ["classpath:applictionContext.xml"])
class AnnotationServiceTest extends Specification {

  @Autowired
  AnnotationService annotationService

  def "getName"() {
    given:
    def tenantId = '53395'
    expect:
    annotationService.getName(tenantId)
  }

}
