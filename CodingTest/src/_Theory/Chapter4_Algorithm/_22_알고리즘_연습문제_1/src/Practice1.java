package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;


import java.util.Arrays;

public class Practice1 {

    public static int solution(int n, int[] times) {
        int p1 = 0;
        int max = Arrays.stream(times).max().getAsInt();
        int p2 = n * max;


        while (p1 < p2) {
            int result = 0;
            int mid = (p1 + p2) / 2;

            for (int i = 0; i < times.length; i++) {
                result += mid / times[i];
            }

            if (result < n) { // 시간이 부족
                p1 = mid + 1;
            } else if (result > n) {
                p2 = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // Test code
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
