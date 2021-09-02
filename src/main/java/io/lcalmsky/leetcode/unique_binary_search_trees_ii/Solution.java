package io.lcalmsky.leetcode.unique_binary_search_trees_ii;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftSubTree;
                    node.right = rightSubTree;
                    treeNodes.add(node);
                }
            }
        }
        return treeNodes;
    }
}
