package _2_Java_Algo_Interview._3_연결리스트;

public class _2_두_정렬리스트의_병합_내풀이 {
    public static void main(String[] args) {
        mergeTwoLists(null, null);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        // ListNode node1 = list1;
        // ListNode node2 = list2;
        // 역으로 구성하기?  -> 메모리를 더 먹기만할듯?
        ListNode head = null;
        //헤드만 먼저 구하기..
        System.out.println(list1);
        System.out.println(list2);
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode curNode = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        while (list1 != null) {
            curNode.next = list1;
            list1 = list1.next;
            curNode = curNode.next;
        }
        while (list2 != null) {
            curNode.next = list2;
            list2 = list2.next;
            curNode = curNode.next;
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
