package com.lucio.dsa.algo.search;

public class BinarySearch {
  public static void main() {
    int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
    int target = 6;
    System.out.print(search(array, target));
  }

  public static int search(int[] a, int target) {
    int l = 0;
    int r = a.length - 1;

    while (l < r) {
      int m = (r - l) / 2 + l;
      if (target == a[m]) return m;
      else if (target < m) r = m - 1;
      else l = m + 1;
    }
    return -1;
  }
}
