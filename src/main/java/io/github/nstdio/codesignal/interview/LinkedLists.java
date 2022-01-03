package io.github.nstdio.codesignal.interview;

import java.util.ArrayDeque;

public class LinkedLists {
    static ListNode<Integer> reverse(ListNode<Integer> l) {
        ListNode<Integer> prev = null, cur = l, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

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
     *
     * @return
     */
    static boolean isListPalindrome(ListNode<Integer> l) {
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

    /**
     * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999
     * that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to
     * add up these huge integers and return the result in the same format.
     *
     * @param a The first number, without its leading zeros.
     * @param b The second number, without its leading zeros.
     *
     * @return The result of adding a and b together, returned without leading zeros in the same format.
     */
    static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        var sa = new ArrayDeque<Integer>();
        var sb = new ArrayDeque<Integer>();
        for (ListNode<Integer> n = a; n != null; n = n.next) sa.push(n.value);
        for (ListNode<Integer> n = b; n != null; n = n.next) sb.push(n.value);
        ListNode<Integer> r = null;
        int carry = 0;
        while (!sa.isEmpty() || !sb.isEmpty() || carry > 0) {
            int s = (sa.isEmpty() ? 0 : sa.pop()) + (sb.isEmpty() ? 0 : sb.pop()) + carry;
            ListNode<Integer> n = new ListNode<>(s % 10000);
            n.next = r;
            r = n;
            carry = s / 10000;
        }
        return r;
    }

    static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> head = new ListNode<>(-1), curr = head;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
