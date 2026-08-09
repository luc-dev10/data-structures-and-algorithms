package com.lucio.dsa.algo.sort;

public class BubbleSort {
  public static void main() {
    int[] a = new int[] {5, 1, 5, 2, 9, 2, 4, 6, 7, 34, 12, 66, 8};
    bubbleSort(a);
    for (int n : a) System.out.println(n);
  }

  public static void bubbleSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      boolean swapped = false;
      for (int j = 0; j < a.length - i; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) break;
    }
  }
}
