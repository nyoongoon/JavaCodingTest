package Array;

import java.util.Scanner;

public class N17_SumOfConsecutiveNumber { //정답 맞춤 !!!
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // n입력으로 양의 정수 n이 입력되면 2개 이상 연속된 자연수의 합으로 n을 표현하는 가짓수 출력
        int n = stdIn.nextInt();
        int lt = 1; //처음 연산 값 대기
        int rt = 2; //처음 연산 값 대기
        int sum = 1;
        int cnt = 0;

        //while(rt <= n && lt<rt){ // 범위가 맘에 안듬..
        while(rt <= (n/2+2) && lt<rt){  // rt > (n/2+2) 이면 무조건 n값 초과(후위증 연산자 때문에 n/2+2) && lt<rt로 2개 이상 자연수 체크
            if(sum <= n){
                sum += rt++; // 자연수가 곧 배열 인덱스 개념
            }else{
                sum -= lt++;
            }

            if(sum == n) cnt++;
        }

        System.out.println(cnt);
    }

}
