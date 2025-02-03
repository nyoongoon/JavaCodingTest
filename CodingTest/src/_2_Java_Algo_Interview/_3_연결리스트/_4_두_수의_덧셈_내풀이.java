package _2_Java_Algo_Interview._3_연결리스트;

import java.math.BigInteger;

public class _4_두_수의_덧셈_내풀이 {
    public static void main(String[] args) {

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = toNumber(l1);
        BigInteger num2 = toNumber(l2);
        BigInteger sum = num1.add(num2); //add 메서드
        ListNode resultNode = toListNode(sum);
        return resultNode;
    }
    static BigInteger toNumber(ListNode reversed){
        StringBuilder sb = new StringBuilder();
        while(reversed != null){
            sb.append(reversed.val);
            reversed = reversed.next;
        }
        sb.reverse(); //기억하기
        return new BigInteger(sb.toString()); //생성자 생성
    }
    static ListNode toListNode(BigInteger sum){
        String target = String.valueOf(sum);
        char[] chars = target.toCharArray();

        ListNode curNode = null;
        for(int i = 0 ; i <chars.length; i++){
            curNode = new ListNode(chars[i]-'0', curNode);
        }

        return curNode;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
