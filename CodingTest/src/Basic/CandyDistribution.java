package Basic;

public class CandyDistribution {
    public static int solution(int[] height) {
        int result = 0;
        int[] candy = new int[height.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }

        for (int i = 0; i < height.length; i++) {
            if(i+1<height.length && height[i]<height[i+1]) {
                candy[i + 1] = candy[i] + 1;
            }
            int tmpIdx = i;
            if(tmpIdx-1>=0 && height[tmpIdx-1]>height[tmpIdx]){  // 작은 경우 -> 이전 값 순회

                while(tmpIdx-1>=0 && height[tmpIdx-1]>height[tmpIdx]){
                    if(candy[tmpIdx-1] <= candy[tmpIdx]){
                        candy[tmpIdx-1] = candy[tmpIdx] + 1;
                    }
                    tmpIdx--;
                }

            }
        }

        for (int i = 0; i < candy.length; i++) {
            System.out.print(candy[i] + " ");

            result += candy[i];
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution(height));

        height = new int[]{1,2, 3};
        System.out.println(solution(height));

        height = new int[]{1,3,5,3,1,3,5,7,5,3,1,0};
        System.out.println(solution(height));
    }
}
