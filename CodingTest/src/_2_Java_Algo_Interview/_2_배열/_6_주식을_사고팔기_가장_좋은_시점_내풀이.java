package _2_Java_Algo_Interview._2_배열;

import java.util.PriorityQueue;

public class _6_주식을_사고팔기_가장_좋은_시점_내풀이 {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        // 596172
        // 5296142
        // 우선순위큐에 idx 넣기
        // startidx >= endIdx 인 경우 peek()하여 max 분기
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>((x, y) -> prices[x] - prices[y]);
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>((x, y) -> prices[y] - prices[x]);

        for(int i = 0; i<prices.length; i++){
            pqAsc.add(i);
            pqDesc.add(i);
        }

        int leftIdx = pqAsc.poll();
        int rightIdx = pqDesc.poll();
        while(!pqAsc.isEmpty() && !pqDesc.isEmpty()){
            if(leftIdx < rightIdx){
                break;
            } else {
                // todo 마지막까지 가며 ㄴ안됨
                if(prices[rightIdx]-prices[pqAsc.peek()] < prices[pqDesc.peek()] - prices[leftIdx]){
                    System.out.println("rightIdx == " + rightIdx);
                    rightIdx = pqDesc.poll();
                }else{
                    leftIdx = pqAsc.poll();
                    System.out.println("leftIdx == " + leftIdx);
                }
            }
        }

        System.out.println("leftIdx == " + leftIdx);
        System.out.println("rightIdx == " + rightIdx);


        return leftIdx >= rightIdx ? 0 : prices[rightIdx] - prices[leftIdx];

    }
}
