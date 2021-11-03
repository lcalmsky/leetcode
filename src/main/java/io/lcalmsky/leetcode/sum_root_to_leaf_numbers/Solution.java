package io.lcalmsky.leetcode.sum_root_to_leaf_numbers;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<TreeNode>> lists = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        getRootToLeafNodes(lists, treeNodes, root);
        return lists.stream()
            .map(tnl -> tnl.stream()
                .map(tn -> tn.val)
                .map(String::valueOf)
                .collect(Collectors.joining()))
            .map(Integer::valueOf)
            .reduce(Integer::sum)
            .orElse(0);
    }

    private void getRootToLeafNodes(
        List<List<TreeNode>> lists, List<TreeNode> treeNodes, TreeNode node) {
        if (node.left == null && node.right == null) {
            lists.add(new ArrayList<>(treeNodes));
        }
        if (node.left != null) {
            treeNodes.add(node.left);
            getRootToLeafNodes(lists, treeNodes, node.left);
            treeNodes.remove(treeNodes.size() - 1);
        }
        if (node.right != null) {
            treeNodes.add(node.right);
            getRootToLeafNodes(lists, treeNodes, node.right);
            treeNodes.remove(treeNodes.size() - 1);
        }
    }

}
