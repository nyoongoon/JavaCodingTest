package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1_팰린드롬_연결리스트_책풀이_스택 {
    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> stk = new ArrayDeque<>();
        ListNode curNode = head;
        while (curNode != null) {
            stk.push(curNode.val);
            curNode = curNode.next;
        }
        curNode = head;
        while (curNode != null) {
            if (stk.pop() != curNode.val) {
                return false;
            }
            curNode = curNode.next;
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
