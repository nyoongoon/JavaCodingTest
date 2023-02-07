package Base_CodingTest.W8;

import java.util.*;
class Week8_1_my {
    public int solution(int[] start, int[] end, int[] price) {
        int answer = 0;
        // ArrayList<Reserve> list = IntStream.range(0, start.length)
        //     .map((x)->{new Reserve(start[x], end[x], price[x]);}).toList();
        ArrayList<Reserve> list = new ArrayList<>();
        for(int i = 0; i<start.length; i++){
            list.add(new Reserve(start[i], end[i], price[i]));
        }

        Collections.sort(list);

        // for(int i = 0; i<list.size(); i++){
        //     System.out.print(list.get(i).end + " ");
        // }

        int lastDpIdx = list.get(list.size()-1).end;
        int[] dp = new int[lastDpIdx + 1];

        for(int i = 0; i<list.size(); i++){
            Reserve cur = list.get(i);
            for(int j = cur.end; j<dp.length; j++){
                if(dp[j] < dp[cur.start] + cur.price){
                    dp[j] = dp[cur.start] + cur.price;
                }
            }
        }


        return dp[dp.length-1];
    }


}
class Reserve implements Comparable<Reserve>{
    int start;
    int end;
    int price;
    Reserve(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }

    @Override
    public int compareTo(Reserve o){
        // if(this.end == o.end){
        //     return o.price - this.price;
        // }
        // return o.end - this.end;
        if(this.end == o.end){
            return this.price - o.price;
        }
        return this.end - o.end;
    }
}