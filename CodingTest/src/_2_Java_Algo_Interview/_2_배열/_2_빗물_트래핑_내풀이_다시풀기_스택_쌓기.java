package _2_Java_Algo_Interview._2_배열;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2_빗물_트래핑_내풀이_다시풀기_스택_쌓기 {
    public static void main(String[] args) {
        trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public static int trap(int[] height) {
        Deque<Integer> stk = new ArrayDeque<>();
        int volume = 0;
        for(int i = 0; i<height.length; i++){
            while(!stk.isEmpty() && height[stk.peek()] < height[i]){
                int top = stk.pop();
                while(!stk.isEmpty() && height[stk.peek()] == height[top]){ //해설엔 이부분 없는데 그럴러면 같은 높이가 연달아 나오지 않아야 가능?
                    top = stk.pop();
                }
                if(stk.isEmpty()){
                    break;
                }
                int len = i - stk.peek() - 1; //같은 높이가 연달아 나오지 않아야 가능?
                int min = Math.min(height[i], height[stk.peek()]);
                volume += (min - height[top]) * len;
            }
            stk.push(i);
        }
        return volume;
    }
}


