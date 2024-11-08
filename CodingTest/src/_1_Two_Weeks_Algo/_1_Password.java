package _1_Two_Weeks_Algo;

import java.util.List;

public class _1_Password {
    public static void main(String[] args) {
        List<Long> inputs = List.of(100003600009L, 1500035500153L, 20000000000002L);
        System.out.println(solution(100003600009L));
        System.out.println(solution(1500035500153L));
        System.out.println(solution(20000000000002L));

    }

    public static boolean solution(Long input) {
        boolean result = true;
        long min = 1000000;

        if (input < min) {
            result = false;
        }
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return result;
    }
}
