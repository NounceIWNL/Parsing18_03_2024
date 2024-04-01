package annotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Machine {
    private List versions;

    @SuppressWarnings({"unchecked"})
    public void addVersion(String version) {
        versions.add(version);
    }
}

@SuppressWarnings({"rawtypes", "unchecked"})
public class BuiltinDemo {
    public static void main(String[] args) {
        BuiltinDemo builtinDemo = new BuiltinDemo();
        builtinDemo.testSuppressWarning();

        DeprecatedDemo.testLegacyFunction();
    }


    public void testSuppressWarning() {
        Map map = new HashMap();
        map.put(1, "item 1");
        map.put(2, "item 2");
        map.put(3, "item 3");
    }
}

class Parent {
    public String getName() {
        return "parent";
    }
}

class Child extends Parent {
    @Override
    public String getName() {
        return "child";
    }
}

class DeprecatedDemo {

    @Deprecated(since = "4.5", forRemoval = true)
    public static void testLegacyFunction() {
        System.out.println("This is a legacy function");
    }
}

@FunctionalInterface
interface Print {
    //Не выдает предупреждение, что метод не используется
    @SuppressWarnings({"unused"})
    void printString(String testString);
    //Добавить еще один метод
}
