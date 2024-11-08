package _0_Theory.Chapter4_Algorithm._23_알고리즘_연습문제_2.ans;

/**
 * 범위가 주어졌고, 어떤 특정 값을 찾는 상황 -> 바이너리 서치
 */
public class Practice1 {

    public static int solution(int[] rocks, int goal, int n){
//    다시풀기;;;;; 너무너무 어려워;;
        if (rocks == null || rocks.length == 0) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }

}
