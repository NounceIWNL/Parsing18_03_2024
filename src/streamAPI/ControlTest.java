package streamAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTest {
    @Test
    public void test1a() throws IOException {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "b1");

        // Проверить первый элемент коллекции,
        String first = collection.stream().findFirst().orElse(null);

        // последний элемент коллекции,
        String last = collection.stream().skip(collection.size() - 1).findAny().orElse(null);

        // число элементов,
        long count = collection.stream().count();

        // проверить, существует ли элемент
        String find = collection.stream().filter("a3"::equals)
                .findFirst().get();

        //Выбрать элемент по шаблону regex, чтобы строка начиналась на 'b'
        List<String> selected = collection.stream().filter(s -> Pattern.compile(".[b]").matcher(s).matches()).collect(Collectors.toList());

        Assertions.assertAll("executable instance check",
                () -> Assertions.assertEquals(first, "a1"),
                () -> Assertions.assertEquals(last, "b1"),
                () -> Assertions.assertEquals(count, collection.size()),
                () -> Assertions.assertEquals(find, "a3"),
                () -> Assertions.assertArrayEquals()
        );
    }

    @Test
    public void test1() throws IOException {
        //Используя stream, записать в файл последовательность строк "a1,b2,c3,d4...z26"
        File file = new File("src/tests/data.txt");
        PrintWriter out = new PrintWriter(file);
        IntStream.rangeClosed(1, 26)
                .mapToObj(i -> new StringBuilder()
                        .append(Character.toString(i + 'a' - 1))
                        .append(Integer.toString(i)).toString())
                .forEach(out::println);
        out.close();

        //Прочитать данные из файла. Проверить первую и последнюю записанные строки
        List<String> strings = Files.lines(Paths.get("src/tests/data.txt"))
                .collect(Collectors.toList());

        Assertions.assertAll("executable instace check",
                () -> Assertions.assertEquals(strings.get(0), "a1"),
                () -> Assertions.assertEquals(strings.get(strings.size() - 1), "z26")
        );

    }

    @Test
    public void test1b() throws IOException {
        // Выбрать мужчин от 20 до 30 лет
        List<Person> men = Person.persons.stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 30 && p.getSex() == Person.Sex.MAN).collect(Collectors.toList());

        // Найти средний возраст среди мужчин
        Double minAge = Person.persons.stream().filter(p -> p.getSex() == Person.Sex.MAN).mapToInt(Person::getAge)
                .average().getAsDouble();

        // Найти количество трудоспособных (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long count = Person.persons.stream().filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Person.Sex.WOMAN && p.getAge() < 55)
                        || (p.getSex() == Person.Sex.MAN && p.getAge() < 60)).count();

        // Найти человека с максимальным возрастом
        Person older = Person.persons.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();

        // Отсортировать по имени в обратном алфавитном порядке
        List<Person> sortedByName = Person.persons.stream().sorted((p1, p2) -> -p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

        // Отсортировать сначала по полу, а потом по возрасту
        List<Person> sorted2 = Person.persons.stream()
                .sorted((p1, p2) -> p1.getSex() != p2.getSex() ?
                        p1.getSex().compareTo(p2.getSex())
                        : p1.getAge().compareTo(p2.getAge()))
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(sorted2.toArray()));

        //Группировка по полу
        Map<Person.Sex, List<Person>> group = Person.persons.stream()
                .collect(Collectors.groupingBy(Person::getSex));
        System.out.println(group.toString());

    }

    @Test
    public void test2() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Получить все числа подряд, записать в массив целых чисел
        int[] numbers = collection.stream()
                .mapToInt(s -> Integer.parseInt(s.substring(1)))
                .toArray();

        // Получить все числа подряд, записать в массив строк
        collection = Arrays.asList("1,2,0", "4,5");
        String[] strings = collection.stream()
                .flatMap(s -> Arrays.asList(s.split(",")).stream())
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        //Найти сумму всех чисел, которые хранятся через запятую в collection
        collection = Arrays.asList("1,2,0", "4,5", "1,2");
        int sum = collection.stream()
                .flatMapToInt(s -> Arrays.asList(s.split(",")).stream()
                        .mapToInt(Integer::parseInt))
                .sum();
        System.out.println(sum);
    }
}