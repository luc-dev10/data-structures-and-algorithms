package com.learning.algo.structure.list;

public class DoublyList {
  Node head = null;
  Node tail = null;
  int size = 0;

  public Node getNode(int index) {
    if (index >= this.size || index < 0) return null;

    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    return current;
  }

  public void add(int value) {
    Node node = new Node(value);

    if (this.size == 0) {
      this.head = node;
    } else {
      this.tail.next = node;
      node.previous = this.tail;
    }

    this.tail = node;
    this.size++;
  }

  public void add(int value, int index) {
    if (index > this.size || index < 0) return;

    if (this.size == 0 || this.size == index) {
      this.add(value);
      return;
    }

    Node currentNode = this.getNode(index);
    Node previousNode = currentNode.previous;
    Node newNode = new Node(value);

    previousNode.next = newNode;
    newNode.previous = previousNode;
    newNode.next = currentNode;
    currentNode.previous = newNode;

    if (index == 0) {
      this.head = newNode;
    }

    this.size++;
  }

  /**
   * [1,3]
   *
   * <p>1 -> 2
   *
   * <p>[null.1.2, 1.2.3, 2.3.null
   */
  public void push(T value) {
    DoublyNode<T> node = new DoublyNode<>(value);
    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.setNextNode(node);
      node.setPreviousNode(this.tail);
    }

    this.tail = node;
    this.size++;
  }

  // O(1)
  @Override
  public void insertOnIndex(int index, T value) {
    if (this.size < index || index < 0) throw new IndexOutOfBoundsException();

    if (this.size == 0 || this.size == 1 || this.size == index) {
      this.push(value);
    } else if (index == 0) {
      this.unshift(value);
    } else {
      DoublyNode<T> newNode = new DoublyNode<>(value);
      DoublyNode<T> previousNode = this.get(index - 1);
      DoublyNode<T> nextNode = previousNode.getNextNode();

      previousNode.setNextNode(newNode);
      nextNode.setPreviousNode(newNode);
      newNode.setPreviousNode(previousNode);
      newNode.setNextNode(nextNode);
      this.size++;
    }
  }

  // O(1)
  @Override
  public void removeAt(int index) {
    if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

    if (index == 0) {
      this.shift();
      return;
    }
    if (index == this.size - 1) {
      this.pop();
      return;
    }

    DoublyNode<T> currentNode = this.get(index);
    DoublyNode<T> previousNode = currentNode.getPreviousNode();
    DoublyNode<T> nextNode = currentNode.getNextNode();

    previousNode.setNextNode(nextNode);
    nextNode.setPreviousNode(previousNode);
    currentNode.setNextNode(null);
    currentNode.setPreviousNode(null);

    this.size--;
  }

  // O(n)
  public void set(int index, T value) {
    DoublyNode<T> currentNode = this.get(index);
    currentNode.setValue(value);
  }

  // O(1)
  @Override
  public T pop() {
    if (this.size == 0) return null;

    T value = this.tail.getValue();
    if (size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      DoublyNode<T> tempNode = this.tail.getPreviousNode();
      tempNode.setNextNode(null);
      this.tail.setPreviousNode(null);
      this.tail = tempNode;
    }

    this.size--;
    return value;
  }

  // O(1)
  @Override
  public T shift() {
    if (this.size == 0) return null;

    DoublyNode<T> temp = this.head;
    if (this.size == 1) {
      this.head = null;
      this.tail = null;
    } else {
      DoublyNode<T> currentNode = this.head.getNextNode();
      head.setNextNode(null);
      currentNode.setPreviousNode(null);
      this.head = currentNode;
    }
    this.size--;
    return temp.getValue();
  }

  // O(1)
  @Override
  public void unshift(T value) {
    DoublyNode<T> node = new DoublyNode<>(value);
    if (this.size == 0) {
      this.head = node;
      this.tail = node;
    } else {
      this.head.setPreviousNode(node);
      node.setNextNode(this.head);
      this.head = node;
    }
    this.size++;
  }

  @Override
  public void reverse() {
    if (this.size <= 1) return;

    // reverse head tail
    DoublyNode<T> temp = this.tail;
    this.tail = this.head;
    this.head = temp;

    while (temp != null) {
      DoublyNode<T> previousNode = temp.getPreviousNode();
      DoublyNode<T> nextNode = temp.getNextNode();
      temp.setPreviousNode(nextNode);
      temp.setNextNode(previousNode);

      temp = temp.getNextNode();
    }
  }

  static class Node {
    int value;
    Node previous;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
