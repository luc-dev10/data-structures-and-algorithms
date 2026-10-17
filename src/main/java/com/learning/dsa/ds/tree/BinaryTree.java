package com.learning.dsa.ds.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

  public void inOrderTransversal(Node node) {
    if (node == null) return;
    this.inOrderTransversal(node.left);
    System.out.println(node.value);
    this.inOrderTransversal(node.right);
  }

  public void postOrderTransversal(Node node) {
    if (node == null) return;
    this.postOrderTransversal(node.left);
    this.postOrderTransversal(node.right);
    System.out.println(node.value);
  }

  public boolean search(Node node, int value) {
    if (node == null) return false;
    if (node.value == value) return true;
    return this.search(node.left, value) || this.search(node.right, value);
  }

  public void insert(int value) {
    Node node = new Node(value);
    this.size++;

    if (this.root == null) {
      this.root = node;
      return;
    }

    Deque<Node> dq = new ArrayDeque<>();
    dq.add(this.root);

    while (!dq.isEmpty()) {
      Node current = dq.removeFirst();

      if (current.left != null) {
        dq.add(current.left);
      } else {
        current.left = node;
        return;
      }

      if (current.right != null) {
        dq.add(current.right);
      } else {
        current.right = node;
        return;
      }
    }
  }

  public void breadthFirstSearch() {
    if (this.root == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(this.root);

    while (!queue.isEmpty()) {
      Node node = queue.poll(); // remove first
      System.out.println(node.value);
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
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
