package io.lcalmsky.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode of(Integer... array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) integerQueue.offer(array[i]);

        TreeNode treeNode = new TreeNode(array[0]);
        treeNodeQueue.offer(treeNode);

        while (!integerQueue.isEmpty()) {
            Integer leftVal = integerQueue.poll();
            Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
            TreeNode current = treeNodeQueue.poll();
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                assert current != null;
                current.left = left;
                treeNodeQueue.offer(left);
            }
            if (rightVal != null) {
                TreeNode right = new TreeNode(rightVal);
                assert current != null;
                current.right = right;
                treeNodeQueue.offer(right);
            }
        }
        return treeNode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
