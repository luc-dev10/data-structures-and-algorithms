package com.learning.structure.list;

public class SinglyList {
  Node head;
  Node tail;
  int size;

  public SinglyList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private Node getNode(int index) {
    if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

    Node current = head;

    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    return current;
  }

  public void addFirst(int value) {
    Node node = new Node(value);
    if (this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      node.next = this.head;
      this.head = node;
    }

    this.size++;
  }

  public void add(int value) {
    if (this.size == 0) {
      this.addFirst(value);
      return;
    }

    Node node = new Node(value);
    this.tail.next = node;
    this.tail = node;
    this.size++;
  }

  public void add(int index, int value) {
    if (index < 0 || index > this.size) return;

    if (index == 0) {
      this.addFirst(value);
      return;
    }

    if (this.size == index) {
      this.add(value);
      return;
    }

    Node previousNode = this.getNode(index - 1);
    Node currentNode = new Node(value);
    Node nextNode = previousNode.next;
    previousNode.next = currentNode;
    currentNode.next = nextNode;
    this.size++;
  }

  public void set(int index, int value) {
    if (index < 0 || index >= this.size) return;

    Node currentNode = this.getNode(index);
    currentNode.value = value;
  }

  public int get(int index) {
    Node node = this.getNode(index);
    return node != null ? node.value : -1;
  }

  public int remove(int index) {
    if (index < 0 || index >= this.size) return -1;

    if (index == 0) {
      return this.removeFirst();
    }

    if (index == this.size - 1) {
      return this.removeLast();
    }

    Node previousNode = this.getNode(index - 1);
    Node currentNode = this.getNode(index);
    int currentValue = currentNode.value;
    previousNode.next = currentNode.next;
    currentNode.next = null;
    this.size--;
    return currentValue;
  }

  public int removeFirst() {
    if (this.size == 0) return -1;

    int temp = this.head.value;

    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      this.head = this.head.next;
    }

    this.size--;
    return temp;
  }

  public int removeLast() {
    if (this.size == 0) return -1;

    int temp = this.tail.value;

    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      Node previousNode = this.getNode(this.size - 2);
      previousNode.next = null;
      this.tail = previousNode;
    }

    this.size--;
    return temp;
  }

  public void reverse() {
    if (this.size < 2) return;

    Node currentNode = this.head;
    Node previousNode = null;

    this.tail = this.head;

    while (currentNode != null) {
      Node nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }

    this.head = previousNode;
  }

  static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }
}
