package Prim;

import java.util.Vector;

public class Minheap {
    public Vector<Integer> heapArray;

    Minheap() {
        heapArray = new Vector<>();
        heapArray.addElement(-1);
    }

    public void minHeapify(int index) { // Make heapArray MinHeap
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        int min, temp;
        if (leftChild <= heapArray.size() - 1 && heapArray.elementAt(leftChild) < heapArray.elementAt(index))
            min = leftChild;
        else
            min = index;
        if (rightChild <= heapArray.size() - 1 && heapArray.elementAt(rightChild) < heapArray.elementAt(min))
            min = rightChild;
        if (min != index) {
            temp = heapArray.elementAt(index);
            heapArray.setElementAt(heapArray.elementAt(min), index);
            heapArray.setElementAt(temp, min);
            minHeapify(min);
        }
    }

    public void buildMinHeap() { // Change unheapified array to heapified array, using a minHeapify function
        for (int i = (this.heapArray.size()) / 2; i >= 1; i--)
            minHeapify(i);
    }

    public void insert(int priority) { // Insert new priority in the min heap
        heapArray.addElement(priority);
        buildMinHeap();
    }

    public int extractMin() { // Extract top priority process and show and delete
        int deletedValue = this.heapArray.elementAt(1);
        this.heapArray.remove(1);
        buildMinHeap();
        return deletedValue;
    }

}