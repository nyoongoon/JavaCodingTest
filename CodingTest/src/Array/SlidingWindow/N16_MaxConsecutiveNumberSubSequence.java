package Array.SlidingWindow;

import java.util.Scanner;

public class N16_MaxConsecutiveNumberSubSequence {
    //최대 연속 부분 수
    public static void main(String[] args){
        //n개로 이루어진 수열
        //연속 부분 수열 합이 특정 숫자 M 몇번 있는가.
        // 윈도우 슬라이드 => 슬라이드 크기 키우면서 움직이면 될 듯
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int[n];
        int m = stdIn.nextInt();
        int subArrCtn = 0;
        int surArrLen = 1;

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        for(int i = 1; i <= arr.length; i++){ // 윈도우 슬라이드 길이 1부터 n까지.
            int curSum = 0;
            for(int j = 0; j<i; j++){ // 초기 sum 구하기
                curSum += arr[j];
            }
            if(curSum == m) subArrCtn++;

            for(int j = 0; j<arr.length-i; j++){
                curSum -= arr[j];
                curSum += arr[j+i]; // 인덱스 범위 초과 주의 !

                if(curSum == m) subArrCtn++;
            }
        }

        System.out.println(subArrCtn); //런타임 에러 !!!
    }
}
