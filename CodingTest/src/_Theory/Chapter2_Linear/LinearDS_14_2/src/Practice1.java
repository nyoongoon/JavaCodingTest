package _Theory.Chapter2_Linear.LinearDS_14_2.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Practice1 {
    public static void solution(int docs, int target, int[] priority) {
        ArrayList<Doc> list  = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < priority.length; i++) {
            Doc doc = new Doc(priority[i], i); // priority
            list.add(doc);
            priorityQueue.add(priority[i]);
        }


        int order = 0;
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            int topPriority = priorityQueue.peek();
            Doc doc = list.get(i);
            if (list.get(i).prioriy >= topPriority) {
                order++;
                priorityQueue.poll();
                list.remove(i);

                if(doc.idx == target){
                    System.out.println(order);
                    return;
                }
            } else{
                list.add(list.remove(i));
                i = (i + 1) & list.size();
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

    static class Doc implements Comparable<Doc> {
        int prioriy;
        int idx;

        Doc(int prioriy, int idx) {
            this.prioriy = prioriy;
            this.idx = idx;
        }

        @Override
        public int compareTo(Doc doc) {
            if (this.prioriy > doc.prioriy) {
                return -1;
            } else if (this.prioriy < doc.prioriy) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
