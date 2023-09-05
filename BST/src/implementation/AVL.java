package implementation;

import interfaces.BST;

public class AVL<T extends Comparable<T>> implements BST<T> {
    private class Node<E extends Comparable<E>> {
        private int height;
        private final E data;
        private Node<E> left, right;

        Node(E data) {
            this.data = data;
            this.height = 1;
        }

        E getData() {
            return this.data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    Node<T> root;

    public AVL() {
        this.root = null;
    }

    public AVL(T data) {
        this.root = new Node<>(data);
    }

    @Override
    public BST<T> insert(T data) {
        this.root = insert(data, this.root);
        return this;
    }

    private Node<T> insert(T data, Node<T> node) throws NullPointerException {
        if (data == null) throw new NullPointerException("data must not be null");
        Node<T> temp = this.root;
        Node<T> prev = null;
        while (temp != null) {
            prev = temp;
            if (data.compareTo(temp.getData()) <= 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        if (prev == null) {
            this.root = new Node<>(data);
        } else if (data.compareTo(prev.getData()) <= 0) {
            prev.setLeft(new Node<>(data));
        } else {
            prev.setRight(new Node<>(data));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(height(node.getLeft()), height(node.getRight()))
        node.setHeight(maxHeight + 1);
    }

    private int height(Node<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }
}
