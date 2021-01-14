package com.dxh.practice.service

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class ArrayOrSortServiceTest extends Specification {

  @Resource
  ArrayOrSortService arrayOrSortService


  def "gainMaxAndMin"() {
    given:
    int[] arr = [7, 3, 19, 40, 4, 7, 1]
    expect:
    println ">>>>>"
    println arrayOrSortService.gainMaxAndMin(arr)
  }

  def "selectSort"() {
    given:
    int[] a = [5, 4, 9, 8, 7, 6, 0, 1, 2, 3]
    expect:
    println ">>>>>"
    arrayOrSortService.selectSort(a)
    println a
  }

  def "insertSort"() {
    given:
    int[] a = [38, 65, 97, 76, 13, 27, 49]
    expect:
    println ">>>>>"
    arrayOrSortService.insertSort(a)
    println a
  }


  def "bubbleSort"() {
    given:
    int[] array = [36, 25, 48, 12, 25, 65, 43, 57]
    expect:
    println ">>>>>"
    arrayOrSortService.bubbleSort(array)
    println array
  }


  def "bubbleSort2"() {
    given:
    int[] array = [36, 25, 48, 12, 25, 65, 43, 57]
    expect:
    println ">>>>>"
    arrayOrSortService.bubbleSort2(array)
    println array
  }

}
