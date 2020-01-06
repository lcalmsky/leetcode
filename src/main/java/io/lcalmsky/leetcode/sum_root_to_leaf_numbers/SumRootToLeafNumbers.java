package io.lcalmsky.leetcode.sum_root_to_leaf_numbers;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

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

    private void getRootToLeafNodes(List<List<TreeNode>> lists, List<TreeNode> treeNodes, TreeNode root) {
        if (root.left == null && root.right == null) {
            lists.add(new ArrayList<>(treeNodes));
        }
        if (root.left != null) {
            treeNodes.add(root.left);
            getRootToLeafNodes(lists, treeNodes, root.left);
            treeNodes.remove(treeNodes.size() - 1);
        }
        if (root.right != null) {
            treeNodes.add(root.right);
            getRootToLeafNodes(lists, treeNodes, root.right);
            treeNodes.remove(treeNodes.size() - 1);
        }
    }

}
