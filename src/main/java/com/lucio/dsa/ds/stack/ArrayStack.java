package com.lucio.dsa.ds.stack;

public final class ArrayStack {
  private final int LIMIT = 3;
  int[] array = new int[3];
  int size = 0;

  public ArrayStack() {
    this.array = new int[this.LIMIT];
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean isFull() {
    return this.size == this.LIMIT;
  }

  public int peek() {
    return this.isEmpty() ? -1 : this.array[this.size - 1];
  }

  public int pop() {
    return this.isEmpty() ? -1 : this.array[--this.size];
  }

  public void push(int value) {
    if (this.isFull()) return;
    this.array[this.size++] = value;
  }
}
