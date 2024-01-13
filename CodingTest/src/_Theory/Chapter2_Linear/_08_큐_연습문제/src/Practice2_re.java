package _Theory.Chapter2_Linear._08_큐_연습문제.src;// Practice2
// 요세푸스 문제
// N과 K가 주어졌을 때 (N, K) 요세푸스 순열을 구하시오.
// N과 K는 N >= K 를 만족하는 양의 정수이다.
// 1부터 N 번까지 N명이 순서대로 원을 이루어 모여 있다.
// 이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
// 모든 사람이 제외될 때까지 반복하며 이 때, 제외되는 순서가 요세푸스 순열이다.

// 예시 입력
// 입력: N = 5, K = 2
// 결과: 2, 4, 1, 5, 3

// 입력: N = 7, K = 3
// 결과: 3, 6, 2, 7, 5, 1, 4


import java.util.LinkedList;
import java.util.Queue;

public class Practice2_re {

    public static Queue<Integer> getJosephusPermutation(int N, int K) {
        Queue<Integer> resultQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int times = 0;

        while (!queue.isEmpty()) {
            int element = queue.poll();
            ++times;
//            if(times == K){ //
//                times = 0;
//                resultQueue.add(element);
//                continue;
//            }
            if(times % K == 0){ // 반복되는 횟수 판단의 경우 나머지 연산을 사용하자 !
                resultQueue.add(element);
                continue;
            }
            queue.add(element);
        }

        return resultQueue;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(getJosephusPermutation(5, 2));
        System.out.println(getJosephusPermutation(7, 3));
    }

}
