package numbersPractice;
/*
Найти последнюю цифру выражения a^b, где a и b - целые числа.
Результат может быть очень большим.

Для каждого числа от 0 до 9 вычислить все возможные последние цифры
при возведении их в заданную степень.
Записать их в коллекцию ArrayList<ArrayList<Integer>>.
Найти закономерность при получении последней цифры.*/

import java.util.ArrayList;
import java.util.Scanner;

public class NumbersPractice {
    public static void main(String[] args) {
    }

    public static int getResult(int a, int b) {
        ArrayList<ArrayList<Integer>> numbersList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbersList.add(new ArrayList<>());

            for (int j = 1; j < 10; j++) {
                int digit = (int) Math.pow(i, j) % 10;
                if (!numbersList.get(i).contains(digit))
                    numbersList.get(i).add(digit);
            }
        }
        int lasta = a % 10;
        int lastb = b % 4 == 0 ? numbersList.get(lasta).size() - 1
                : b % numbersList.get(lasta).size() - 1;
        int last = numbersList.get(lasta).get(lastb);
        return last;
    }
}
