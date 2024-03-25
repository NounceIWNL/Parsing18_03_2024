package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStream2 {
    public static void main(String[] args) {

        //Вывести первые n чисел Фибоначчи
        int a;
        int[] fib = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .mapToInt(t -> t[0])
                .toArray();
        System.out.println(Arrays.toString(fib));

        //Сумма четных чисел Фибоначчи, не превышающих count
        int sum = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .filter(t -> t[0] % 2 == 0)
                .takeWhile(t -> t[0] < 100/*count*/)
                .mapToInt(t -> t[0])
                .sum();
        System.out.println(sum);

        //Вывести первые n факториалов
        int[] facts = Stream.iterate(new Pair(1, 1),
                        x -> new Pair(x.num + 1, x.value * (x.num + 1)))
                .limit(6)
                .mapToInt(x -> x.value)
                .toArray();
        System.out.println(Arrays.toString(facts));

        //Максимальный палиндром, полученный при произведении двух двузначных чисел
        long pal = IntStream.iterate(10000, n -> n - 1)
                .filter(n -> isPalindrome(n) && isFactors(n))
                .map(n -> (int) n)
                .findFirst().orElse(0);


    }

    private static boolean isPalindrome(int number) {
        return (number == Integer.valueOf(new StringBuilder(Integer.toString(number)).reverse().toString()));
    }

    //Можно ли представить это число в виде произведения двух двузначных чисел
    private static boolean isFactors(int number) {
        return IntStream.rangeClosed(10, 99)
                .anyMatch(n -> number % n == 0 && number / n > 9 && number / n < 100);
    }
}

class Pair {
    final int num;
    final int value;

    Pair(int num, int value) {
        this.num = num;
        this.value = value;
    }
}