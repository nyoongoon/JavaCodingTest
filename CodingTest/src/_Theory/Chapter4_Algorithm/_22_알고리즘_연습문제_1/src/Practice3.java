package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;

public class Practice3 {

    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
