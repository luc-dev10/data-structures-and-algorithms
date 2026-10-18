package com.learning.dsa.ds.tree;

public class BinarySearchTree {
  private Node root;
  private int size;

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  // ___________________________
  // ___________________________

  // Search
  public boolean search(Node node, int value) {
    if (node == null) return false;
    if (node.value == value) return true;
    return node.value > value ? search(node.left, value) : search(node.right, value);
  }
}
