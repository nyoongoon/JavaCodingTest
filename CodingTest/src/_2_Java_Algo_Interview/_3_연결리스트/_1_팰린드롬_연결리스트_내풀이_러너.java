package _2_Java_Algo_Interview._3_연결리스트;

/**
 * 틀림
 */
public class _1_팰린드롬_연결리스트_내풀이_러너 {
    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode curNode = head;
        int size = 0;
        while (curNode != null) {
            curNode = curNode.next;
            size++;
        }
        boolean isOdd = false;
        if (size % 2 != 0) {
            isOdd = true;
        }
        System.out.println("isOdd == " + isOdd);

        ListNode fastRunner = isOdd ? head.next : head;
        // ListNode slowRunner = isOdd ? head.next : head
        ListNode slowRunner = isOdd ? head.next : head;
        ;
        //123
        while (fastRunner != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        System.out.println("slowRunner == " + slowRunner.val);

        ListNode revNode = new ListNode(slowRunner.val);
        ListNode newNode = null;
        slowRunner = slowRunner.next;
        // new->rev
        while (slowRunner != null) {
            newNode = new ListNode(slowRunner.val, revNode);
            slowRunner = slowRunner.next;
            revNode = newNode;
        }


        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

        curNode = head;
        while (newNode != null) {
            if (curNode.val != newNode.val) {
                return false;
            }
            curNode = curNode.next;
            newNode = newNode.next;
        }

        return true;
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


