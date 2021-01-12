package io.lcalmsky.leetcode.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {

        if (n < 1 || n < k) return Collections.emptyList();

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> items = new ArrayList<>();

        dfs(n, k, 1, items, results);

        return results;
    }

    private void dfs(int n, int k, int start, List<Integer> items, List<List<Integer>> results) {
        if (items.size() == k) {
            results.add(new ArrayList<>(items));
            return;
        }
        for (int i = start; i <= n; i++) {
            items.add(i);
            dfs(n, k, i + 1, items, results);
            items.remove(items.size() - 1);
        }
    }
}
