package BaseCorrection;

import java.util.LinkedList;
import java.util.Queue;

public class week2_4_my { // 틀림 (못품)
    public static void main(String[] args) {
//        int[] times = {8, 5, 7, 0, 10, 8, 3, 9, 3, 4, 7, 3, 5, 7, 1, 4, 3, 2, 1, 7, 8, 5, 3, 7, 5, 3, 10, 6, 6, 3, 1, 6, 7, 4, 3, 1, 10, 9, 10, 5, 10, 4, 6, 6, 3, 6, 1, 6, 10, 6, 0, 7, 3, 8, 1, 5, 0, 5, 5, 0, 4, 9, 2, 0, 6, 2, 4, 1, 2, 6, 10, 5, 10, 9, 7, 2, 7, 8, 4, 2, 8, 10, 0, 1, 1, 0, 9, 5, 8, 7, 1, 10, 9, 9, 7, 10, 2, 10, 2, 3, 8, 7, 2, 1, 2, 4, 5, 6, 1, 0, 8, 8, 5, 7, 0, 3, 4, 10, 5, 1, 4, 2, 4, 7, 3, 6, 1, 8, 5, 3, 1, 4, 10, 2, 0, 0, 10, 6, 9, 7, 10, 9, 0, 5, 3, 4, 7, 10, 3, 8, 9, 8, 5, 5, 0, 2, 4, 5, 10, 5, 6, 6, 10, 0, 3, 8, 1, 3, 2, 10, 1, 2, 5, 1, 5, 0, 7, 10, 3, 10, 10, 10, 5, 8, 10, 10, 8, 3, 2, 7, 8, 8, 5, 4, 10, 4, 4, 3, 6, 3, 7, 4, 0, 3, 0, 9, 5, 7, 7, 10, 0, 4, 8, 3, 0, 7, 9, 0, 0, 6, 7, 10, 4, 9, 2, 7, 10, 0, 0, 4, 9, 10, 1, 1, 9, 7, 5, 8, 1, 2, 7, 6, 1, 4, 0, 3, 5, 3, 10, 8, 1, 3, 3, 10, 2, 2, 9, 10, 3, 7, 2, 0, 3, 8, 10, 8, 3, 1, 9, 8, 0, 5, 8, 2, 9, 10, 7, 2, 1, 1, 0, 7, 9, 9, 9, 9, 1, 4, 6, 2, 0, 1, 4, 10, 8, 0, 1, 4, 4, 3, 2, 6, 10, 8, 6, 2, 10, 5, 0, 3, 4, 6, 3, 7, 3, 3, 6, 2, 9, 2, 7, 7, 7, 3, 4, 0, 3, 5, 0, 3, 4, 8, 4, 0, 6, 2, 4, 9, 10, 10, 10, 9, 5, 7, 9, 4, 0, 7, 10, 4, 1, 2, 10, 0, 5, 7, 0, 6, 0, 5, 0, 3, 0, 6, 2, 7, 6, 1, 2, 6, 10, 7, 4, 5, 3, 10, 9, 4, 6, 2, 2, 8, 10, 7, 4, 3, 6, 8, 0, 0, 8, 1, 0, 7, 4, 7, 10, 5, 9, 4, 2, 5, 7, 3, 2, 7, 1, 6, 1, 9, 7, 1, 8, 0, 10, 7, 4, 5, 6, 2, 1, 8, 3, 8, 8, 6, 6, 2, 0, 5, 9, 1, 0, 2, 4, 2, 8, 2, 8, 4, 8, 9, 9, 10, 3, 8, 9, 1, 3, 2, 0, 8, 3, 7, 1, 9, 2, 7, 7, 4, 2, 2, 2, 2, 7, 6, 7, 0, 2, 5, 1, 9, 4, 2, 10, 0, 0, 5, 0, 2, 4, 3, 10, 2, 6, 3, 10, 3, 5, 2, 9, 5, 5, 6, 5, 3, 9, 4, 4, 4, 8, 6, 2, 10, 2, 0, 6, 1, 8, 6, 2, 4, 3, 7, 7, 9, 3, 2, 1, 1, 6, 10, 6, 0, 4, 2, 9, 2, 8, 9, 6, 0, 9, 5, 9, 1, 10, 2, 3, 8, 10, 4, 0, 2, 0, 6, 5, 8, 3, 10, 8, 7, 2, 3, 5, 2, 0, 7, 7, 10, 10, 3, 4, 7, 5, 1, 6, 10, 7, 5, 0, 10, 5, 7, 0, 1, 5, 5, 9, 5, 1, 0, 1, 7, 6, 4, 3, 4, 3, 2, 8, 3, 2, 8, 8, 4, 4, 9, 1, 2, 5, 9, 0, 2, 9, 6, 10, 5, 9, 4, 5, 9, 5, 2, 6, 10, 8, 8, 3, 6, 0, 0, 4, 5, 3, 3, 5, 2, 1, 10, 4, 1, 4, 8, 4, 2, 5, 0, 3, 3, 0, 8, 0, 4, 10, 9, 6, 1, 7, 5, 1, 6, 6, 6, 5, 6, 1, 9, 1, 4, 4, 8, 7, 1, 6, 3, 2, 0, 3, 7, 2, 1, 1, 8, 2, 8, 9, 4, 3, 6, 7, 1, 2, 4, 5, 10, 2, 1, 3, 10, 10, 9, 4, 0, 2, 5, 9, 10, 0, 6, 0, 10, 2, 6, 10, 8, 0, 8, 3, 2, 3, 7, 1, 6, 2, 6, 2, 6, 8, 9, 5, 8, 1, 1, 8, 0, 6, 2, 8, 10, 7, 10, 10, 10, 2, 10, 4, 8, 9, 8, 7, 1, 2, 1, 10, 7, 2, 3, 3, 0, 8, 10, 9, 0, 2, 4, 3, 5, 3, 7, 1, 1, 0, 10, 3, 9, 10, 3, 7, 8, 7, 1, 5, 1, 3, 5, 4, 2, 0, 9, 7, 2, 4, 9, 1, 0, 0, 1, 1, 1, 2, 10, 9, 6, 4, 10, 0, 10, 0, 2, 10, 8, 1, 7, 6, 10, 4, 1, 7, 5, 2, 5, 7, 9, 9, 3, 5, 9, 2, 2, 10, 7, 6, 4, 10, 0, 8, 10, 3, 3, 0, 2, 7, 7, 5, 8, 8, 4, 1, 7, 4, 5, 4, 4, 6, 3, 6, 5, 3, 9, 10, 5, 0, 8, 2, 5, 3, 1, 6, 9, 8, 9, 8, 7, 2, 10, 5, 4, 3, 8, 0, 0, 5, 3, 6, 8, 1, 4, 2, 7, 0, 4, 2, 10, 8, 6, 9, 10, 4, 8, 1, 8, 1, 4, 2, 9, 8, 0, 2, 7, 1, 3, 0, 5, 4, 4, 7, 1, 3, 7, 7, 10, 6, 2, 3, 4, 8, 9, 6, 10, 8, 10, 9, 10, 5, 2, 6, 7, 10, 1, 3, 5, 6, 8, 7, 1, 0, 4, 6, 7, 5, 5, 9, 9, 7, 2, 5, 2, 10, 9, 1, 4, 2, 9, 8, 8, 10, 8, 8, 6, 7, 4, 4, 8, 1, 8, 0, 7, 0, 3, 5, 5, 9, 3, 7, 4, 4, 5, 7, 5, 8, 7, 0, 8, 5, 8, 9, 6, 10, 2, 6, 4, 5, 2, 9, 8, 10, 6, 7, 5};
//        System.out.println(solution(10, 13, times)); //490
        int [] times = new int[]{3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5};
        System.out.println(solution(5, 5, times)); //490
    }


    public static int solution(int delay, int capacity, int[] times) {
        Queue<Integer> queue = new LinkedList<>();
        int nextMsgCommingTime = 0;
        int arrIdx = 0;
        int missing = 0;
        queue.add(times[arrIdx++]); // 넣은 값이 nextMsgCommingTime
        nextMsgCommingTime = times[arrIdx-1];
        queue.poll(); // 처음은 딜레이 없이 실행. //poll() 결과값은 영향 x

        int nowDelay = delay ;

        while (arrIdx < times.length) {
            System.out.println("arrIdx == " + arrIdx);
            System.out.println("nowDelay == " + nowDelay);
            System.out.println("nextMsgCommingTime == " + nextMsgCommingTime);
            if (nowDelay <= 0 && !queue.isEmpty()) {
                System.out.println("queue.poll()"); //
                queue.poll();  // poll() 할 때 딜레이 리셋
                nowDelay = delay;
            }
            if (nextMsgCommingTime <= 0) {
                if (queue.size() < capacity) {
                    System.out.println("queue.add()");
                    queue.add(times[arrIdx++]);
                    if(times[arrIdx-1] == 0){
                        System.out.println("continue");
                        continue;
                    }else{
                        nextMsgCommingTime = times[arrIdx-1];
                    }
                } else {
                    System.out.println("missing++");
                    missing++;
                }
            }
            nextMsgCommingTime--;
            nowDelay--;
            System.out.println();
        }


        return missing;
    }

}
