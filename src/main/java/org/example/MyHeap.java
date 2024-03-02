package org.example;

import java.util.Random;
/*
Name: Anh-Thien Nguyen
ID: 202660307
Date: 3/1/2024
Description: The purpose of the program is to simulate the operations of a Min Heap using an Arraylist in Java.
A Min Heap is a type of Binary Tree Data Structure that is organized so that the smallest value is always at the root,
making it very efficient for priority-based operations such as priority queues, where elements are frequently inserted
and the smallest element is repeatedly accessed and removed. In our simulation, the operations performed on the Min Heap
are twofold: adding and removing elements. The add operation adds a random value to the tree while removing elements involve
removing the smallest value. As the program performs each action, it outputs the current state of the heap, the specific operation (add or remove),
and the intermediate steps involved in each operation (such as the bubble-up and bubble-down swaps). This output not only demonstrates
the changes in the heap but also provides insight into the dynamic behavior of the data structure as it is manipulated.
The purpose of this class is to handle the print and output.
 */

public class MyHeap {
    final static int HOW_MANY_TESTS = 20;

    public static void main(String[] args) {
        System.out.println("CP 16. MinHeap (Winter 2024)");
        Random random = new Random();
        Heap211 minHeap = new Heap211();

        for (int test = 1; test <= HOW_MANY_TESTS; test++) {
            int action = random.nextInt(3); // 0 or 1 or 2
            if (action < 2) {
                int node = random.nextInt(50); // 0~49
                System.out.println(" ");
                System.out.println("Action " + test + ": Add " + node);
                minHeap.add(node);
            } else {
                if (minHeap.isEmpty()) {
                    test = test - 1; // Skip this action, do not count this action
                } else {
                    System.out.println(" ");
                    System.out.println("Action " + test + ": Remove min");
                    int min = minHeap.remove();
                    System.out.println("Removed: " + min);
                }
            }
        }
    }
}
