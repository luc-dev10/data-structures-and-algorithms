package com.lucio.dsa.ds.queue;

public final class MinPriorityQueue {
  private final int CAPACITY = 10;
  private final Node[] array;
  private int size;

  public MinPriorityQueue() {
    this.array = new Node[this.CAPACITY];
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isFull() {
    return this.size == this.CAPACITY;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int peek() {
    if (this.isEmpty()) return -1;

    Node current = this.array[0];
    for (int i = 1; i < this.size; i++) {
      if (current.priority > this.array[i].priority) current = this.array[i];
    }

    return current.value;
  }

  public void enqueue(int value, int priority) {
    if (this.isFull()) return;
    this.array[this.size++] = new Node(value, priority);
  }

  public int dequeue() {
    if (this.isEmpty()) return -1;

    int index = 0;
    for (int i = 1; i < this.size; i++) {
      if (this.array[index].priority > this.array[i].priority) index = i;
    }

    Node node = this.array[index];
    for (int i = index; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.size--;
    return node.value;
  }

  static class Node {
    int value;
    int priority;

    public Node(int value, int priority) {
      this.value = value;
      this.priority = priority;
    }
  }
}
