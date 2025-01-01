package _2_Java_Algo_Interview._2_배열;

public class _2_빗물_트래핑_내풀이 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        ArrayList<Integer> points = getPoints(height);
        return countRain(height, points);
    }

    public ArrayList<Integer> getPoints(int[] height){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i< height.length-1; i++){
            if(height[i - 1] < height[i] && height[i] < height[i+1]) {
                list.add(i);
            }
        }
        return list;
    }

    public int countRain(int[] height, ArrayList<Integer> points){
        int sum = 0;
        for(i = 0; i< points.length; i++){
            int point = points.get(i);
            int leftMaxIdx = findLeftMaxIdx(); //인자 다시보기
            int rightMaxIdx = findRightMax();
            int minMax = Math.min(height[leftMaxIdx], height[rightMaxIdx]);

            for(int i = leftMaxIdx + 1; i < rightMaxIdx; i++){ //인덱스 다시보기
                sum += minMax - nums[i];
            }

        }
        return 0;
    }
}
