package com.dxh.practice.service;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 红黑树
 *
 * @author dongxiaohua
 */
@Service
@Slf4j
public class RedBlackTreeService {

  private final int R = 0;
  private final int B = 1;

  //红黑树根结点
  private Node root = null;


  class Node {
    //存的具体数字
    int data;
    int clore = R;
    Node left;
    Node right;
    Node parent;

    public Node(int data) {
      this.data = data;
    }
  }

  /**
   * 插入数据
   * <p>
   * root结点一定不为空，最开始就默认进去了
   *
   * @param root
   * @param data
   */
  public void insert(Node root, int data) {
    if (root.data < data) {
      // 表示插入到右边
      if (root.right == null) {
        root.right = new Node(data);
      } else {
        insert(root.right, data);
      }
    } else {
      if (root.left == null) {
        root.left = new Node(data);
      } else {
        insert(root.left, data);
      }
    }
  }

  /**
   * 左旋
   *
   * @param node
   */
  public void leftRotate(Node node) {
    //表示根结点
    if (node.parent == null) {
      Node E = root;
      Node S = E.right;
      //1. 移动S的左子树
      E.right = S.left;
      S.left.parent = E;

      //2. 修改E的指向
      E.parent = S;
      //3. 修改S的指向
      S.parent = null;
    }
  }

  /**
   * 对红黑树的节点(x)进行左旋转
   * <p>
   * 左旋示意图(对节点x进行左旋)：
   *     px                             px
   *     /                              /
   *     x                             y
   *   /  \      --(左旋)-.           / \                #
   * lx   y                          x  ry
   *  /   \                        /  \
   * ly   ry                     lx  ly
   *
   * @param node
   */
  private void leftRotate2(Node node) {
    // 设置x的右孩子为y
    Node y = node.right;

    // 将 “y的左孩子” 设为 “x的右孩子”；
    // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
    node.right = y.left;
    if (y.left != null) {
      y.left.parent = node;
    }

    // 将 “x的父亲” 设为 “y的父亲”
    y.parent = node.parent;

    if (node.parent == null) {
      // 如果 “x的父亲” 是空节点，则将y设为根节点
      this.root = y;
    } else {
      if (node.parent.left == node) {
        // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        node.parent.left = y;
      } else {
        // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        node.parent.right = y;
      }

      // 将 “x” 设为 “y的左孩子”
      y.left = node;
      // 将 “x的父节点” 设为 “y”
      node.parent = y;
    }
  }

}
