package com.learning.structure.deque;

public class ArrayDeque {
  int[] array = new int[3];
  int size = 0;

  public void add(int value) {
    this.array[size++] = value;
  }

  public int removeFront() {
    if (this.size == 0) return -1;

    int temp = this.array[0];

    for (int i = 0; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.size--;
    return temp;
  }

  public int removeBack() {
    if (this.size == 0) return -1;
    return this.array[--this.size];
  }
}
