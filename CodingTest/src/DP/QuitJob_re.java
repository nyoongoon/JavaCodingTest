package DP;

import java.util.HashMap;
import java.util.Scanner;

public class QuitJob_re {
    static int[] arrT;
    static int[] arrP;
    static int endDay;
    static int maxPrice = Integer.MIN_VALUE;

    static HashMap<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        endDay = stdIn.nextInt();
        arrT = new int[endDay];
        arrP = new int[endDay];
        for(int i = 0; i<endDay; i++){
            arrT[i] = stdIn.nextInt();
            arrP[i] = stdIn.nextInt();
        }

        recursive(0, 0);
        System.out.println(maxPrice);
    }

    public static void recursive(int targetDay, int price){
        //System.out.println("recursive(int targetDay, int price)");
        //System.out.println("recursive("+targetDay+", "+price+")");

        //if(targetDay > endDay){
        if(targetDay >= endDay){
            //초과한 경우 x
            return;

        }else if(targetDay + arrT[targetDay] <= endDay){// 오늘 진행할
            maxPrice = Math.max(maxPrice, price + arrP[targetDay]);

        }else if(targetDay + arrT[targetDay] > endDay){//오늘 진행
            maxPrice = Math.max(maxPrice, price);

        }

        //함께 진행할 수 있는 날짜, 현재까지의 가격+현재날짜가격
        int withDay = targetDay + arrT[targetDay]; // -1 뺐음.
        recursive(withDay , price + arrP[targetDay]);

        int anotherDay = withDay -1; // targetDay < 함께 진행할 수 업는 날짜 < withDay

        while(anotherDay > targetDay){
            recursive(anotherDay, price); //함께 진행할 수 없는 날짜, 현재 날짜 가격 포함 x 가격
            anotherDay--;
        }

    }
}
