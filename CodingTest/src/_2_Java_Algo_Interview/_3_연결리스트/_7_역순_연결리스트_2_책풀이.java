package _2_Java_Algo_Interview._3_연결리스트;

/**
 * root 더미 노드 만드는 스킬 기억하기!
 * start를 root로 두고 left - 1번 이동하면 start는 항상 뒤집기 시작 전 노드를 가리킴.
 * 이후 root.next를 반환하면, 첫 번째 노드가 바뀌더라도 정상적으로 처리됨.
 *
 * 로직 - start, end를 정하고 end 다음 노드를 'start앞으로 껴넣는것을 반복'하면서 뒤집는 개념
 */
public class _7_역순_연결리스트_2_책풀이 {
    public static void main(String[] args) {

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0); // root 만드는 이유?
        root.next = head;
        ListNode start = root; //이거 떄문?

        for(int i = 0; i < left - 1; i++){
            start = start.next;
        }

        ListNode end = start.next;

        for(int i = 0; i < right - left; i++){
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next;
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
