package com.lucio.dsa.algo.sort;

public final class SelectionSort {
  public static void main() {
    int[] a = new int[] {3, 0, -1, -3, 3, 6, 2, 5, 7, 8, 11, -10, 4, 2, 9, 1};
    selectionSort(a);
    for (int n : a) System.out.println(n);
  }

  public static void selectionSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) if (a[min] > a[j]) min = j;
      if (min != i) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
      }
    }
  }
}
