package io.lcalmsky.leetcode.insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {

    private final List<Integer> values;
    private final Map<Integer, Integer> indexMap;
    private final Random random;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        Integer currentIndex = indexMap.get(val);
        int lastIndex = values.size() - 1;
        swap(currentIndex, lastIndex);
        indexMap.remove(val);
        values.remove(lastIndex);
        return true;
    }

    private void swap(Integer currentIndex, int lastIndex) {
        Integer lastValue = values.get(lastIndex);
        values.set(currentIndex, lastValue);
        indexMap.put(lastValue, currentIndex);
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
