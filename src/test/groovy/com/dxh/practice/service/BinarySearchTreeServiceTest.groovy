package com.dxh.practice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class BinarySearchTreeServiceTest extends Specification {

  @Autowired
  BinarySearchTreeService binarySearchTreeService

  def "给定二叉树后序遍历数组，返回所有头节点"() {
    given:
    int[] posArr = [2, 4, 3, 6, 8, 7, 5]
    expect:
    println ">>>>>"
    println binarySearchTreeService.getNodeHead(posArr)
  }
}
