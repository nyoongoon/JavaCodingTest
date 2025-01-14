package _2_Java_Algo_Interview._2_배열;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 어려운 문제 <- 스택으로 풀면 더 어려움
 * 현재가 peek() 보다 높으면 뽑아서 계산하기..
 * 현재가 같거나 낮으면 계속 스택 쌓기..
 */
public class _2_빗물_트래핑_책풀이_스택_쌓기 {
    public static void main(String[] args) {
        trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;

                int waters = Math.min(height[stack.peek()], height[i]) - height[top];
                result += distance * waters;
            }

            stack.push(i);
        }

        return result;
    }
}
