package io.github.nstdio.codesignal.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ListNodeTest {

    private static <T> ListNode<T> nodeAt(int index, ListNode<T> head) {
        for (; index > 0 && head != null; index--, head = head.next) {

        }

        return head;
    }

    static Stream<Arguments> simpleToStringData() {
        return Stream.of(
                arguments(ListNode.of(0, 1, 2, 3, 4, 5, 6, 7, 8), "[0, 1, 2, 3, 4, 5, 6, 7, 8]"),
                arguments(ListNode.of(0), "[0]"),
                arguments(ListNode.of(0, 1), "[0, 1]")
        );
    }

    static Stream<Arguments> loopedToStringData() {
        var n1 = ListNode.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        nodeAt(8, n1).next = nodeAt(7, n1);

        var n2 = ListNode.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        nodeAt(8, n2).next = n2;

        var n3 = ListNode.of(0, 1);
        nodeAt(1, n3).next = n3;

        var n4 = ListNode.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        nodeAt(8, n4).next = nodeAt(4, n4);

        var n5 = ListNode.of(0);
        n5.next = n5;

        return Stream.of(
                arguments(n1, "[0, 1, 2, 3, 4, 5, 6, 7{L}, 8{L}]"),
                arguments(n2, "[0{L}, 1, 2, 3, 4, 5, 6, 7, 8{L}]"),
                arguments(n3, "[0{L}, 1{L}]"),
                arguments(n4, "[0, 1, 2, 3, 4{L}, 5, 6, 7, 8{L}]"),
                arguments(n5, "[0{L}]")
        );
    }

    @ParameterizedTest
    @MethodSource("simpleToStringData")
    void shouldPrintPrettyToString(ListNode<?> listNode, String expected) {
        //when + then
        assertThat(listNode).hasToString(expected);
    }

    @ParameterizedTest
    @MethodSource("loopedToStringData")
    void shouldPrintPrettyToStringWhenLoopOccures(ListNode<?> listNode, String expected) {
        //when + then
        assertThat(listNode).hasToString(expected);
    }
}