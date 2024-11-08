package _0_Theory.Chapter2_Linear._14_선형자료구조_연습문제_2.src;

import java.util.LinkedList;
import java.util.Stack;

public class Practice2 {
    public static void solution(int[] nums) {
        LinkedList<String> strs = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        // 뒤집어서 스택에 넣음
        // 현재 숫자보다 작은 숫자가 나오면
        // 그 숫자보다 작은수가 나올때까지 뺀다
        // 작은수가 peek되면 현재 수를 넣는다..
        // 다 넣었으면 순서대로 뺸다.
        int i = nums.length - 1;
        stk.push(nums[i]);
        strs.addFirst("-");
        i--;

        while (i != -1) {
//            System.out.println(i);
            if (stk.isEmpty()) {
                System.out.println("NO");
                return;
            }

            if (stk.peek() < nums[i]) {
                stk.push(nums[i]);
                strs.addFirst("-");
//                System.out.println("-");
                i--;
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > nums[i]) {
                stk.pop();
                strs.addFirst("+");
//                System.out.println("+");
            }
        }

        while(!stk.isEmpty()){
            stk.pop();
            strs.addFirst("+");
        }

        for (String s : strs) {
            System.out.print(s + " ");
        }
        System.out.println();


    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1}; // + + + + - - + + - + + - - - - -
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4}; //현자숫자보다 작은숫자 (3)이 나와서 3보다 작은수가 나올때까지ㅂ 뺄수 없음..
        solution(nums);
    }
}
