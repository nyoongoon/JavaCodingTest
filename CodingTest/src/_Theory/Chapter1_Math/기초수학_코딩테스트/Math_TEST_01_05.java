package _Theory.Chapter1_Math.기초수학_코딩테스트;

import java.util.Arrays;

public class Math_TEST_01_05 {
    public static long solution(int N, int M, int K, int[] capacity) {
        int capacitySum = Arrays.stream(capacity).sum();
        int studentCases = 1;

        if (capacitySum == N) {
            int studentLeft = N;

            for (int cap : capacity) {
                studentCases *= nChooseK(studentLeft, cap);
                studentLeft -= cap;
            }
        } else { // 학생 수보다 공간이 많은 경우
            studentCases = 1;
            long capacityMult = Arrays.stream(capacity).asLongStream()
                    .reduce(1, (x, y) -> x * (y + 1));

            indexLoop:
            for (int i = 0; i < capacityMult; i++) { //5 * 4 * 5 // .. 100
                int[] caps = new int[M];
                long denominator = capacityMult; //denominator == 분모
                long numerator = i; // numerator == 분자
                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    denominator /= capacity[j] + 1;

                    caps[j] = (int) (numerator / denominator);
                    currentSum += caps[j];

                    numerator %= denominator;

                    if(currentSum > N){
                        continue indexLoop;
                    }
                }

                long currentCase = 1;
                if(Arrays.stream(caps).sum() == N){
                    int studentLeft = N;
                    for(int cap : caps){
                        currentCase *= nChooseK(studentLeft, cap);
                        studentLeft -= cap;
                    }
                    studentCases *= currentCase;
                }
            }
        }

        long kPm = 1;
        for (int i = K-M+1; i <= K ; i++) {
            kPm *= i;
        }
        return studentCases * kPm;


    }


    private static long nChooseK(int n, int k) {
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator *= n - i;
            denominator *= i + 1;
        }
        return numerator / denominator;
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
