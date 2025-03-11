package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _5_페어의_노드스왑_책풀이 {
    public static void main(String[] args) {
        swapPairs(null);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null){

            ListNode p = head.next;
            head.next = swapPairs(head.next.next);
            p.next = head;
            return p;
        }

        return head;
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
