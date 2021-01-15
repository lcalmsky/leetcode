package io.lcalmsky.leetcode.restore_ip_addresses;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RestoreIpAddressesTests {
    @Test
    public void givenString_whenParseAsIp_thenGetIpsCorrectly() {
        assertAll(
                () -> test("25525511135", Arrays.asList(
                        "255.255.11.135",
                        "255.255.111.35"
                ))
        );
    }

    private void test(String given, List<String> expected) {
        Solution restoreIpAddresses = new Solution();
        List<String> actual = restoreIpAddresses.restoreIpAddresses(given);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
