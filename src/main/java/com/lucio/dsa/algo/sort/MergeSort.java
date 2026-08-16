package com.lucio.dsa.algo.sort;

public class MergeSort {
  public static void main() {
    int[] a = new int[] {3, 0, -1, -3, 3, 6, 2, 5, 7, 8, 11, -10, 4, 2, 9, 1};
    mergeSortRecursion(a, 0, a.length - 1);
    for (int n : a) System.out.println(n);
  }

  public static void mergeSortRecursion(int[] a, int l, int r) {
    if (l >= r) return;
    int m = (r - l) / 2 + l;
    mergeSortRecursion(a, l, m);
    mergeSortRecursion(a, m + 1, r);
    recursiveSort(a, l, m, r);
  }

  public static void recursiveSort(int[] a, int l, int m, int r) {
    int[] t = new int[r - l + 1]; // n log n
    int i = l;
    int j = m + 1;
    int k = 0;

    while (i <= m && j <= r) {
      if (a[i] <= a[j]) t[k++] = a[i++];
      else t[k++] = a[j++];
    }

    // Left/Right Spill
    while (i <= m) t[k++] = a[i++];
    while (j <= r) t[k++] = a[j++];

    // Swap
    for (int y = 0; y < t.length; y++) a[l + y] = t[y];
  }
}

// Divide
// [4,2,4,6,3,4,1,2,5,8]
// [4,2,4,6,3] [4,1,2,5,8]
// [4,2,4] [6,3] [4,1,2] [5,8]
// [4][2] [4] [4][1]
