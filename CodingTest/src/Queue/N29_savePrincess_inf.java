package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N29_savePrincess_inf { // 강의 해설 !!! => 큐 사용 => FIFO
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; 1<=n; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i = 1; i<k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1){
                answer = queue.poll();
            }
        }

        System.out.println(answer);
    }
}
