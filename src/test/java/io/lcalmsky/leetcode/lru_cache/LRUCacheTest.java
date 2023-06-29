package io.lcalmsky.leetcode.lru_cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
    @Test
    void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(1);
        assertEquals(1, i);
        lruCache.put(3, 3);
        int j = lruCache.get(2);
        assertEquals(-1, j);
        lruCache.put(4, 4);
        int k = lruCache.get(1);
        assertEquals(-1, k);
        int l = lruCache.get(3);
        assertEquals(3, l);
        int m = lruCache.get(4);
        assertEquals(4, m);
    }

    @Test
    void test2() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        int i = lruCache.get(1);
        assertEquals(-1, i);
        int j = lruCache.get(2);
        assertEquals(3, j);
    }
}