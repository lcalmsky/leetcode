package io.lcalmsky.leetcode.lfu_cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LFUCacheTests {
    @Test
    public void givenLFUCache_whenPutAndGet_thenWorkCorrectly() {
        Solution lfuCache = new Solution(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertEquals(1, lfuCache.get(1));
        lfuCache.put(3, 3);
        assertEquals(-1, lfuCache.get(2));
        assertEquals(3, lfuCache.get(3));
        lfuCache.put(4, 4);
        assertEquals(-1, lfuCache.get(1));
        assertEquals(3, lfuCache.get(3));
        assertEquals(4, lfuCache.get(4));
    }
}
