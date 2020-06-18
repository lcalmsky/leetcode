package io.lcalmsky.leetcode.lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 *
 * Example:
 *
 * LFUCache cache = new LFUCache(2); // capacity
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * </pre>
 */
public class LFUCache {
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> frequencyMap;
    private Map<Integer, Set<Integer>> frequencyCountMap;
    private int capacity;
    private int minValue;

    public LFUCache(int capacity) {
        this.valueMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.frequencyCountMap = new HashMap<>();
        this.capacity = capacity;
        this.minValue = 0;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) return -1;
        int oldFrequency = frequencyMap.get(key);
        frequencyMap.put(key, oldFrequency + 1);
        int newFrequency = frequencyMap.get(key);
        Set<Integer> set = frequencyCountMap.get(oldFrequency);
        set.remove(key);
        if (set.isEmpty()) {
            if (minValue == oldFrequency) minValue = oldFrequency + 1;
            frequencyCountMap.remove(oldFrequency);
        } else {
            frequencyCountMap.put(oldFrequency, set);
        }
        frequencyCountMap.computeIfAbsent(newFrequency, k -> new LinkedHashSet<>()).add(key);
        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (get(key) != -1) {
            valueMap.put(key, value);
            return;
        }

        if (valueMap.size() == capacity) {
            Set<Integer> set = frequencyCountMap.get(minValue);
            int keyToBeDeleted = set.iterator().next();
            valueMap.remove(keyToBeDeleted);
            frequencyMap.remove(keyToBeDeleted);
            set.remove(keyToBeDeleted);
            if (set.isEmpty()) frequencyCountMap.remove(minValue);
        }

        valueMap.put(key, value);
        frequencyMap.put(key, 1);
        frequencyCountMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minValue = 1;
    }
}