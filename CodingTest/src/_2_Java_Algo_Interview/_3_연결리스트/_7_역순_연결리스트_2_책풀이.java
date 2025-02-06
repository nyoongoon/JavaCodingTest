package _2_Java_Algo_Interview._3_연결리스트;

public class _7_역순_연결리스트_2_책풀이 {
    public static void main(String[] args) {

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0); // root 만드는 이유?
        root.next = head;
        ListNode start = root; //이거 떄문?

        for(int i = 0; i < left - 1; i++){
            start = start.next;
        }

        ListNode end = start.next;

        for(int i = 0; i < right - left; i++){
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next;
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
