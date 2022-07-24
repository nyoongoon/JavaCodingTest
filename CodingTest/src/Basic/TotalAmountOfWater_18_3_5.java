package Basic;

public class TotalAmountOfWater_18_3_5 {
    public static int solution(int[] height) {

        int startIdx = 0;
        int endIdx = 0;
        int startHeight = 0;

        int result = 0;
        int tmp = 0;
        for (int i = 1; i < height.length; i++) {

            //if( (startHeight <= height[height.length-1]) ||  (height[i-1] < height[i] && height[i] >= height[i+1]) ){ // 마지막 인덱스 처리하기.

            if(height[i-1] < height[i] && height[i] >= height[i+1] ){ // 마지막 인덱스 처리하기. /// 못함 ㅜㅜㅜㅜ



                if(startHeight != 0 && startHeight > height[i]){
                    tmp -= (i - startIdx - 1) * (startHeight - height[i]);
                }

                startIdx = i;
                startHeight = height[i];
                result += tmp;
                tmp = 0;

            }
//            else if(height[i-1] < height[i]){
//                startIdx = i;
//                startHeight = height[i];
//
//            }
            else{
                int nowHeight = height[i];
                if(startHeight - nowHeight > 0){
                    tmp += startHeight - nowHeight;
                }
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
