package io.github.nstdio.codesignal.interview;

class ListNode<T> {
    T value;
    ListNode<T> next;

    ListNode(T x) {
        value = x;
    }

    static <T1> ListNode<T1> of(T1... args) {
        ListNode<T1> head = new ListNode<>(args[0]);

        ListNode<T1> node = head;
        for (int i = 1; i < args.length; i++) {
            node.next = new ListNode<>(args[i]);
            node = node.next;
        }

        return head;
    }

    private ListNode<T> findLoop() {
        ListNode<T> slow = this, fast = this, prevFast;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            prevFast = fast;
            fast = fast.next.next;
            if (slow == fast) {
                return fast == this
                        ? prevFast.next
                        : prevFast == this ? fast.next : prevFast;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        var start = findLoop();
        var end = start != null ? start.next : null;

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        ListNode<T> cur = this;

        int hitEnd = 0;
        while (cur != null) {
            if (cur == end && ++hitEnd == 2) {
                break;
            }

            sb.append(cur.value).append(cur == end || cur == start ? "{L}" : "");

            cur = cur.next;

            if (cur != null && (cur != end || hitEnd != 1)) {
                sb.append(", ");
            }
        }

        return sb.append(']').toString();
    }
}
