package com.learning.dsa.ds.tree;

public class BinaryTree {
  public int size;
  private Node root;

  public BinaryTree() {
    this.root = null;
    this.size = 0;
  }

  public void preOrderTransversal(Node node) {
    if (node == null) return;
    System.out.println(node.value);
    this.preOrderTransversal(node.left);
    this.preOrderTransversal(node.right);
  }

  public int size() {
    return this.size;
  }
}

class Node {
  int value;

  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
  }
}
