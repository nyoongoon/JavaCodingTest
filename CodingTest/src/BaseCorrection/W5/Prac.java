package BaseCorrection.W5;

import java.util.Arrays;
import java.util.Comparator;

public class Prac {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt((String.valueOf(o2))) - Integer.parseInt((String.valueOf(o1)));
            }
        };
        Arrays.stream(numbers).boxed().sorted(comparator).forEach(System.out::println);
    }
}
