package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

/**
 * 공간복잡도가 odd, even, evenHead 등의 변수들이 n의 크기에 관계없이 항상 일정하게 사용되므로
 * O(1)으로 제약사항 충족함
 */
public class _6_홀짝_연결리스트_책풀이 {
    public static void main(String[] args) {
        oddEvenList(null);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode oven = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            oven.next = even.next;
            even.next = even.next.next;
            oven = oven.next;
            even = even.next;
        }
        oven.next = evenHead;
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
