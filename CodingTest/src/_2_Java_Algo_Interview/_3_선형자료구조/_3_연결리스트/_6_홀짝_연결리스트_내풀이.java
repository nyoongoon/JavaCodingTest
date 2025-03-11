package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

public class _6_홀짝_연결리스트_내풀이 {
    public static void main(String[] args) {
        oddEvenList(null);
    }
    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode curNode = head;
        ListNode evenHead = curNode.next;
        int order = 1;
        while(curNode != null){
            if(order%2 != 0 && (curNode.next == null || curNode.next.next == null)){
                curNode.next = evenHead;
                break;
            }
            ListNode next = curNode.next;
            curNode.next = curNode.next.next; // 전체 짝수인경우 홀수 마지막 여기서 null 저장됨
            curNode = next;
            order++;
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
