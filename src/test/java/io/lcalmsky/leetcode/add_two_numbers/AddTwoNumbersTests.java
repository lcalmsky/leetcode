package io.lcalmsky.leetcode.add_two_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumbersTests {
    @Test
    public void givenTwoNumbers_whenAdd_thenCorrect() {
        // given
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        // when
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        System.out.println(result);

        // then
        assertAll(
                () -> assertEquals(5, result.val),
                () -> assertEquals(7, result.next.val),
                () -> assertEquals(9, result.next.next.val)
        );
    }
}
