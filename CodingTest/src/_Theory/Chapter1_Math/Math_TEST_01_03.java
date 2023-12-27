package _Theory.Chapter1_Math;

import java.util.HashSet;
import java.util.Set;

public class Math_TEST_01_03 {
    public static int solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 4;


        return solution(n-1) * solution(1) + solution(n-2) * solution(2);
    }




    public static void main(String[] args) {

        System.out.println(solution(4));
    }
}
