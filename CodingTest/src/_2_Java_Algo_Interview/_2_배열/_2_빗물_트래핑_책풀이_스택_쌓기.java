package _2_Java_Algo_Interview._2_배열;

/**
 * 어려운 문제 <- 스택으로 풀면 더 어려움
 */
public class _2_빗물_트래핑_책풀이_스택_쌓기 {
    public static void main(String[] args) {
        trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public static int trap(int[] height) {
        int leftIdx = 0;
        int rightIdx = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;
        while (leftIdx < rightIdx) {
            leftMax = Math.max(leftMax, height[leftIdx]);
            rightMax = Math.max(rightMax, height[rightIdx]);

            if (leftMax <= rightMax) {
                result += leftMax - height[leftIdx];
                leftIdx++;
            } else {
                result += rightMax - height[rightIdx];
                rightIdx--;
            }
        }

        return result;
    }
}
