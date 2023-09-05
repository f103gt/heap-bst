package implementation;

import exceptions.DeleteFromEmptyHeapException;
import exceptions.InsertIntoFullHeapException;
import interfaces.Heap;
import interfaces.Help;

public class MaxHeap implements Heap {
    int[] maxHeap;
    private int size = 0;

    public MaxHeap(int size) {
        this.maxHeap = new int[size];
    }

    @Override
    public boolean empty() {
        return this.size == 0;
    }

    @Override
    public boolean full() {
        return this.size == this.maxHeap.length;
    }

    private boolean indexIsValid(int index) {
        return index >= 0 && index < this.size;
    }

    private void swim() {
        int child = this.size - 1;
        int parent = getParent(child);
        while (indexIsValid(child) && this.maxHeap[parent] < this.maxHeap[child]) {
            Help helper = new Helper(this.maxHeap);
            helper.swap(child, parent);
            child = parent;
            parent = getParent(child);
        }
    }

    @Override
    public void insert(int number) throws InsertIntoFullHeapException {
        if (this.full()) {
            throw new InsertIntoFullHeapException("unable to insert into a full heap");
        }
        maxHeap[size] = number;
        size++;
        swim();
    }

    @Override
    public int peek() {
        return this.maxHeap[0];
    }

    private void sink() {
        int parent = 0;
        int leftChild = getLeftChild(parent);
        while (this.indexIsValid(leftChild)) {
            Help helper = new Helper(this.maxHeap);
            int rightChild = getRightChild(parent);
            int max = leftChild;
            if (this.indexIsValid(rightChild) &&
                    this.maxHeap[rightChild] > this.maxHeap[leftChild])
                max = rightChild;
            if (this.maxHeap[parent] < this.maxHeap[max]) {
                helper.swap(parent, max);
                parent = max;
                leftChild = getLeftChild(parent);
            } else break;
        }
    }

    @Override
    public void delete() throws DeleteFromEmptyHeapException {
        if (!this.empty()) {
            int max = this.maxHeap[0];
            Help helper = new Helper(this.maxHeap);
            this.size--;
            helper.swap(0, size);
            sink();
        }
        else throw new DeleteFromEmptyHeapException("unable to delete an element from an empty heap");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : this.maxHeap) stringBuilder.append(" ").append(number);
        return stringBuilder.toString();
    }

}
