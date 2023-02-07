package Base_Algorithm;

public class TotalAmountOfWater_re_18_3_5 {
    public static int solution(int[] height) {
         int lt = 0;
         int ltMax = 0;
         int rt = height.length-1;
         int rtMax = 0;
         int result = 0;

         while(lt<rt){
             if(height[lt] < height[rt]){
                 //ltMax = Math.max(ltMax, height[lt]);
                 if(ltMax <= height[lt]){
                     ltMax = height[lt];
                 }else{
                     result += ltMax - height[lt];
                 }
                 lt++;
             }else{
                 if(rtMax <= height[rt]){
                     rtMax = height[rt];
                 }else{
                     result += rtMax - height[rt];
                 }
                 rt--;


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
