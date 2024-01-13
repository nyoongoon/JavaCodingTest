package _Theory.Chapter1_Math._08_기초수학_연습문제_2.src;

public class Practice1 {


    public static int solution(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(((n - 1) - i));
        }

        return result;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
