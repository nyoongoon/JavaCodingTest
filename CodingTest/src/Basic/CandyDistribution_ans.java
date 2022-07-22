package Basic;

public class CandyDistribution_ans {
    public static int solution(int[] ratings) { // 풀이가 독특
       if(ratings == null || ratings.length == 0){
           return 0;
       }

       int result = 1;
       int upCnt = 1; // 커지는 방향
       int donwCnt = 0;
       int peak = 0;
       for(int i = 0; i< ratings.length; i++){
           if(ratings[i] > ratings[i-1]){
               upCnt++;
               peak = upCnt;
               donwCnt = 0;
               result += upCnt;
           }else if(ratings[i] == ratings[i-1]){
               upCnt = 1;
               donwCnt = 0;
               peak = 0;
               result += 1;
           }else{   //작아지는 쪽
               donwCnt++;
               upCnt = 1;
               result += donwCnt;
               if(peak <= donwCnt){
                   result += 1;
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
