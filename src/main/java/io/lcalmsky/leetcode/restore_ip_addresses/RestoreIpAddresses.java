package io.lcalmsky.leetcode.restore_ip_addresses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.isEmpty()) return Collections.emptyList();

        List<List<String>> result = new ArrayList<>();
        List<String> items = new ArrayList<>();
        dfs(result, items, s, 0);

        return result.parallelStream()
                .map(l -> String.join(".", l))
                .collect(Collectors.toList());
    }

    private void dfs(List<List<String>> result, List<String> items, String s, int start) {
        if (items.size() >= 4 && start != s.length()) return;

        if (items.size() + s.length() - start + 1 < 4) return;

        if (items.size() == 4) {
            result.add(new ArrayList<>(items));
            return;
        }
        String sub;
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break;
            sub = s.substring(start, start + i);
            if (i > 1 && s.charAt(start) == '0') break;
            if (Integer.parseInt(sub) > 255) break;
            items.add(sub);
            dfs(result, items, s, start + i);
            items.remove(items.size() - 1);
        }
    }
}
