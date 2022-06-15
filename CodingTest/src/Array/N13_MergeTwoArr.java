package Array;

import java.util.Scanner;

public class N13_MergeTwoArr {
    public static void main(String[] args) {
        // 세가지 정렬 케이스
        // 1. 크기 비교
        // 2. 1이 비었을 때
        // 3. 2가 비었을 때

        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = stdIn.nextInt(); //첫번째 배열
        }

        int m = stdIn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = stdIn.nextInt(); //두번째 배열
        }

        int[] resultArr = new int[n+m]; //결과 배열

        int idx1 = 0;
        int idx2 = 0;
        int resultArrIdx = 0;

        while ((idx1 < n) && (idx2 < m)) { //작은 수 먼저 넣기
            if(arr1[idx1] < arr2[idx2]){
                resultArr[resultArrIdx++] = arr1[idx1++];
            }else{
                resultArr[resultArrIdx++] = arr2[idx2++];
            }
        }

        while (idx1 < n) { // 남은 수 처리
            resultArr[resultArrIdx++] = arr1[idx1++];
        }

        while (idx2 < m) { // 남은 수 처리
            resultArr[resultArrIdx++] = arr2[idx2++];
        }

        for(int i = 0; i<resultArr.length; i++){
            System.out.print(resultArr[i] + " ");
        }
    }
}
