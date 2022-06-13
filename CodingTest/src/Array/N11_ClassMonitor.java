package Array;

import java.util.Scanner;

public class N11_ClassMonitor {
    public static void main(String[] args) {
        //System.out.println("실행");
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();

        int[][] studentTable = new int[n][5];

        int[] studentRank = new int[n];
        for (int i = 0; i < studentTable.length; i++) {
            for (int j = 0; j < 5; j++) {
                studentTable[i][j] = stdIn.nextInt();
            }
        }

        /*for(int i = 0; i<studentTable.length; i++){
            for(int j = 0; j<5; j++){
                System.out.print(studentTable[i][j] + " ");
            }
            System.out.println();
        }*/

        // 학생 중복 테이블 => i는 검사 중인 학생 // j는 i의 검사 받는 학생
        boolean[][] chk = new boolean[n][n];


        for (int i = 0; i < studentTable.length; i++) {

            for (int j = 0; j < 5; j++) {
                //int iStudentClass = studentTable[i][j];

                for (int k = 0; k < studentTable.length; k++) {
                    if (i == k || chk[i][k]) continue;
                    if (studentTable[i][j] == studentTable[k][j]) {
                        studentRank[i]++;
                       /* System.out.print("studentTable[" + i + "][" + j + "] : " + studentTable[i][j] + " ");
                        System.out.println("studentTable[" + k + "][" + j + "] : " + studentTable[k][j]);*/
                        chk[i][k] = true;
                    }

                }
            }

        }

        /*for (int i = 0; i < studentRank.length; i++) {
            System.out.println(studentRank[i]);
        }*/

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < studentRank.length; i++) {
            if (max < studentRank[i]) {
                max = studentRank[i];
                maxIdx = i;
            }
        }

        // 중복 체크를 못했음.
        System.out.println(maxIdx+1);
    }
}