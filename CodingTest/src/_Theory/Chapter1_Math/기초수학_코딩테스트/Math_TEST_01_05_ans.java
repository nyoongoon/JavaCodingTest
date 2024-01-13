package _Theory.Chapter1_Math.기초수학_코딩테스트;

import java.util.Arrays;

public class Math_TEST_01_05_ans {
    public static long solution(int N, int M, int K, int[] capacity) {
        // n은 학생수, m은 교실수, k는 감독

        int capacitySum = Arrays.stream(capacity).sum();
        int answer = 1;
        if (N == capacitySum) {
//            int studentLeft = N;
            answer *= arrNCr(capacity, N);
//            for(int cap : capacity){
//                answer *= nCr(studentLeft, cap);
//                studentLeft -= cap;
//            }
        } else {
            int capacityMult = Arrays.stream(capacity)
                    .reduce(1, (x, y) -> x * (y + 1));

            for (int i = 1; i <= capacityMult; i++) {
                int studentSum = 0;
                int[] tmpCapacity = new int[M];
                int numerator = i;
                int denominator = capacityMult;

                for (int j = 0; j < tmpCapacity.length; j++) {
                    denominator /= capacity[j] + 1;
                    tmpCapacity[j] = numerator / denominator;
                    studentSum += tmpCapacity[j];

                    numerator %= denominator;
                }

                if (studentSum == N) {
                    answer *= arrNCr(tmpCapacity, N);
//                    int sudentLeft = N;
//                    for(int cap : tmpCapacity){
//                        answer *= nCr(sudentLeft, cap);
//                        sudentLeft -= cap;
//                    }
                }
            }
        }

        return answer * nFr(K, M);

    }

    public static int nFr(int n, int r) {
        int numerator = 1;
        for (int i = 0; i < r; i++) {
            numerator *= n - i;
        }
        return numerator;
    }

    public static int nCr(int n, int r) {
        int denimonator = 1;
        for (int i = 1; i <= r; i++) {
            denimonator *= i;
        }
        return nFr(n, r) / denimonator;
    }

    public static int arrNCr(int[] capacity, int studentNum) {
        int cases = 1;
        for (int cap : capacity) {
            cases *= nCr(studentNum, cap);
            studentNum -= cap;
        }
        return cases;
    }


    public static void main(String[] args) {
        int[] capacity = new int[]{3, 3, 4}; // 수용가능인원
        int n = 10; // 학생수
        int m = 3; // 교실
        int k = 4; // 감독
        //
//        System.out.println(solution(27, 3, 6, new int[]{22, 8, 2}));
        System.out.println(solution(n, m, k, capacity));
    }
}
