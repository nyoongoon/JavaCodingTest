package _Theory.Chapter2_Linear.LinearDS_14_2.src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Practice2_ans {
    public static void solution(int[] nums) {
        List<String> list = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];

            if (stk.size() == 0 || stk.peek() < target) {

                stk.push(n++);
                while (stk.peek() < target) {
                    stk.push(n++);
                    list.add("+");
                }
                stk.pop();
                list.add("-");

            } else if (stk.peek() == target) {
                stk.pop();
                list.add("-");
            } else { //stk.peek() > target
                System.out.println("NO");
                return;
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1}; // + + + + - - + + - + + - - - - -
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4}; //현자숫자보다 작은숫자 (3)이 나와서 3보다 작은수가 나올때까지ㅂ 뺄수 없음..
        solution(nums);
    }
}
