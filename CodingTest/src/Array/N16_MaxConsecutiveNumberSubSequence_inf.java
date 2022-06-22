package Array;

import java.util.Scanner;

public class N16_MaxConsecutiveNumberSubSequence_inf {
    // 윈도우 슬라이드 => O(n)으로 풀어내기

    // 투포인터 && 윈도우 슬라이드
    // 타겟 값보다 sum이 작거나 같을 때 => rt를 늘리기 (오른쪽값 더하기)
    // 타겟값보다 sum이 클 때 => lt 늘리기. (왼쪽값 뺴기)
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();;
        int m =stdIn.nextInt();

        int[] arr = new int [n];

        for(int i = 0; i<n; i++){
            arr[i] = stdIn.nextInt();
        }

        int lt = 0;
        int rt = 1;
        int sum = arr[0];
        int cnt = 0;

        if(sum == m) cnt++;

        while(rt<arr.length && lt<arr.length){

            if(sum <= m){
                sum += arr[rt++];
            }else{
                sum -= arr[lt++];
            }

            if(sum == m) cnt++;
        }

        System.out.println(cnt);

    }
}
