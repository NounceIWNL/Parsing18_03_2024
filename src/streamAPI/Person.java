package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    public static enum Sex {
        MAN,
        WOMAN
    }

    private final String name;
    private final Integer age;
    private final Sex sex;

    public static List<Person> persons = new ArrayList<>(
            (Arrays.asList(new Person("Alice", 25, Sex.WOMAN),
                    new Person("Bob", 30, Sex.MAN),
                    new Person("Charlie", 35, Sex.MAN),
                    new Person("Basil", 16, Sex.MAN),
                    new Person("Peter", 23, Sex.MAN),
                    new Person("Elen", 42, Sex.WOMAN),
                    new Person("John", 69, Sex.MAN)
            )
            )
    );

    public Person(String name, Integer age, Sex sex) {

        this.name
                = name;
        this.age = age;

        this.sex
                = sex;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}