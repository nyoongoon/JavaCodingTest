package _0_Theory.Chapter1_Math._08_기초수학_연습문제_1.src;

import java.util.HashSet;
import java.util.Set;

public class Practice4 {

    public static void main(String[] args) {
        // Test code
//        System.out.println(solution(19));
        System.out.println(solution(2));
//        System.out.println(solution(61));
    }

    public static boolean solution(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }

            if(sum == 1){
                System.out.println(sum);
                return true;
            }

            if(!set.add(sum)){
                System.out.println(sum);
                return false;
            }
            n = sum;
        }
    }
}
