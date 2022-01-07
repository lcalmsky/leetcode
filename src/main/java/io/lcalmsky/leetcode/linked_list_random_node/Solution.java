package io.lcalmsky.leetcode.linked_list_random_node;

import io.lcalmsky.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

  private final Map<Integer, ListNode> map;
  private final Random random;

  public Solution(ListNode head) {
    map = new HashMap<>();
    random = new Random();
    int i = 0;
    while (head != null) {
      map.put(i++, head);
      head = head.next;
    }
  }

  public int getRandom() {
    return map.get(random.nextInt(map.size())).val;
  }
}
