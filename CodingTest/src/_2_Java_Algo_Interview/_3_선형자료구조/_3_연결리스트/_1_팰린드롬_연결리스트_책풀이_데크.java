package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

import java.util.Deque;
import java.util.LinkedList;

public class _1_팰린드롬_연결리스트_책풀이_데크 {
    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode curNode = head;
        while(curNode != null){
            deque.push(curNode.val);
            curNode = curNode.next;
        }


        while(!deque.isEmpty() && deque.size() > 1){
            if(deque.pollFirst() != deque.pollLast()){
                return false;
            }
        }
        return true;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
