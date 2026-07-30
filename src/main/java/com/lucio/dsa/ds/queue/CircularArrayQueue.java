package com.lucio.dsa.ds.queue;

public final class CircularArrayQueue {
  private final int CAPACITY = 5;
  private final int[] array;
  private int size;
  private int front;
  private int rear;

  public CircularArrayQueue() {
    this.array = new int[this.CAPACITY];
    this.size = 0;
    this.front = 0;
    this.rear = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean isFull() {
    return this.size == this.CAPACITY;
  }

  public void enqueue(int value) {
    if (this.isFull()) return;
    this.array[rear] = value;
    this.rear = (this.rear + 1) % this.CAPACITY;
    this.size++;
  }

  public int dequeue() {
    if (this.isEmpty()) return -1;
    int value = this.array[front];
    this.front = (this.front + 1) % this.CAPACITY;
    this.size--;
    return value;
  }
}
