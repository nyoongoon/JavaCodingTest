package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

/**
 * 전가산기 개념으로 carry와 remainder 변수를 사용하여 두 수의 덧셈을 구현
 */
public class _4_두_수의_덧셈_책풀이_전가산기 {
    public static void main(String[] args) {
        addTwoNumbers(null, null);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        int sum, carry = 0, remainder;
        while(l1 != null || l2 != null || carry != 0){
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            node.next = new ListNode(remainder);
            node = node.next;
        }
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
