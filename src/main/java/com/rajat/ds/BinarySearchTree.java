package com.rajat.ds;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(E e) {
        root = addRecursive(root, e);
    }

    public Node addRecursive(Node<E> currNode, E value) {
        if(currNode == null) {
            return new Node<>(value);
        } else if (value.compareTo(currNode.e)<0) {
           currNode.left = addRecursive(currNode.left, value);
        } else if (value.compareTo(currNode.e)>0) {
            currNode.right = addRecursive(currNode.right, value);
        }
        return currNode;
    }

    public boolean contains(E e) {
        if(Objects.nonNull(e) && Objects.nonNull(root)) {
           return containsRecursive(root, e);
        }
        return false;
    }

    private boolean containsRecursive(Node<E> curr,  E val) {
        if(val.compareTo(curr.e) == 0) return true;
        else if (val.compareTo(curr.e) < 0) return containsRecursive(curr.left, val);
        else return containsRecursive(curr.right, val);
    }

    /**
     * INORDER LEFT->ROOT->RIGHT
     * PREORDER ROOT->LEFT->RIGHT
     * POSTORDER RIGHT->LEFT->RIGHT
     */
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.print(node.e + " ");
            inorderTraversalRecursive(node.right);
        }
    }

    /**
     * POSTORDER -> LEFT->RIGHT->ROOT
     */
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(Node<E> currNode) {
        if(currNode != null) {
            postOrderTraversalRecursive(currNode.left);
            postOrderTraversalRecursive(currNode.right);
            System.out.print(currNode.e + " ");
        }
    }

    /**
     * PREORDER -> ROOT->LEFT->RIGHT
     *
     */
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(Node<E> currNode) {
        if(currNode != null) {
            System.out.print(currNode.e + " ");
            preOrderTraversalRecursive(currNode.left);
            preOrderTraversalRecursive(currNode.right);
        }
    }
}

class Node<E> {
     Node<E> left;
     Node<E> right;
     E e;

    public Node(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }
}
