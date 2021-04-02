package io.lcalmsky.leetcode.all_nodes_distance_k_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
    private Map<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parents = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        List<Integer> answer = new ArrayList<>();

        int dis = 0;
        while (!queue.isEmpty()) {
            if (dis == K) {
                for (TreeNode treeNode : queue) answer.add(treeNode.val);
                break;
            }
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null && visited.add(treeNode.left)) queue.offer(treeNode.left);
                if (treeNode.right != null && visited.add(treeNode.right)) queue.offer(treeNode.right);
                TreeNode parent = parents.get(treeNode);
                if (parent != null && visited.add(parent)) queue.offer(parent);
                size -= 1;
            }
            dis += 1;
        }
        return answer;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            parents.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
