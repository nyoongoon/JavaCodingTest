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

    public static int recursive(int targetDay, int price){ // 본인을 포함한 재귀인지 아닌지 ... 판단 필요
        if(memo.containsKey(targetDay)){
//            System.out.println("memo.get("+targetDay+") == " + memo.get(targetDay));
//            System.out.println();
            return memo.get(targetDay) ; /// 본인의 값이 포함된 재귀이면 arrP[target]더해야함.
        }


        if(targetDay > endDay){
            //초과한 경우 x
            return Integer.MIN_VALUE;
        }else if(targetDay + arrT[targetDay] == endDay){// 오늘 진행할

            int lastPrice = price + arrP[targetDay];
            //maxPrice = Math.max(maxPrice, price + arrP[targetDay]);
            maxPrice = Math.max(maxPrice, lastPrice);

            memo.put(targetDay, arrP[targetDay]);
//            System.out.println("memo.put(targetDay, lastPrice)");
//            System.out.println("memo.put("+targetDay+", "+arrP[targetDay]+")");
            return lastPrice;
            //return maxPrice;


            //}else if(targetDay + arrT[targetDay] - 1 > endDay){//오늘 진행 ㅌ
        }else if(targetDay + arrT[targetDay] > endDay){//오늘 진행 ㅌ

            int lastPrice = price;
            maxPrice = Math.max(maxPrice, lastPrice);

            memo.put(targetDay, 0);
//            System.out.println("memo.put(targetDay, lastPrice)");
//            System.out.println("memo.put("+targetDay+", "+0+")");
            return lastPrice;
            //return maxPrice;
        }



        // 오늘 진행할 수 있는 경우



        // 해시맵 용 // 현재 노드를 타고 내려갔을 때 얻을 수 있는 최대 갑사.
        int forMapVal = Integer.MIN_VALUE;


        //함께 진행할 수 있는 날짜, 현재까지의 가격+현재날짜가격
        int withDay = targetDay + arrT[targetDay]; // -1 뺐음.
        //recursive(withDay , price + arrP[targetDay]);
        if(memo.containsKey(withDay)){
            forMapVal = Math.max(forMapVal, memo.get(withDay) + arrP[targetDay]); // get으로 뽑았	을 떄 arrP[targetDay]값 더해야 있어야함.
        }else{
            forMapVal = Math.max(forMapVal, recursive(withDay , price + arrP[targetDay]));
        }


        int anotherDay = withDay -1; // targetDay < 함께 진행할 수 업는 날짜 < withDay

        while(anotherDay > targetDay){
            forMapVal = Math.max(forMapVal, recursive(anotherDay, price)); //함께 진행할 수 없는 날짜, 현재 날짜 가격 포함 x 가격
            anotherDay--;
        }

        memo.put(targetDay, forMapVal - price); //현재 단계에서 밑으로 안내려가게 하기. -> 현대 리프노트
//        System.out.println("memo.put(targetDay, forMapVal - price);");
//        System.out.println("memo.put("+targetDay+", "+forMapVal+" - "+price+")");

        return forMapVal; // 다시보기
    }
}
