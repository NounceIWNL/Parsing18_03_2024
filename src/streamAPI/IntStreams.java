package streamAPI;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreams {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .forEach(System.out::println);
        int[] arr = IntStream.range(1, 10)
                .toArray();
        int sum = IntStream.range(1, 10)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Random random = new Random();
        int[] randArr = IntStream.generate(() -> random.nextInt(100))
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(randArr));

        String sArr = Arrays.stream(randArr)
                .sorted()
                .mapToObj(String::valueOf) //преобразование
                .collect(Collectors.joining(","));
        System.out.println(sArr);

        boolean b = 4 % 2 == 0;

        String sArr2 = Arrays.stream(randArr)
                .filter(i -> i % 2 == 0)
                .mapToObj(String::valueOf) //преобразование
                .collect(Collectors.joining(","));
        System.out.println(sArr2);

        IntStream.range(1, 1001)
                .filter(i -> i % 3 == 0 && i % 5 == 0 && i % 11 == 0)
                .forEach(System.out::println);

        //вывести квадраты первых n натуральных чисел
        IntStream.range(1, 11)
                .map(i -> i * i)
                .forEach(System.out::println);
        //вывести степени числа 2
        IntStream.range(1, 11)
                .map(i -> (int) Math.pow(2, i))
                .forEach(System.out::println);

        IntStream.iterate(2, i -> i * 2)
                .limit(10)
                .forEach(System.out::println);


    }
}
