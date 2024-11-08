package _0_Theory.Chapter2_Linear._14_선형자료구조_연습문제_2.src;

import java.util.LinkedList;
import java.util.Queue;

public class Practice1_ans {
    public static void solution(int docs, int target, int[] priority) {
        Queue<Doc> queue = new LinkedList<>();
        for (int i = 0; i < priority.length; i++) {
            queue.add(new Doc(i, priority[i]));
        }

        int result = 1;
        while(true){
            Doc doc = queue.poll();

            Doc[] docArr = queue.stream()
                    .filter(x -> x.priority > doc.priority)
                    .toArray(Doc[]::new);

            if(docArr.length > 0){ // 더 큰게 있음
                queue.add(doc);
            }else{ //뽑은게 가장 큼
                if(doc.idx == target){
                    System.out.println(result);
                    return;
                }
                result++;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
    }

    static class Doc {
        int idx;
        int priority;

        Doc(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
