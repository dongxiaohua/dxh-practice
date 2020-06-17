package com.dxh.practice.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class AlgorithmServiceTest extends Specification {

  @Autowired
  AlgorithmService algorithmService

  def "palindrome"() {
    given:
    def s = "abccccdd"
    expect:
    println ">>>>> " + algorithmService.palindrome(s)
  }

  def "sum"() {
    given:
    int[] nums = [3, 2, 3]
    def target = 6
    expect:
    println ">>>>>"
    println algorithmService.sum(nums, target)
  }

  def "solution"() {
    given:
    String s = "qwewqrq"
    expect:
    println ">>>>>"
    println algorithmService.solution(s)
  }

}
