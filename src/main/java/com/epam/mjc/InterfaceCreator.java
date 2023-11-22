package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().allMatch(name -> name.matches("^[A-Z].*"));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> IntStream.range(0, x.size()).filter(i -> i % 2 == 0).forEach(i -> x.add(x.get(i)));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->values.stream().filter((((Predicate<String>)name -> name.startsWith("^[A-Z].*")).and(name ->name.endsWith(".")).and(name ->name.split(" +").length>3))).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
