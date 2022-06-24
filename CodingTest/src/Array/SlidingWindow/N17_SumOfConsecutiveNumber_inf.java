package Array.SlidingWindow;

import java.util.Scanner;

public class N17_SumOfConsecutiveNumber_inf {
    // 다른식으로 접근한 정답
    public static void main(String[] args) {
        // 수학적인 방법으로 풀 수 있음
        // => n을 m개 연속된 m개 숫자로 나눔. n에 나눠진 숫자들의 합을 뺐을 때 m으로 나누어 떨어지면 됌
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = 2;
        int cnt = 0;

        while(true){

            int sumOfdivided = 0;

            for(int i = 1; i<=m; i++) sumOfdivided += i;

            if(sumOfdivided > n ) break;

            if((n - sumOfdivided) % m == 0 ) cnt++;

            m++;

        }

        System.out.println(cnt);

    }

}
