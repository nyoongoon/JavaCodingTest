package DP;

import java.util.Scanner;

public class MakeOne_icote { // 내 풀이
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        //x 가 주어질 때
        // 5로 나누어 쩔어지면 5로 나눔
        // 3으로 나누어 떨어지면 3으로 나눔
        // 2로 나누어떨어지면 2로 나눈ㅁ
        // x에서 1를 뺀다.
        int x = stdIn.nextInt();
        int cnt = 0;
        int target = 1;
        // 1, 2 ,3 조건 만족할 떄까지 1 빼기 // 틀림 => 거꾸로 풀기
        while(target < x){

            if(target * 5 <= x ){
                target *= 5;
                cnt++;
            }else if(target * 3 <= x){
                target *= 3;
                cnt++;
            }else if(target * 2 <= x){
                target *= 2;
                cnt++;
            }else if(target + 1 <= x){
                target += 1;
                cnt++;
            }


        }




        System.out.println(cnt);
    }
}
