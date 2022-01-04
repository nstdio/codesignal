package io.github.nstdio.codesignal.interview;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class HashTables {
    static String[][] groupingDishes(String[][] dishes) {
        var m = new TreeMap<String, Set<String>>();
        Arrays.stream(dishes).forEach(dish -> Arrays.stream(dish).skip(1)
                .map(s -> m.computeIfAbsent(s, k -> new TreeSet<>()))
                .forEach(s -> s.add(dish[0])));

        return m.entrySet()
                .stream()
                .filter(e -> e.getValue().size() != 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream()))
                .map(lst -> lst.toArray(String[]::new))
                .toArray(String[][]::new);
    }
}
