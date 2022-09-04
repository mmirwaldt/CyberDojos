package net.mirwaldt.cyber.dojos;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {
    public static String largestNumber(int... numbers) {
        return IntStream.of(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted(stringComparator3())
                .collect(Collectors.joining());
    }

    private static Comparator<String> stringComparator3() {
        return (a, b) -> -Integer.compare(Integer.parseInt(a + b),
                Integer.parseInt(b + a));
    }
}
