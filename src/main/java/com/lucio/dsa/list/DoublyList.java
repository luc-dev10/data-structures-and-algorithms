package com.learning.structure.list;

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

  static class Node {
    int value;
    Node previous;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
