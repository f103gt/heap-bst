package interfaces;

import exceptions.DeleteFromEmptyHeapException;
import exceptions.InsertIntoFullHeapException;

public interface Heap {

    default int getParent(int child) {
        return (child - 1) / 2;
    }

    default int getLeftChild(int parent) {
        return parent * 2 + 1;
    }

    default int getRightChild(int parent) {
        return parent * 2 + 2;
    }

    boolean empty();

    boolean full();
    void insert(int index) throws InsertIntoFullHeapException;

    int peek();
    void delete() throws DeleteFromEmptyHeapException;//only root can be deleted


}
