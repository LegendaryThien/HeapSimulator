package org.example;

import java.util.ArrayList;

/*
Name: Anh-Thien Nguyen
ID: 202660307
Date: 3/1/2024
Description: The purpose of this class is to implement a min-heap data structure
using Arraylists. The program initializes the heap Arraylist and adds the dummy
node for index 0. From there, the dummy node simplifies calculations
for finding the parent, left, and right child. The class also has the swap method
for swapping elements if necessary, the peekMin method, and lastly the
add and remove methods to add a random value and remove the minimum value.
 */
public class Heap211 {
    private ArrayList<Integer> heap;

    public Heap211() {
        heap = new ArrayList<>();
        heap.add(0); // Dummy node to simplify parent/child calculations
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private boolean hasParent(int index) {
        return index > 1;
    }

    private boolean hasLeftChild(int index) {
        return leftChild(index) < heap.size();
    }

    private boolean hasRightChild(int index) {
        return rightChild(index) < heap.size();
    }

    private void swap(int a, int b) {
        System.out.println("          swap: " + heap.get(a) + " <--> " + heap.get(b));
        Integer temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public int peekMin() {
        if (heap.size() <= 1) throw new IllegalStateException("Heap is empty");
        return heap.get(1);
    }

    public boolean isEmpty() {
        return heap.size() <= 1;
    }

    public void add(int value) {
        heap.add(value); // add as rightmost leaf
        int index = heap.size() - 1;
        System.out.println(" heap: " + printHeap());
        System.out.println(" bubble-up: start");
        while (hasParent(index) && heap.get(parent(index)) > heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }
        System.out.println(" bubble-up: end");
        System.out.println(" new heap: " + printHeap());
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = peekMin();
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 1;
        System.out.println(" heap: " + printHeap());
        System.out.println(" bubble-down: start");
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChild(index);
            if (hasRightChild(index) && heap.get(rightChild(index)) < heap.get(leftChild(index))) {
                smallerChildIndex = rightChild(index);
            }
            if (heap.get(index) <= heap.get(smallerChildIndex)) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
        System.out.println(" bubble-down: end");
        System.out.println(" new heap: " + printHeap());
        return min;
    }

    public String printHeap() {
        StringBuilder result = new StringBuilder("[");
        if (heap.size() > 1) {
            result.append(heap.get(1));
        }
        for (int i = 2; i < heap.size(); i++) {
            result.append(", ").append(heap.get(i));
        }
        return result.append("]").toString();
    }
}
