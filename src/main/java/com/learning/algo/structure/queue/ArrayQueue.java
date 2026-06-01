package com.learning.algo.structure.queue;

public class ArrayQueue {
  int[] array = new int[3];
  int size = 0;

  public void enqueue(int value) {
    this.array[size++] = value;
  }

  public int dequeue() {
    if (size == 0) return -1;

    int temp = this.array[0];

    for (int i = 0; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.size--; // this.array[--this.size] = -1;
    return temp;
  }
}
