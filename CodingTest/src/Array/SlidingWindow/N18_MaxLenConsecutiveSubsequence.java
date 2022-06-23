package Array.SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N18_MaxLenConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Queue<Integer> startIdxQueue = new LinkedList<>(); //0에서 1이 되는 순간 기억=>queue로 저장
        Queue<Integer> kRetrieveQueue = new LinkedList<>(); // k 회수할때 k로 한꺼번에 (이중for문x)
        int n = stdIn.nextInt();
        int[] arr = new int[n];

        int k = stdIn.nextInt(); //0을 -1로 바꿔서 연결해줄 수 있다.

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        int lt = 0;
        int rt = 0; // rt를 늘려가다 0을 만났는데 k<=1 인 경우에 prevStartIdx꺼내기.
        int maxLen = 0;
        int curLen = 0;
        //int prevStartIdx = 0;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 1 && (i == 0 || arr[i-1] == 0)){ //i-1 때문에 에러날지도
                startIdxQueue.add(i); // 후보가 될 수 있는 startIdx queue에 넣음

            }
        }

        int startIdx = startIdxQueue.poll();

        while(rt<arr.length){

            if(arr[rt] == 1){

                rt++;

            }else{ //arr[rt] == 0
                if(k>0){
                    k--;
                    arr[rt] = -1;
                    rt++;

                }else{
                    //0을 마주쳤는데 k가 더이상 없는 경우 길이 저장.
                    int endIdx = rt-1;

                    curLen = endIdx - startIdx + 1;
                    maxLen = Math.max(maxLen, curLen);
                    //k회수
                    startIdx = startIdxQueue.poll();
                    while(lt<startIdx){ //k회수 부분 queue로 대체하기.
                        if(arr[lt] == -1){
                            k++;
                        }
                        lt++;
                    }
                }

            }
        }
        System.out.println(maxLen); //런타임 에러 !!!
    }
}
