package _2_Java_Algo_Interview._3_선형자료구조._3_연결리스트;

/**
 * 러너 기법
 *
 * - 연결리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법
 * - 한 포인터가 다른 포인터보다 앞서게 하여 병합 지점이나 중간 위치, 길이 등을 판별할 때 유용하게 사용
 * - 2개의 포인터는 빠른러너와 느린 러너로 부르는데
 * - 대게 빠른 러너는 두칸씩 뛰고 느린 러너는 한칸씩 이동함
 * - 빠른 러너가 연결리스트 끝에 도달하면 느린러너는 정확히 연결리스트의 중간 지점을 가리킴
 * - 이 같은 방식으로 중간 위치를 찾아내면 전체 길이를 알 수 있고
 * - 여기서부터 값을 비교하거나 뒤집기를 시도하는 등 여러모로 활용할 수 있어 연결리스트 문제에서 반드시 쓰이는 기법
 *
 */
public class _1_팰린드롬_연결리스트_책풀이_러너 {
    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fastRunner = head;
        ListNode slowRunner = head;
        //fastRunner != null 짝수개 종료 부분
        //fastRunner.next != null 홀수개 종료 부분
        while(fastRunner != null && fastRunner.next != null){

        }
        return false;
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
