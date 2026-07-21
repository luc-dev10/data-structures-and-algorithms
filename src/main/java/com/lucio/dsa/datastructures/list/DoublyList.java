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

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
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
    if (this.isEmpty() || index > this.size || index < 0) return;

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

  public int removeFirst() {
    if (this.isEmpty()) return -1;
    Node current = this.head.next;
    Node next = current.next;
    next.previous = this.head;
    this.head.next = next;
    this.size--;
    return current.value;
  }

  public int removeLast() {
    if (this.isEmpty()) return -1;
    Node current = this.tail.previous;
    Node previous = current.previous;
    previous.next = this.tail;
    this.tail.previous = previous;
    this.size--;
    return current.value;
  }

  public int remove(int index) {
    if (this.isEmpty()) return -1;

    Node current = this.head.next;
    int i = 0;
    while (i < index) {
      current = current.next;
      i++;
    }
    Node previous = current.previous;
    Node next = current.next;
    previous.next = next;
    next.previous = previous;
    this.size--;
    return current.value;
  }

  public void reverse() {
    if (this.isEmpty()) return;
    Node current = this.head.next;
    while (current != this.tail) {
      Node next = current.next;
      current.next = current.previous;
      current.previous = next;
      current = next;
    }

    Node first = this.head.next;
    Node last = this.tail.previous;
    this.head.next = last;
    this.tail.previous = first;
    last.previous = this.head;
    first.next = this.tail;
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
