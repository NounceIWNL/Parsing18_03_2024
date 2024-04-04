package numbersPractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testCalcOne() {
        System.out.println("======TEST ONE EXECUTED=======");
        int result1 = NumbersPractice.getResult(2, 2);
        Assertions.assertEquals(4, result1);
        int result2 = NumbersPractice.getResult(3, 2);
        Assertions.assertEquals(9, result2);
        int result3 = NumbersPractice.getResult(3, 4);
        Assertions.assertEquals(1, result3);
        int result4 = NumbersPractice.getResult(5, 3);
        Assertions.assertEquals(5, result4);
        int result5 = NumbersPractice.getResult(10, 1000000);
        Assertions.assertEquals(10, result5);
    }
}
