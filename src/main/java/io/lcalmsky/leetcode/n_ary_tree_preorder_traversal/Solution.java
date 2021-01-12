package io.lcalmsky.leetcode.n_ary_tree_preorder_traversal;

import io.lcalmsky.leetcode.n_ary_tree_level_order_traversal.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) helper(child, list);
    }
}
