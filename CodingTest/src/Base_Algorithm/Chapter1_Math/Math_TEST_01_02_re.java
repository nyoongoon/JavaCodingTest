package Base_Algorithm.Chapter1_Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Math_TEST_01_02_re { // nCr을 이용하여 풀이
    static int result;
    public static int solution(String[] names) {
        // nCr = n*(n-1) ... *(n-r+1)! / r!
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        System.out.println(n);
        int r = 4;
        int numerator = 1;
        int denomiator = 1;

        for (int i = 1; i <= r; i++) {
            numerator *= (n + 1 - i);
            denomiator *= i;
        }
        return numerator / denomiator;
    }


    public static int soluntion1(String[] names) {

    }

    public static void combi(int n, int r, int depth, boolean[] visited){


    }


    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바", "스쿨", "자바", "베이스",
                "베이스", "백엔드", "화이팅",};
//        System.out.println(solution(names));
        System.out.println(soluntion1(names));
    }
}
