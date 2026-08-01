package com.lucio.dsa.ds.queue;

public final class ArrayDeque {
  private final int CAPACITY = 5;
  private final int[] array;
  private int size;

  public ArrayDeque() {
    this.array = new int[this.CAPACITY];
    this.size = 0;
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

  public int getFirst() {
    return this.isEmpty() ? -1 : this.array[0];
  }

  public int getLast() {
    return this.isEmpty() ? -1 : this.array[this.size - 1];
  }

  public void addFirst(int value) {
    if (this.isFull()) return;

    for (int i = this.size; i > 0; i--) {
      this.array[i] = this.array[i - 1];
    }

    this.array[0] = value;
    this.size++;
  }

  public void addLast(int value) {
    if (this.isFull()) return;
    this.array[this.size++] = value;
  }

  public int removeLast() {
    if (this.isEmpty()) return -1;

    int value = this.array[this.size - 1];
    this.array[this.size - 1] = -1;
    this.size--;
    return value;
  }

  public int removeFirst() {
    if (this.isEmpty()) return -1;

    int value = this.array[0];
    for (int i = 0; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.size--;
    return value;
  }
}
