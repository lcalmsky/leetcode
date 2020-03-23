package io.lcalmsky.leetcode.verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");

        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (stack.isEmpty() || !s.equals("#")) {
                stack.push(s);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
            stack.push("#");
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
