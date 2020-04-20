package io.lcalmsky.leetcode.insert_delete_getrandom_o1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <pre>
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * </pre>
 */
public class RandomizedSet {
    private final Map<Integer, Integer> valueMap;
    private final Map<Integer, Integer> indexMap;
    private final Random random;

    public RandomizedSet() {
        valueMap = new HashMap<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valueMap.containsKey(val)) return false;
        valueMap.put(val, valueMap.size());
        indexMap.put(indexMap.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
            int index = valueMap.get(val);
            valueMap.remove(val);
            indexMap.remove(index);

            Integer last = indexMap.get(indexMap.size());
            if (last != null) {
                indexMap.put(index, last);
                valueMap.put(last, index);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        return valueMap.size() == 0 ? -1 : valueMap.size() == 1 ? indexMap.get(0) : indexMap.get(random.nextInt(valueMap.size()));
    }
}
