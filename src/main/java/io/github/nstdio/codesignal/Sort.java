package io.github.nstdio.codesignal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import static java.util.Collections.swap;

/**
 * @param <T> The element type.
 */
public interface Sort<T extends Comparable<? super T>> extends UnaryOperator<List<T>> {

    static <E extends Comparable<? super E>> Sort<E> bubbleSort() {
        return new BubbleSort<>();
    }

    static <E extends Comparable<? super E>> Sort<E> insertionSort() {
        return new InsertionSort<>();
    }

    static <E extends Comparable<? super E>> Sort<E> selectionSort() {
        return new SelectionSort<>();
    }

    static <E extends Comparable<? super E>> Sort<E> mergeSort() {
        return new MergeSort<>();
    }

    class BubbleSort<E extends Comparable<? super E>> implements Sort<E> {
        @Override
        public List<E> apply(List<E> lst) {
            int n = lst.size();
            while (n > 1) {
                int nn = 0;
                for (int i = 1; i < n; i++) {
                    if (lst.get(i - 1).compareTo(lst.get(i)) > 0) {
                        swap(lst, i - 1, i);
                        nn = i;
                    }
                }
                n = nn;
            }
            return lst;
        }

        @Override
        public String toString() {
            return "BubbleSort";
        }
    }

    class InsertionSort<E extends Comparable<? super E>> implements Sort<E> {
        @Override
        public List<E> apply(List<E> lst) {
            for (int i = 1; i < lst.size(); i++) {
                for (int j = i; j > 0 && lst.get(j - 1).compareTo(lst.get(j)) > 0; ) {
                    swap(lst, j - 1, j);
                    j--;
                }
            }

            return lst;
        }

        @Override
        public String toString() {
            return "InsertionSort";
        }
    }

    class SelectionSort<E extends Comparable<? super E>> implements Sort<E> {

        @Override
        public List<E> apply(List<E> lst) {
            final int n = lst.size();
            for (int i = 0; i < n; i++) {
                int min = i;
                for (int j = i; j < n; j++) {
                    if (lst.get(j).compareTo(lst.get(min)) < 0) {
                        min = j;
                    }
                }

                if (min != i) {
                    swap(lst, i, min);
                }
            }

            return lst;
        }

        @Override
        public String toString() {
            return "SelectionSort";
        }
    }

    class MergeSort<E extends Comparable<? super E>> implements Sort<E> {

        @Override
        public List<E> apply(List<E> lst) {
            return lst;
        }

        @Override
        public String toString() {
            return "MergeSort";
        }
    }
}
