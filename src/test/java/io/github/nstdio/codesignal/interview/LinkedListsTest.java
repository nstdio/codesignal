package io.github.nstdio.codesignal.interview;

import static io.github.nstdio.codesignal.interview.LinkedLists.addTwoHugeNumbers;
import static io.github.nstdio.codesignal.interview.LinkedLists.isListPalindrome;
import static io.github.nstdio.codesignal.interview.LinkedLists.removeKFromList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LinkedListsTest {

    @Test
    void testRemoveKFromList() {
        assertThat(removeKFromList(ListNode.of(1, 1, 1, 1, 1), 1)).isNull();
        assertThat(removeKFromList(ListNode.of(1, 2, 3, 4), 10)).hasToString("[1, 2, 3, 4]");
        assertThat(removeKFromList(ListNode.of(1, 2), 2)).hasToString("[1]");
        assertThat(removeKFromList(ListNode.of(1, 2), 1)).hasToString("[2]");
        assertThat(removeKFromList(ListNode.of(1), 4)).hasToString("[1]");
        assertThat(removeKFromList(ListNode.of(1, 2, 3, 3, 4), 4)).hasToString("[1, 2, 3, 3]");
        assertThat(removeKFromList(ListNode.of(1, 2, 3, 3, 4), 2)).hasToString("[1, 3, 3, 4]");
        assertThat(removeKFromList(ListNode.of(1, 2, 3, 3, 4), 3)).hasToString("[1, 2, 4]");
    }

    @Test
    void testIsPalindrome() {
        assertThat(isListPalindrome(ListNode.of(1, -125, 80, 125, 1))).isFalse();

        assertThat(isListPalindrome(ListNode.of(1, -125, 80, -125, 1))).isTrue();

        assertThat(isListPalindrome(ListNode.of(1, 1000000000, -1000000000, -1000000000, 1000000000, 1))).isTrue();

        assertThat(isListPalindrome(ListNode.of(0, 1, 0))).isTrue();

        assertThat(isListPalindrome(ListNode.of(1, 2, 2, 3, 4))).isFalse();

        assertThat(isListPalindrome(ListNode.of(1, 1, 1, 1, 1))).isTrue();

        assertThat(isListPalindrome(ListNode.of(1, 2, 3, 3, 2))).isFalse(); // 12332    23321
    }

    @Test
    void testAddTwoHugeIntegers() {
        assertThat(addTwoHugeNumbers(ListNode.of(9876, 5432, 1999), ListNode.of(1, 8001)))
                .hasToString("[9876, 5434, 0]");

        assertThat(addTwoHugeNumbers(ListNode.of(123, 4, 5), ListNode.of(100, 100, 100)))
                .hasToString("[223, 104, 105]");
    }
}