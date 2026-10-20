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
    return node.value > value ? this.search(node.left, value) : this.search(node.right, value);
  }

  // ___________________________
  // ___________________________

  // Insert
  public Node insert(Node node, int value) {
    if (node == null) return new Node(value);
    if (node.value > value) node.left = this.insert(node.left, value);
    else node.right = this.insert(node.right, value);
    return node;
  }

  // _________________________________
  // _________________________________

  // Depth
  public int depth(Node node, int value, int depth) {
    if (node == null) return -1;
    if (node.value == value) return depth;
    int left = depth(node.left, value, depth + 1);
    if (left != -1) return left;
    return depth(node.right, value, depth + 1);
  }

  // _________________________________
  // _________________________________

  // Height
  public int height(Node node) {
    if (node == null) return -1;
    int left = height(node.left);
    int right = height(node.right);
    return 1 + Math.max(left, right);
  }

  // _________________________________
  // _________________________________

  // Size
  public int recursiveSize(Node node) {
    if (node == null) return 0;
    return 1 + recursiveSize(node.left) + recursiveSize(node.right);
  }
}
