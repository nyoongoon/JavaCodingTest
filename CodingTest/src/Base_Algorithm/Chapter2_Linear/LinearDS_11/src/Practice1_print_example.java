package Base_Algorithm.Chapter2_Linear.LinearDS_11.src;// Practice1
// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터: 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터: 1 -> 5 -> 2 -> 4 -> 3


import java.util.*;

public class Practice1_print_example {
    public static void reorderData() {
//
//        int[] arr = {1, 2, 3, 4, 5};
//        LinkedList<Integer> addLinkedList = new LinkedList<>();
//        LinkedList<Integer> addLastLinkedList = new LinkedList<>();
//
//
//        for (int i = 0; i < arr.length; i++) {
//            addLinkedList.add(arr[i]);
//            addLinkedList.addF
//            System.out.println(addLinkedList);
//        }
//
//        System.out.println("======================");
//
//        for (int i = 0; i < arr.length; i++) {
//            addLastLinkedList.addLast(arr[i]);
//            System.out.println(addLastLinkedList);
//        }
//
//        System.out.println("addLastDuque.remove() == " + addLastDuque.remove());
//        System.out.println(addLastDuque);


        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.addLast(3);
        deque.addFirst(4);
        System.out.println("DEQUE");
        System.out.println(deque);
        System.out.println("deque.remove() ==> " + deque.remove());
        System.out.println(deque);
        System.out.println("deque.removeFirst() ==> " + deque.removeFirst());
        System.out.println(deque);
        System.out.println("deque.removeLast() ==> " + deque.removeLast());
        System.out.println(deque);
        System.out.println("======================");

        LinkedList<Integer> ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.addLast(3);
        ll.addFirst(4);
        System.out.println("LINKED LIST");
        System.out.println(ll);
        System.out.println("ll.remove() ==> " + ll.remove());
        System.out.println(ll);
        System.out.println("ll.removeFirst() ==> " + ll.removeFirst());
        System.out.println(ll);
        System.out.println("ll.removeLast() ==> " + ll.removeLast());
        System.out.println(ll);
        System.out.println("======================");

        System.out.println("ARRAY LIST");
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
//        al.addLast(); 없음
//        al.addFirst(); 없음
        System.out.println(al);
        System.out.println("al.remove(index or Object)");
        System.out.println("======================");

        System.out.println("STACK");
        Stack<Integer> stk = new Stack<>();
        stk.add(1);
        stk.add(2);
        stk.add(3);
        stk.add(4);
//        stk.addLast(); 없음
//        stk.addFirst(); 없음
        System.out.println(stk);
        System.out.println("stk.pop() ===> " + stk.pop());
        System.out.println(stk);
        System.out.println("======================");

        System.out.println("QUEUE");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        stk.addLast(); 없음
//        stk.addFirst(); 없음
        System.out.println(queue);
        System.out.println("queue.remove() ===> " + queue.remove());
        System.out.println(queue);
    }


    public static void main(String[] args) {
        // Test code

        reorderData();   // 1 -> 5 -> 2 -> 4 -> 3


//        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
//        reorderData(arr2);  // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4

    }
}
