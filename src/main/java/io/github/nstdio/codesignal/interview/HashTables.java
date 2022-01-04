package io.github.nstdio.codesignal.interview;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class HashTables {
    static String[][] groupingDishes(String[][] dishes) {
        return Arrays.stream(dishes)
                .flatMap(dish -> Arrays.stream(dish)
                        .skip(1)
                        .map(s -> Map.entry(s, dish[0]))
                )
                .collect(groupingBy(Map.Entry::getKey, TreeMap::new, mapping(Map.Entry::getValue, toCollection(TreeSet::new))))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream()))
                .map(s -> s.toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
