package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTest {
    private static List<String> numbers =
            Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

    @Test
    public void test1() {
        Set<String> set = numbers.stream()
                .limit(5)
                .collect(Collectors.toSet());
        //set.forEach(System.out::println);
        Assertions.assertArrayEquals(new String[]{"0", "1", "2", "4"}, set.toArray());
    }

    @Test
    public void test01() {
        int set = numbers.stream()
                .limit(numbers.size())
                .map(Integer::valueOf)
                .filter(i -> i == 5)
                .collect(Collectors.toList())
                .get(0);
        //set.forEach(System.out::println);
        Assertions.assertEquals(5, set);
    }

    @Test
    public void test2() {
        List<Integer> numbersInt = numbers.stream()
                .limit(5)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Assertions.assertArrayEquals(new Integer[]{1, 0, 4, 1, 2}, numbersInt.toArray());
    }

    @Test
    public void test3() {
        List<Integer> numbersInt = numbers.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList());
        Assertions.assertArrayEquals(new Integer[]{4, 6}, numbersInt.toArray());
    }

    @Test
    public void test4() {
        double avg = numbers.stream()
                .mapToDouble(Double::parseDouble)
                .average()
                .orElse(0);
        Assertions.assertEquals(4.1, avg, 0.15);
    }

    @Test
    public void test5() {
        List<Integer> numbersList = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbersList.removeIf(i -> (i % 2 != 0));
        Assertions.assertArrayEquals(new Integer[]{0, 4, 2, 6}, numbersList.toArray());
    }

    @Test
    public void test6() {
        long count = numbers.stream()
                .map(Integer::parseInt)
                .distinct()
                .count();
        Assertions.assertEquals(8, count);
    }

    @Test
    public void test7() {
        double min = numbers.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .orElse(0);
        Assertions.assertEquals(0, min);
    }

    @Test
    public void test8() {
        int sum = numbers.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> (i % 2 == 0))
                .sum();
        Assertions.assertEquals(12, sum);
    }

    @Test
    public void test9() {
        List<String> numbersList = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        Assertions.assertArrayEquals(new String[]{"0", "1", "1", "2", "3", "4", "5", "6", "9", "9"}, numbersList.toArray());
    }

    @Test
    public void test10() {
        Map<Boolean, List<Integer>> mapNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(mapNumbers);
        Map<Boolean, List<Integer>> test1 = Map.of(
                false, Arrays.asList(1, 4, 1, 2),
                true, Arrays.asList(0, 3, 9, 9, 6, 5)
        );
        Assertions.assertEquals(mapNumbers, test1);
    }
}

