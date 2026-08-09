package com.lucio.dsa.algo.search;

public class LinearSearch {
  public static void main(String[] args) {
    int[] array = new int[] {5, 1, 5, 2, 9, 2, 4, 6, 7, 34, 12, 66, 8};
    int target = 6;
    System.out.print(search(array, target));
  }

  public static int search(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) return i;
    }

    return -1;
  }
}
