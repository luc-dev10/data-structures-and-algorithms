package com.learning.structure.list;

public class SinglyList {
  Node dummy;
  int size;

  public SinglyList() {
    this.dummy = new Node(-1);
    this.size = 0;
  }

  private Node getPrevious(int index) {
    Node previous = this.dummy;
    int i = 0;
    while (i < index) {
      previous = previous.next;
      i++;
    }

    return previous;
  }

  public void addFirst(int value) {
    Node next = this.dummy.next;
    Node node = new Node(value);
    this.dummy.next = node;
    node.next = next;
    this.size++;
  }

  public void add(int value) {
    Node previous = this.dummy;
    Node current = previous.next;
    while (current != null) {
      previous = current;
      current = current.next;
    }

    previous.next = new Node(value);
    this.size++;
  }

  public void add(int index, int value) {
    if (index < 0 || index > this.size) return;
    Node previous = this.getPrevious(index);
    Node temp = previous.next;
    Node newNode = new Node(value);
    previous.next = newNode;
    newNode.next = temp;
    this.size++;
  }

  public void set(int index, int value) {
    if (index < 0 || index >= this.size) return;
    Node previousNode = this.getPrevious(index);
    previousNode.next.value = value;
  }

  public int get(int index) {
    if (index < 0 || index >= this.size) return -1;
    Node previousNode = this.getPrevious(index);
    return previousNode.next.value;
  }

  public int remove(int index) {
    if (index < 0 || index >= this.size) return -1;
    Node previous = this.getPrevious(index);
    Node current = previous.next;
    previous.next = current.next;
    this.size--;
    return current.value;
  }

  public int removeFirst() {
    if (this.size == 0) return -1;
    Node current = this.dummy.next;
    this.dummy.next = current.next;
    this.size--;
    return current.value;
  }

  public int removeLast() {
    if (this.size == 0) return -1;
    Node previous = this.dummy;
    Node current = previous.next;
    while (current.next != null) {
      previous = current;
      current = current.next;
    }
    previous.next = null;
    this.size--;
    return current.value;
  }

  public void reverse() {
    if (this.size < 2) return;
    Node previous = null;
    Node current = this.dummy.next;

    while (current != null) {
      Node next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    this.dummy.next = previous;
  }

  static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
    }
  }
}
