package com.lucio.dsa.datastructures.stack;

public class ArrayStack {
  int[] array = new int[3];
  int size = 0;

  public int pop() {
    if (this.size == 0) return -1;
    return this.array[--this.size];
  }

  public void push(int value) {
    this.array[this.size++] = value;
  }
}
