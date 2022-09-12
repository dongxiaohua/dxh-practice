package com.dxh.practice.test;

import org.springframework.stereotype.Service;

@Service
public class CaseTest {

  public ListNode test(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode newHead = null;
    while(head !=null){
      ListNode t = head.next;
      head.next = newHead;
      newHead = head;
      head = t;
    }
    return newHead;
  }
}