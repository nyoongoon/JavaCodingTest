package Base_Algorithm.Chapter1_Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Math_TEST_01_02_ans { // nCr을 이용하여 풀이
    public static int solution(String[] names){
       Set<String> set = new HashSet<>(Arrays.asList(names));
       int n = set.size();
       int m = 4;

       long numerator = 1;
       long denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= (n-i);
            denominator *= (i + 1);
        }
        return (int) (numerator / denominator);
    }



    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바", "스쿨", "자바", "베이스",
                "베이스", "백엔드", "화이팅",};
        System.out.println(solution(names));
    }
}
