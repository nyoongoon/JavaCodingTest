package Array.SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N18_MaxLenConsecutiveSubsequence_re {
    // 재도전 !! => 정답 !!!
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        Queue<Integer> bridgeIdxQueue = new LinkedList<>(); // brige 어디에 심어두었는지 체크
        int n = stdIn.nextInt();
        int[] arr = new int[n];

        int k = stdIn.nextInt(); //0을 -1로 바꿔서 연결해줄 수 있다.

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        int lt = 0;
        int rt = 0; // rt를 늘려가다 0을 만났는데 k<1 인 경우에 bridgeIdx 꺼내기.
        int maxLen = 0;
        int curLen = 0;

        while(rt<arr.length){

            if(arr[rt] != 0){

                rt++;

            }else{ //arr[rt] == 0

                if(k>0){
                    // k를 다 쓸때까지 rt 늘리기.
                    arr[rt] = -1;
                    k--;
                    bridgeIdxQueue.add(rt);

                }else{  //k가 없으면 뒤의 브릿지 하나 빼서 앞에 하나 추가

                    // 0을 만나면 이전까지의 길이 계산
                    curLen = (rt-1) - (lt+1) + 1;
                    maxLen = Math.max(maxLen, curLen);

                    //lt 재조정
                    arr[rt] = -1; //0을 -1로
                    bridgeIdxQueue.add(rt); //rt bridge queue에 저장
                    lt = bridgeIdxQueue.poll(); //새로운 lt는 큐에서 꺼낸 값

                }

            }

        }
        System.out.println(maxLen); // 성공 !!!
    }
}
