package DP;

import java.io.IOException;
import java.util.Scanner;

public class QuitJob_teacher {
    static int[] arrT;
    static int[] arrP;
    static int endDay;
    static int[] arrMaxIncome; // 해당 날짜에 일 시작할 경우 얻을 수 있는 최대 수입

    public static void main(String[] args) throws IOException {
        Scanner stdIn = new Scanner(System.in);

        endDay = stdIn.nextInt();
        arrT = new int[endDay];
        arrP = new int[endDay];
        arrMaxIncome = new int[endDay];
        for(int i = 0; i < endDay; i++){
            arrT[i] = stdIn.nextInt();
            arrP[i] = stdIn.nextInt();
            arrMaxIncome[i] = 0;
        }

        updateArrMaxIncome(endDay - 1); // 역으로 계산해야 메모 가능.
        System.out.println(arrMaxIncome[0]);
    }

    public static void updateArrMaxIncome(int idx){
        if (idx < 0) return;

        if (idx + arrT[idx] <= endDay) {
            arrMaxIncome[idx] = arrP[idx];
        }

        for (int i = idx + arrT[idx]; i < endDay; i++){  // 해당 날짜 포함 가능한 값들.
            int tmpMaxIncome = arrP[idx] + arrMaxIncome[i]; // 해당날짜 + 해당날짜 이후 최대값
            arrMaxIncome[idx] = Math.max(tmpMaxIncome, arrMaxIncome[idx]);
        }

        if (idx < endDay - 1){ // 해당 날짜의 최대 값 vs 해당 날짜 +1 의 최대 값.
            arrMaxIncome[idx] = Math.max(arrMaxIncome[idx], arrMaxIncome[idx + 1]);
        }

        updateArrMaxIncome(idx - 1);
    }
}
