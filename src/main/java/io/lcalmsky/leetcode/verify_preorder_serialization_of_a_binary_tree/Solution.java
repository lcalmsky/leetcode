package io.lcalmsky.leetcode.verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

/**
 * <pre>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * </pre>
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] preorderArray = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : preorderArray) {
            if (!node.equals("#")) {
                stack.push(node);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
