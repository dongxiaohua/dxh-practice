package com.dxh.practice.service

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.annotation.Resource

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
class SortServiceTest extends Specification {

  @Resource
  SortService sortService
  @Resource
  ArrayService arrayService


  def "gainMaxAndMin - 取双元素法"() {
    given:
    int[] arr = [7, 3, 19, 40, 4, 7, 1]
    expect:
    println ">>>>>"
    println arrayService.gainMaxAndMin(arr)
  }

  def "合并有序数组"() {
    given:
    int[] arr1 = [1, 2, 4, 4, 6, 8, 9]
    int[] arr2 = [0, 1, 3, 6, 7]
    expect:
    println ">>>>>"
    println arrayService.mergeArr(arr1, arr2)
  }

  def "selectSort - 选择排序"() {
    given:
    int[] a = [5, 4, 9, 8, 7, 6, 0, 1, 2, 3]
    expect:
    println ">>>>>"
    sortService.selectSort(a)
    println a
  }

  def "insertSort - 插入排序"() {
    given:
    int[] a = [38, 65, 97, 76, 13, 27, 49]
    expect:
    println ">>>>>"
    sortService.insertSort(a)
    println a
  }


  def "bubbleSort - 冒泡"() {
    given:
    int[] array = [36, 25, 48, 12, 25, 65, 43, 57]
    expect:
    println ">>>>>"
    sortService.bubbleSort(array)
    println array
  }


  def "bubbleSort2 - 冒泡"() {
    given:
    int[] array = [36, 25, 48, 12, 25, 65, 43, 57]
    expect:
    println ">>>>>"
    sortService.bubbleSort2(array)
    println array
  }

  def "mergeSort - 归并排序"() {
    given:
    int[] a = [5, 4, 9, 8, 7, 6, 0, 1, 3, 2]
    expect:
    sortService.mergeSort(a, 0, a.length - 1)
    println ">>>>>"
    println a
  }


  def "quickSort - 快速排序"() {
    given:
    int[] a = [5, 4, 9, 8, 7, 6, 0, 1, 3, 2]
    expect:
    sortService.quickSort(a, 0, a.length - 1)
    println ">>>>>"
    println a
  }

}
