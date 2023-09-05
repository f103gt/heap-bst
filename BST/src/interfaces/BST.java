package interfaces;
public interface BST<T extends Comparable<T>>{
    BST<T> insert(T data) throws NullPointerException;
    //void delete(T data);
}
