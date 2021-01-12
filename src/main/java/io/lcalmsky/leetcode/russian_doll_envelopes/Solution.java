package io.lcalmsky.leetcode.russian_doll_envelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> c = Comparator.comparing((int[] arr) -> arr[0])
                .thenComparing((int[] arr) -> arr[1], Comparator.reverseOrder());
        Arrays.sort(envelopes, c);
        List<Integer> list = new ArrayList<>();
        for (int[] arr : envelopes) {
            int target = arr[1];
            if (list.isEmpty() || target > list.get(list.size() - 1)) list.add(target);
            else {
                int i = 0;
                int j = list.size() - 1;
                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (list.get(m) >= target) j = m;
                    else i = m + 1;
                }
                list.set(j, target);
            }
        }
        return list.size();
    }
}
