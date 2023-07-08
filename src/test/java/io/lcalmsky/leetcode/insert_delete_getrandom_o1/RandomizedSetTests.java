package io.lcalmsky.leetcode.insert_delete_getrandom_o1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedSetTests {
    @Test
    public void givenTests_whenDoTest_thenWork() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.remove(2));
        assertTrue(randomizedSet.insert(2));
        assertTrue(Arrays.asList(1, 2).contains(randomizedSet.getRandom()));
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.insert(2));
        assertEquals(randomizedSet.getRandom(), 2);
    }
}
