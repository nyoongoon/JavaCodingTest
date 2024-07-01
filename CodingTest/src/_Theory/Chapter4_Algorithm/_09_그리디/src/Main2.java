package _Theory.Chapter4_Algorithm._09_그리디.src;// 거스름돈 문제

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void getChangeCoins(int receivedMoney, int price) {
        int[] coins = {500, 100, 50, 10, 5, 1};
        // 500, 100, 50 ,10
//        int cnt = 0;
        int change = receivedMoney - price;

        Map<Integer, Integer> map = new HashMap<>();
        for (int value : coins) {
            if (change >= value) {
                map.put(value, change / value);
                change %= value;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println("coin : " + entry.getKey());
                System.out.println("cnt = " + entry.getValue());
            }
        }
        System.out.println("=========================");

    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
