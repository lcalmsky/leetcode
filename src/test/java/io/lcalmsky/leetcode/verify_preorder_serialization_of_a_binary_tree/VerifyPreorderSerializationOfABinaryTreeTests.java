package io.lcalmsky.leetcode.verify_preorder_serialization_of_a_binary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyPreorderSerializationOfABinaryTreeTests {
    @Test
    public void givenPreorderSerializedString_whenCheckIsValid_thenCorrect() {
        assertAll(
                () -> test("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                () -> test("1, #", false),
                () -> test("9, #, #, 1", false)
        );
    }

    private void test(String given, boolean expected) {
        // when
        VerifyPreorderSerializationOfABinaryTree verifyPreorderSerializationOfABinaryTree = new VerifyPreorderSerializationOfABinaryTree();
        boolean actual = verifyPreorderSerializationOfABinaryTree.isValidSerialization(given);

        // then
        assertEquals(expected, actual);
    }
}
