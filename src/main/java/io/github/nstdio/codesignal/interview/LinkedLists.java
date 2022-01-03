package io.github.nstdio.codesignal.interview;

import java.util.ArrayList;
import java.util.List;

public class LinkedLists {
    static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if (l == null)
            return null;

        // remove head
        if (l.value == k) {
            l = l.next;
        }

        ListNode<Integer> prev = l;
        ListNode<Integer> cur = prev == null ? null : prev.next;

        while (cur != null) {
            if (cur.value == k) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        // remove tail
        if (l != null && l.value == k) {
            l = l.next;
        }

        return l;
    }

    /**
     * Given a singly linked list of integers, determine whether or not it's a palindrome.
     * <p>
     * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l,
     * since this is what you'll be asked to do during an interview.
     * <p>
     * Guaranteed constraints: 0 ≤ list size ≤ 5 · 10^5, -10^9 ≤ element value ≤ 10^9.
     *
     * @param l
     * @return
     */
    static boolean isListPalindrome(ListNode<Integer> l) {
        return isListPalindrome3(l);
    }

    private static boolean isListPalindrome3(ListNode<Integer> l) {
        int pow = 0;
        int revNum = l.value;
        ListNode<Integer> cur = l.next;
        while (cur != null) {
            revNum += cur.value * Math.pow(10, ++pow);
            cur = cur.next;
        }

        int num = (int) (l.value * Math.pow(10, pow));
        cur = l.next;
        while (cur != null) {
            num += cur.value * Math.pow(10, --pow);
            cur = cur.next;
        }

        return num == revNum;
    }
}
