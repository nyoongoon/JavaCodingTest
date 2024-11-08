package _0_Theory.Chapter1_Math._08_기초수학_연습문제_1.src;

import java.util.HashSet;
import java.util.Set;

public class Practice4_my {
    static Set<Integer> set = new HashSet<>();
    public static boolean solution(int n) {
        System.out.println(n);
        if(n == 1){
            System.out.println("if(n == 1)");
            return true;
        }

        String str = String.valueOf(n);
        int[] intArr = new int[str.length()];
        int tmpResult = 0;

        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = str.charAt(i) - '0';
            tmpResult += (int) Math.pow(str.charAt(i) - '0', 2);
        }

//        System.out.println(tmpResult);
        if(set.contains(tmpResult)){
            return false;
        }else{
            set.add(tmpResult);
            return solution(tmpResult);
        }
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
