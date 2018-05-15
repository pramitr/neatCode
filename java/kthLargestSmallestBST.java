/**

Write a function kthSmallest to find the kth smallest element in a binary search tree and 
a function kthLargest to find the kth largest element in the binary search tree.

**/



package com.company;
import java.util.*;

public class Solution {

    private List<Integer> findAllNdivK(int[] numbers, int k){
        List<Integer> list = new ArrayList<>();
        return list;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
            //tree.kthSmallest(i);
        }

    }
}

class Node {
    int val;
    Node left, right;
    Node(int d)
    {
        val = d;
        left = right = null;
    }
}

class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        this.root = this.insertRecursive(this.root, data);
    }

    Node insertRecursive(Node node, int data) {
        if (node == null) {
            //this.root = new Node(data);
            return new Node(data);
        }

        if (data == node.val) {
            return node;
        }

        /* Otherwise, recur down the tree */
        if (data < node.val) {
            node.left = this.insertRecursive(node.left, data);
        } else {
            node.right = this.insertRecursive(node.right, data);
        }
        return node;
    }

    public class LargestCount {
        int count = 0;
        int number = 0;
    }

    void kthLargest(int k)
    {
        LargestCount c = new LargestCount(); // object of class count
        this.kthLargestUtil(this.root, k, c);
        System.out.println(k + "th largest element is " + c.number);
    }

    void kthLargestUtil(Node node, int k, LargestCount C)
    {
        if (node == null || C.count >= k)
            return;

        // Follow reverse inorder traversal so that the
        // largest element is visited first
        this.kthLargestUtil(node.right, k, C);

        // Increment count of visited nodes
        C.count++;

        // If c becomes k now, then this is the k'th largest
        if (C.count == k) {
            C.number = node.val;
        }

        // Recur for left subtree
        this.kthLargestUtil(node.left, k, C);
    }

    public class SmallestCount {
        int number = 0;
        int count = 0;
    }

    public void kthSmallest(int k) {
        SmallestCount s = new SmallestCount();
        s.count = k;
        kthSmallestUtil(this.root, s);
        System.out.println(k + "th smallest element is " + s.number);
    }

    void kthSmallestUtil(Node n, SmallestCount s) {
        // Follow inorder traversal so that the
        // smallest element is visited first
        if (n.left != null) kthSmallestUtil(n.left, s);
        s.count--;
        if (s.count == 0) {
            s.number = n.val;
            return;
        }
        if (n.right != null) kthSmallestUtil(n.right, s);
    }

}
