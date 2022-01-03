package io.github.nstdio.codesignal.interview;

import static io.github.nstdio.codesignal.interview.LinkedLists.addTwoHugeNumbers;
import static io.github.nstdio.codesignal.interview.LinkedLists.isListPalindrome;
import static io.github.nstdio.codesignal.interview.LinkedLists.mergeTwoLinkedLists;
import static io.github.nstdio.codesignal.interview.LinkedLists.rearrangeLastN;
import static io.github.nstdio.codesignal.interview.LinkedLists.removeKFromList;
import static io.github.nstdio.codesignal.interview.LinkedLists.reverse;
import static io.github.nstdio.codesignal.interview.LinkedLists.reverseNodesInKGroups;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LinkedListsTest {

    @Test
    void testReverse() {
        assertThat(reverse(ListNode.of(1, 2, 3))).hasToString("[3, 2, 1]");
    }

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

    @Test
    void testMergeTwoLinkedLists() {
        assertThat(mergeTwoLinkedLists(ListNode.of(5, 10, 15, 40), ListNode.of(2, 3, 20)))
                .hasToString("[2, 3, 5, 10, 15, 20, 40]");

        assertThat(mergeTwoLinkedLists(ListNode.of(1, 2, 3), ListNode.of(4, 5, 6)))
                .hasToString("[1, 2, 3, 4, 5, 6]");

        assertThat(mergeTwoLinkedLists(ListNode.of(1, 1, 2, 4), ListNode.of(0, 3, 5)))
                .hasToString("[0, 1, 1, 2, 3, 4, 5]");

        assertThat(mergeTwoLinkedLists(null, ListNode.of(1, 1, 2, 2, 4, 7, 7, 8)))
                .hasToString("[1, 1, 2, 2, 4, 7, 7, 8]");
    }

    @Test
    void testReverseNodesInKGroups() {
        assertThat(reverseNodesInKGroups(ListNode.of(1, 2, 3, 4, 5), 2)).hasToString("[2, 1, 4, 3, 5]");

        assertThat(reverseNodesInKGroups(ListNode.of(1, 2, 3, 4, 5, 6), 3)).hasToString("[3, 2, 1, 6, 5, 4]");
    }

    @Test
    void testRearrangeLastN() {
        assertThat(rearrangeLastN(ListNode.of(1, 2, 3, 4), 2)).hasToString("[3, 4, 1, 2]");
        assertThat(rearrangeLastN(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8), 2)).hasToString("[7, 8, 1, 2, 3, 4, 5, 6]");
        assertThat(rearrangeLastN(ListNode.of(1, 2, 3, 4, 5), 2)).hasToString("[4, 5, 1, 2, 3]");
    }
}