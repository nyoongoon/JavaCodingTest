package _2_Java_Algo_Interview._3_연결리스트;

public class _1_팰린드롬_연결리스트_내풀이 {
    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    public static boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        if (size < 2) {
            return true;
        }
        Integer target;
        Boolean result;
        if (size % 2 == 0) {
            target = size / 2 - 1;
            result = isPalindrome(target, head, false);
        } else {
            target = size / 2;
            result = isPalindrome(target, head, true);
        }

        return result;
    }

    public static boolean isPalindrome(int target, ListNode head, boolean isOdd) {
        if (target < 0) {
            return true;
        }
        int count = 0;
        ListNode curNode = head;
        ListNode preNode = curNode;
        ListNode nextNode = curNode.next;

        while (count < target) {
            preNode = curNode;
            curNode = curNode.next;
            nextNode = curNode.next;
            count++;
        }
        if (isOdd) {
            preNode.next = nextNode;
            return isPalindrome(target - 1, head, false);
        } else {
            if (curNode.val == nextNode.val) {
                preNode.next = nextNode.next;
            } else {
                return false;
            }
            return isPalindrome(target - 1, head, false);
        }
    }

    public static int getSize(ListNode head) {
        int size = 0;
        ListNode curNode = head;
        while (true) {
            if (curNode == null) {
                break;
            } else {
                curNode = curNode.next;
                size++;
            }
        }
        return size;
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
