package com.lucio.dsa.datastructures.list;

public class DoublyList {
  Node head;
  Node tail;
  int size = 0;

  public DoublyList() {
    this.head = new Node(-1);
    this.tail = new Node(-1);
    this.head.next = this.tail;
    this.tail.previous = this.head;
  }

  public int getFirst() {
    return this.head.next != this.tail ? this.head.next.value : -1;
  }

  public int getLast() {
    return this.tail.previous != this.head ? this.tail.previous.value : -1;
  }

  public int get(int index) {
    if (this.head.next == this.tail || index >= this.size || index < 0) return -1;

    Node current = this.head.next;
    int i = 0;
    while (i < index) {
      current = current.next;
      i++;
    }

    return current.value;
  }

  public void addFirst(int value) {
    Node next = this.head.next;
    Node node = new Node(value);
    this.head.next = node;
    node.previous = head;
    node.next = next;
    next.previous = node;
    this.size++;
  }

  public void addLast(int value) {
    Node previous = this.tail.previous;
    Node node = new Node(value);
    node.previous = previous;
    node.next = tail;
    previous.next = node;
    this.tail.previous = node;
    this.size++;
  }

  public void add(int index, int value) {
    if (this.head.next == this.tail || index > this.size || index < 0) return;

    Node current = this.head.next;
    int i = 0;
    while (i < index) {
      current = current.next;
      i++;
    }

    Node previous = current.previous;
    Node node = new Node(value);
    previous.next = node;
    node.previous = previous;
    node.next = current;
    current.previous = node;
    this.size++;
  }

  public int removeFirst(int value) {
    return -1;
  }

  public int removeLast(int value) {
    return -1;
  }

  public int remove(int index, int value) {
    return -1;
  }

  public void reverse() {}

  static class Node {
    int value;
    Node previous;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
