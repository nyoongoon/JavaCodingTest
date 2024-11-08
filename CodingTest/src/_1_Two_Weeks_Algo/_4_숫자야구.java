package _1_Two_Weeks_Algo;
//    4
//    123 1 1
//    356 1 0
//    327 2 0
//    489 0 1

import java.util.Scanner;


public class _4_숫자야구 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] querys = new String[n][3];
        for (int i = 0; i < n; i++) {
            String[] strs = scanner.nextLine().split(" ");
            querys[i][0] = strs[0];
            querys[i][1] = strs[1];
            querys[i][2] = strs[2];
        }
        int result = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    int cnt = 0;
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    for (int l = 0; l < querys.length; l++) {
                        String[] query = querys[l];
                        String target = query[0];
                        int strike = Integer.parseInt(query[1]);
                        int ball = Integer.parseInt(query[2]);
                        if (baseballGame(i, j, k, target, strike, ball)) {
                            cnt += 1;
                        }
                    }
                    if (cnt == querys.length) {
                        result += 1;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean baseballGame(int i, int j, int k, String target, int strike, int ball) {
        int hundred = Character.getNumericValue(target.charAt(0));
        int ten = Character.getNumericValue(target.charAt(1));
        int one = Character.getNumericValue(target.charAt(2));
        int strikeCnt = 0;
        int ballCnt = 0;
//        System.out.println("one");
//        System.out.println(one);


        if (i == hundred) {
            strikeCnt += 1;
        } else if (i == ten || i == one) {
            ballCnt += 1;
        }
        if (j == ten) {
            strikeCnt += 1;
        } else if (j == hundred || j == one) {
            ballCnt += 1;
        }
        if (k == one) {
            strikeCnt += 1;
        } else if (k == hundred || k == ten) {
            ballCnt += 1;
        }

        if (strikeCnt == strike && ballCnt == ball) {
            return true;
        } else {
            return false;
        }
    }
}
