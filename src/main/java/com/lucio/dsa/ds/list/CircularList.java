package com.lucio.dsa.ds.list;

public final class CircularList {
  private final Node dummy;
  private Node tail;
  private int size;

  public CircularList() {
    this.dummy = new Node(-1);
    this.tail = dummy;
    this.dummy.next = dummy;
    this.size = 0;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int getFirst() {
    return this.dummy.next.value;
  }

  public int getLast() {
    return this.tail.value;
  }

  public int get(int index) {
    if (this.isEmpty() || this.size <= index || index < 0) return -1;

    Node current = this.dummy.next;
    int i = 0;
    while (i < index) {
      current = current.next;
      i++;
    }

    return current.value;
  }

  public void addFirst(int value) {
    Node current = new Node(value);
    current.next = this.dummy.next;
    this.dummy.next = current;
    if (this.isEmpty()) this.tail = current;
    this.size++;
  }

  public void addLast(int value) {
    Node current = new Node(value);
    this.tail.next = current;
    this.tail = current;
    this.tail.next = this.dummy;
    this.size++;
  }

  public void add(int index, int value) {
    if (index < 0 || index > this.size) return;

    if (this.isEmpty() || this.size == index) {
      this.addLast(value);
    } else if (index == 0) {
      this.addFirst(value);
    } else {
      Node current = this.dummy.next;
      Node previous = this.dummy;
      int i = 0;

      while (i < index) {
        previous = current;
        current = current.next;
        i++;
      }

      Node node = new Node(value);
      previous.next = node;
      node.next = current;
      this.size++;
    }
  }

  public int removeLast() {
    if (this.isEmpty()) return -1;

    Node previous = this.dummy;
    Node current = previous.next;

    while (current != this.tail) {
      previous = current;
      current = current.next;
    }

    previous.next = current.next;
    this.tail = previous;
    this.size--;
    return current.value;
  }

  public int removeFirst() {
    if (this.isEmpty()) return -1;
    Node previous = this.dummy;
    Node current = previous.next;
    previous.next = current.next;
    this.size--;
    if (current == this.tail) this.tail = previous;
    return current.value;
  }

  public int remove(int index) {
    if (this.size <= index || this.isEmpty()) return -1;

    if (this.size - 1 == index) {
      return this.removeLast();
    } else if (index == 0) {
      return this.removeFirst();
    }

    Node previous = this.dummy;
    Node current = previous.next;
    int i = 0;

    while (i < index) {
      previous = current;
      current = current.next;
      i++;
    }

    previous.next = current.next;
    this.size--;
    return current.value;
  }

  static class Node {
    int value;
    Node next;

    public Node(int value) {}
  }
}
