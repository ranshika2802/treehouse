package com.rajat.ds;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add("H");
        bst.add("G");
        bst.add("F");
        bst.add("E");
        bst.add("D");
        bst.add("C");
        bst.add("B");
        bst.add("A");

        // Print the tree in-order (should print: 20 30 40 50 60 70 80)
        bst.inorderTraversal();
        System.out.println();
//Post-order: 20, 40, 30, 60, 80, 70, 50
        bst.postOrderTraversal();
        System.out.println();

//        Pre-order: 50, 30, 20, 40, 70, 60, 80
        bst.preOrderTraversal();

        System.out.println(bst.contains("Z"));
    }
}
