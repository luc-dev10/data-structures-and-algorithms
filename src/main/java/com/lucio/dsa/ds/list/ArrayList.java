package com.lucio.dsa.ds.list;

public class ArrayList {
  int[] array = new int[3];
  int size;

  private void resize() {
    if (this.size == this.array.length) {
      int[] newArray = new int[this.array.length * 2];
      System.arraycopy(this.array, 0, newArray, 0, this.array.length);
      this.array = newArray;
    }
  }

  public void add(int index, int value) {
    if (this.size < index || index < 0) return;

    this.resize();

    for (int i = this.size; i > index; i--) {
      this.array[i] = this.array[i - 1];
    }

    this.array[index] = value;
    this.size++;
  }

  public int remove(int index) {
    if (this.size <= index || index < 0) return -1;

    int temp = this.array[index];

    for (int i = index; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }

    this.array[this.size - 1] = -1;
    this.size--;
    return temp;
  }
}
