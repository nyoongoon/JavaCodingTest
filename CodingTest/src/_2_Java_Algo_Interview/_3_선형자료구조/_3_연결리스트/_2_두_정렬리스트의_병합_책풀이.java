package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

/**
 * 연결리스트 재귀로 풀음
 * --> 큰 값을 뒤로 보내기
 */
public class _2_두_정렬리스트의_병합_책풀이 {
    public static void main(String[] args) {
        mergeTwoLists(null, null);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
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
