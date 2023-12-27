package _Theory.Chapter2_Linear.LinearDS_11.src;// Practice1
// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터: 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터: 1 -> 5 -> 2 -> 4 -> 3


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice1_re {
    public static void reorderData(int[] arr) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> frontList = new LinkedList<>();
        Deque<Integer> backList = new LinkedList<>();
        for (int i = 0; i <= (arr.length / 2); i++) {
//            frontList.addLast(arr[i]); //1,2,3
            frontList.add(arr[i]);
            System.out.println(frontList);
        }
//
//        for (int i = 0; i < frontList.size(); i++) {
//            frontList.poll();
//            System.out.println(frontList);
//        }

//        System.out.println(frontList);

//        for (int i = (arr.length / 2) + 1; i < arr.length; i++) {
//            backList.addLast(arr[i]); // 4,5
//        }

//        for(int i : backList){
//            System.out.println(i);
//        }

        while (!frontList.isEmpty() || !backList.isEmpty()) {
            if(!frontList.isEmpty()){
                queue.add(frontList.removeLast());
            }
            if(!backList.isEmpty()){
                queue.add(backList.removeFirst());
            }
        }


//        while(!queue.isEmpty()){
//            System.out.print(queue.pollLast() + " ");
//        }
        System.out.println();

    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);   // 1 -> 5 -> 2 -> 4 -> 3



        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);  // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4

    }
}
