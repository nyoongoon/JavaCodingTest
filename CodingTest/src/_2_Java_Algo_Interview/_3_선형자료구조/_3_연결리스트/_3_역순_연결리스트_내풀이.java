package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _3_역순_연결리스트_내풀이 {
    public static void main(String[] args) {
        reverseList(null);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curNode = head;
        ListNode newNode = null;
        while (curNode != null) {
            newNode = new ListNode(curNode.val, newNode);
            curNode = curNode.next;
        }

        return newNode;
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
