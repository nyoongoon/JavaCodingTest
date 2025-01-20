package _2_Java_Algo_Interview._2_배열;

import java.util.PriorityQueue;

/**
 * 시각화 작업으로 쉽게 풀 수 있음
 */
public class _6_주식을_사고팔기_가장_좋은_시점_책풀이 {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices){
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }

        return max;
    }
}
