package Array.SlidingWindow;

import java.util.Scanner;

public class N15_MaxSales {
    public static void main(String[] args){
        //슬라이딩 윈도우 문제 !!!
        //나는 O(n * k)가 나오게 됐지만
        // 슬라이딩 윈도우를 통해서 O(n)으로 풀 수 있음 !

        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] sales = new int [n];
        int k = stdIn.nextInt();

        for(int i = 0; i<sales.length; i++){
            sales[i] = stdIn.nextInt();
        }

        int max = Integer.MIN_VALUE;

        //int sumIdx=0;

        for(int i = 0; i<sales.length-(k-1); i++){ //투포인터가 배열 인덱스 넘지 않게 주의
            int sale = 0;
            int sumIdx = i;
            for(int j = 0; j<k; j++){
                sale += sales[sumIdx++];
            }

            if(max < sale){
                max = sale;
            }
        }

        System.out.println(max); // 타임 초과 ... ! ㅠㅠ

    }
}
