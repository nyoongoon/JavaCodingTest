package Base_Algorithm;

public class TotalAmountOfWater_ans_18_3_5 {
    public static int solution(int[] height) {
        if(height == null || height.length == 0){ // 예외처리 항상 하는게 좋음
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0 ;
        int rightMax = 0;
        int result = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    result += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];

                }else{
                    result += rightMax - height[right];
                }
                right--;
            }
        }


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
