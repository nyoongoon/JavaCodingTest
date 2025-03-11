package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _3_역순_연결리스트_책풀이_반복문 {
    public static void main(String[] args) {
        reverseList(null);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
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
