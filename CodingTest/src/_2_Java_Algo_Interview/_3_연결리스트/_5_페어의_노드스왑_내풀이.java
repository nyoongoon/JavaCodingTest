package _2_Java_Algo_Interview._3_연결리스트;

public class _5_페어의_노드스왑_내풀이 {
    public static void main(String[] args) {
        swapPairs(null);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode next = swapPairs(cur.next.next);
        cur.next.next = cur;
        ListNode tmp = cur.next;
        cur.next = next;
        return tmp;
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
