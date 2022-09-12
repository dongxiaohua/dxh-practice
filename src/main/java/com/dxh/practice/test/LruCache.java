package com.dxh.practice.test;

import java.util.concurrent.ConcurrentHashMap;

public class LruCache<KEY, VALUE> {
  private static final int CACHE_SIZE = 3;
  private int count;
  private ConcurrentHashMap<KEY, Node> cache = new ConcurrentHashMap<>();

  //头
  private Node head;
  //尾
  private Node tail;

  public VALUE get(KEY key) {
    Node node = cache.get(key);
    if (node != null) {
      replaceHead(node);
      return node.value;
    }
    return null;
  }

  public void set(KEY key, VALUE value) {
    Node node = cache.get(key);
    if (node == null) {
      Node newNode = new Node(key, value);
      if (count < CACHE_SIZE) {
        this.addNode(newNode);
        count++;
      } else {
        cache.remove(tail.pre.key);
        removeNode(tail.pre);
        addNode(newNode);
      }
    } else {
      replaceHead(node);
      cache.put(key,new Node(key,value));
    }
  }


  private void addNode(Node node) {
    node.pre = head;
    node.next = head.next;

    head.next.pre = node;
    head.next = node;
  }

  private void removeNode(Node node){
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  private void replaceHead(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;

    node.pre = head;
    node.next = head.next;

    head.next.pre = node;
    head.next = node;

  }

  private class Node {
    private KEY key;
    private VALUE value;
    private Node pre;
    private Node next;

    Node(KEY key, VALUE value) {
      this.key = key;
      this.value = value;
    }
  }

}
