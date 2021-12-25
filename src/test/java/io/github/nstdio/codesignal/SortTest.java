package io.github.nstdio.codesignal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static io.github.nstdio.codesignal.Sort.bubbleSort;
import static io.github.nstdio.codesignal.Sort.insertionSort;
import static io.github.nstdio.codesignal.Sort.mergeSort;
import static io.github.nstdio.codesignal.Sort.selectionSort;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortTest {

    static Stream<Arguments> sortingData() {
        var lists = List.of(
                new ArrayList<>(List.of(8, 7, 6, 5, 4, 3, 2, 1)),
                new ArrayList<>(List.of(3, 2, 1)),
                new ArrayList<>(List.of(1, 1, 1)),
                new ArrayList<>(List.of(1, 2, 1, 1)),
                new ArrayList<>(List.of(9, 5, 7, 3, 1, 8, 2, 4, 6, 3)),
                new ArrayList<>(List.of(1)),
                new ArrayList<>()
        );

        var sorters = List.of(mergeSort(), selectionSort(), insertionSort(), bubbleSort());

        return sorters.stream()
                .flatMap(sorter -> lists.stream()
                        .map(list -> arguments(sorter, list))
                );
    }

    @ParameterizedTest
    @MethodSource("sortingData")
    void sorting(Sort<Integer> sorter, List<Integer> lst) {
        //when
        List<Integer> actual = sorter.apply(lst);

        //then
        assertThat(actual)
                .hasSameSizeAs(lst)
                .isSorted();
    }
}