package io.lcalmsky.leetcode.populating_next_right_pointers_in_each_node;

public class Solution {
    public Node connect(Node root) {
        Node firstNodeOfCurrentDepth = root;
        while (firstNodeOfCurrentDepth != null) {
            Node current = firstNodeOfCurrentDepth;
            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            firstNodeOfCurrentDepth = firstNodeOfCurrentDepth.left;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}