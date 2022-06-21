package Array;

import java.util.Scanner;

public class N15_MaxSales_inf {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] sales = new int [n];
        int k = stdIn.nextInt();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<sales.length; i++){
            sales[i] = stdIn.nextInt();
        }

        //k까지 미리 합하기
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += sales[i];
        }
        max = Math.max(max, sum);
        //System.out.println("0~2" + sum);

        for(int i = k; i<sales.length; i++){
            sum += sales[i];
            sum -= sales[i-k];
            // if(Math.max(tmp, max)) max = tmp; return이 boolean이 아니라, 큰 값 리턴 임.
            max = Math.max(max, sum);
        }

        System.out.println (max);
    }
}
