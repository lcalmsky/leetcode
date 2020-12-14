package io.lcalmsky.leetcode.accounts_merge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    public void givenListOfAccounts_whenMergeThem_thenCorrect() {
        assertAll(
                () -> test(
                        Arrays.asList(
                                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                                Arrays.asList("John", "johnnybravo@mail.com"),
                                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                                Arrays.asList("Mary", "mary@mail.com")),
                        Arrays.asList(
                                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                                Arrays.asList("John", "johnnybravo@mail.com"),
                                Arrays.asList("Mary", "mary@mail.com")
                        )
                )
        );
    }

    private void test(List<List<String>> accounts, List<List<String>> expected) {
        // when
        Solution solution = new Solution();
        List<List<String>> actual = solution.accountsMerge(accounts);

        // then
        assertTrue(() -> expected.containsAll(actual));
    }

}
