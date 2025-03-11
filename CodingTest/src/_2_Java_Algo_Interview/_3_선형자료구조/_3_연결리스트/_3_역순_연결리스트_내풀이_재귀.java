package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _3_역순_연결리스트_내풀이_재귀 {
    public static void main(String[] args) {
        reverseList(null);
    }

    static ListNode newHead = null;
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            newHead = head;
            return head;
        }

        reverseList(head.next);
        ListNode curNode = head;
        curNode.next.next = curNode;
        curNode.next = null;

        return newHead;
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
