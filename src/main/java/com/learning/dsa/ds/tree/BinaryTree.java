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

  public int size() {
    return this.size;
  }

  // _________________________________
  // _________________________________

  // Transversal
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

  // _________________________________
  // _________________________________

  // Search
  private Node searchNode(Node node, int value) {
    if (node == null) return null;
    if (node.value == value) return node;
    Node leftNode = this.searchNode(node.left, value);
    return leftNode != null ? leftNode : this.searchNode(node.right, value);
  }

  public boolean search(int value) {
    return this.searchNode(this.root, value) != null;
  }

  // _________________________________
  // _________________________________

  // Insertion
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

  // _________________________________
  // _________________________________

  // Deletion
  public void delete(int value) {
    if (this.root == null) return;

    if (this.size == 1 && this.root.value == value) {
      this.root = null;
      this.size--;
      return;
    }

    Deque<Node> dq = new ArrayDeque<>();
    dq.add(this.root);

    Node parent = this.root;
    Node target = null;
    Node lastNode = null;

    while (!dq.isEmpty()) {
      Node current = dq.removeFirst();
      if (current.value == value) target = current;
      Node left = current.left;
      Node right = current.right;

      if (left != null || right != null) parent = current;
      if (left != null) {
        dq.add(left);
        lastNode = left;
      }
      if (right != null) {
        dq.add(right);
        lastNode = right;
      }
    }

    if (target != null) {
      if (parent.left == lastNode) {
        target.value = lastNode.value;
        parent.left = null;
      } else if (parent.right == lastNode) {
        target.value = lastNode.value;
        parent.right = null;
      }

      this.size--;
    }
  }
}
