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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        ListNode<T> cur = this;

        while (cur != null) {
            sb.append(cur.value);

            cur = cur.next;

            if (cur != null) {
                sb.append(", ");
            }
        }

        return sb.append(']').toString();
    }
}
