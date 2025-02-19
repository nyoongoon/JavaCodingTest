package _2_Java_Algo_Interview._4_스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 배열_빗물 트래핑 문제와 비슷
 * - 현재 인덱스를 계속 스택에 쌓아두다가 이전보다 상승하는 지점에서 현재 온도와 쌓아둔 온도 비교하면서
 * - 더 높다면 스택의 값을 꺼내고 현재 인덱스와 차이를 구하고 현재 인덱스를 스택에 삽입
 */
public class _3_일일온도_책풀이 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }

        return result;
    }
}
