package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _3_역순_연결리스트_책풀이_재귀 {// 재귀로 안보고 풀어보기
    public static void main(String[] args) {
        reverseList(null);
    }
    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public static ListNode reverseList(ListNode node, ListNode prev) {
        if(node == null){
            return prev;
        }

        ListNode nextNode = node.next;
        node.next = prev;

        return reverseList(nextNode, node);
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
