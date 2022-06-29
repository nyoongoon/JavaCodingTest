package DP;

import java.util.Scanner;

public class QuitJob_icote_ans {  // 정답 풀이.
    static int n;
    static int[] arrT;
    static int[] arrP;
    static int[] cache; //중복 접근 차단

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        n = stdIn.nextInt();

        arrT = new int[n];
        arrP = new int[n];
        cache = new int[n];

        for(int i = 0; i<n; i++){
            arrT[i] = stdIn.nextInt();
            arrP[i] = stdIn.nextInt();
        }

        // dp를 위한 점화식 => 현재 값을 선택 or 선택 x i의 최대값 max(i)
        // => 1. 현재 값의 최대값 선택하기 => 현재 값의 t를 더한 값(다음 진행될 값)의 최대값 + 현재 값의 p
        // => 2. 현재값을 제외한 값의 최댓값 => 다음 인덱스(바로 옆 값)의 최댓값
        // max(i) = (max(arrT[i]) + arrP[i], max(i+1));


        System.out.println(solve(0));

    }

    public static int solve(int day){

        if(day > n){
            return Integer.MIN_VALUE;
        }else if(day == n){
            return 0;
        }else{
            if(cache[day] != 0){
                return cache[day]; // dp 저장용
            }
            int answer =  Math.max(solve(day+1), solve(day+arrT[day]) + arrP[day]);
            cache[day] = answer;
            return answer;
        }
    }
}
