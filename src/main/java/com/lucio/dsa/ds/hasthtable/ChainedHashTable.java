package com.lucio.dsa.ds.hasthtable;

import java.util.ArrayList;
import java.util.List;

public final class ChainedHashTable {
  private int capacity;
  private int size;
  private List<List<Entry>> bucket;

  public ChainedHashTable() {
    this.capacity = 10;
    this.size = 0;
    this.bucket = new ArrayList<>(this.capacity);
    for (int i = 0; i < this.capacity; i++) bucket.add(new ArrayList<>());
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private int hash(String key) {
    return Math.floorMod(key.hashCode(), this.capacity);
  }

  private void rehash() {
    final double LIMIT = 0.75;
    if ((double) (this.size + 1) / this.capacity < LIMIT) return;

    List<List<Entry>> previousBucket = this.bucket;
    this.capacity = this.capacity * 2;
    this.bucket = new ArrayList<>(this.capacity);
    for (int i = 0; i < this.capacity; i++) bucket.add(new ArrayList<>());

    for (List<Entry> list : previousBucket) {
      for (Entry entry : list) {
        this.bucket.get(this.hash(entry.key)).add(entry);
      }
    }
  }

  public void put(String key, int value) {
    int index = this.hash(key);
    List<Entry> list = this.bucket.get(index);

    for (Entry entry : list) {
      if (entry.key.equals(key)) {
        entry.value = value;
        return;
      }
    }

    rehash();
    index = this.hash(key);
    this.bucket.get(index).add(new Entry(key, value));
    this.size++;
  }

  public int get(String key) {
    int index = this.hash(key);
    List<Entry> list = this.bucket.get(index);
    for (Entry entry : list) if (entry.key.equals(key)) return entry.value;
    return -1;
  }

  static class Entry {
    String key;
    int value;

    public Entry(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
