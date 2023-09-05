package implementation;

import exceptions.DeleteFromEmptyHeapException;
import exceptions.InsertIntoFullHeapException;
import interfaces.Heap;

public class Main {
    public static void main(String[] args) throws DeleteFromEmptyHeapException,
            InsertIntoFullHeapException {
        Heap heap = new MaxHeap(5);
        heap.insert(1);
        heap.insert(-1);
        heap.insert(20);
        heap.insert(10);
        heap.insert(25);
        System.out.println(heap.toString());
        heap.delete();
        System.out.println(heap.toString());
        heap.delete();
        System.out.println(heap.toString());
        heap.delete();
        System.out.println(heap.toString());
        heap.delete();
        System.out.println(heap.toString());
        heap.delete();
        System.out.println(heap.toString());
    }
}