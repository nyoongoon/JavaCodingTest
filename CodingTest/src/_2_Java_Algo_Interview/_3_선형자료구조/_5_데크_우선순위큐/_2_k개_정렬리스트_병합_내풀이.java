package _2_Java_Algo_Interview._3_선형자료구조._5_데크_우선순위큐;

import java.util.PriorityQueue;

public class _2_k개_정렬리스트_병합_내풀이 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = new ListNode(-1, null);
            PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

            for (ListNode list : lists) {
                ListNode curNode = list;
                while (curNode != null) {
                    pq.add(curNode);
                    curNode = curNode.next;
                }
            }
            head.next = pq.peek();
            ListNode curNode;
            while (!pq.isEmpty()) {
                curNode = pq.poll();
                curNode.next = pq.peek();
            }

            return head.next;
        }
    }

    public class ListNode {
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
