package com.lucio.dsa.ds.queue;

public final class ArrayQueue {
  private final int CAPACITY = 3;
  private final int[] array;
  private int size;

  public ArrayQueue() {
    this.array = new int[CAPACITY];
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean isFull() {
    return this.size == this.CAPACITY;
  }

  public int size() {
    return this.size;
  }

  public int peek() {
    return this.isEmpty() ? -1 : this.array[0];
  }

  public void enqueue(int value) {
    if (this.isFull()) return;
    this.array[size++] = value;
  }

  public int dequeue() {
    if (size == 0) return -1;
    int temp = this.array[0];

    for (int i = 0; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.array[this.size - 1] = -1;
    this.size--;
    return temp;
  }
}
