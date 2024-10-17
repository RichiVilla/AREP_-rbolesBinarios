package org.example;

import java.lang.*;
import java.util.Comparator;

public class BinarySearchTree<T> {

    private class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    // Insertion
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, T value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (comparator.compare(value, root.data) < 0) {
            root.left = insertRec(root.left, value);
        } else if (comparator.compare(value, root.data) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Search
    public boolean search(T value) {
        return searchRec(root, value) != null;
    }

    private Node searchRec(Node root, T value) {
        if (root == null || comparator.compare(value, root.data) == 0) {
            return root;
        }
        if (comparator.compare(value, root.data) < 0) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    // Delete
    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, T value) {
        if (root == null) {
            return null;
        }
        if (comparator.compare(value, root.data) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (comparator.compare(value, root.data) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMinRec(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    // In-order
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.data + " ");
        }
    }

    // Find Minimum
    public T findMin() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return findMinRec(root);
    }

    private T findMinRec(Node root) {
        if (root.left == null) {
            return root.data;
        }
        return findMinRec(root.left);
    }

    // Find Maximum
    public T findMax() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return findMaxRec(root);
    }

    private T findMaxRec(Node root) {
        if (root.right == null) {
            return root.data;
        }
        return findMaxRec(root.right);
    }

    // Height
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
    }

    // Balance
    public boolean balance() {
        return balanceRec(root) != -1;
    }

    private int balanceRec(Node root) {
        if (root == null) return 0;

        int leftHeight = balanceRec(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = balanceRec(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Level-order
    public void levelOrder() {
        int h = height();
        for (int i = 1; i <= h; i++) { // corrected to h inclusive
            printLevel(root, i);
        }
    }

    private void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.data + " ");
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    // Clear
    public void clear() {
        root = null;
    }

    // Count Nodes
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}
