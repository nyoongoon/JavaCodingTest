package _2_Java_Algo_Interview._2_배열;

import java.util.ArrayList;

public class _2_빗물_트래핑_내풀이 { //틀림
    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        if(height.length < 2){
            return 0;
        }

        ArrayList<Integer> points = getPoints(height);

        mergePoints(height, points);

        return countRain(height, points);
    }

    public static void mergePoints(int[] height, ArrayList<Integer> points){
        for(int i = 1; i<points.size()-1; i++){
            int beforeIdx = points.get(i-1);
            int idx = points.get(i);
            int afterIdx = points.get(i+1);
            if(height[beforeIdx] > height[idx] && height[idx] < height[afterIdx]){
                points.remove(i);
            }
        }
    }

    public static ArrayList<Integer> getPoints(int[] height){
        ArrayList<Integer> list = new ArrayList<>();

        int startIdx = -1;
        for(int i =0; i<height.length; i++){
            if(height[i] > 0){
                startIdx = i;
                break;
            }
        }

        int endIdx = -1;
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] > 0){
                endIdx = i;
                break;
            }
        }

        for(int i = startIdx + 1; i< endIdx; i++){
            if(i > 0 && i < height.length-1 && height[i - 1] < height[i] && height[i] > height[i+1]) {
                list.add(i);
            }
        }
        list.add(0, startIdx);
        list.add(endIdx);
        return list;
    }

    public static int countRain(int[] height, ArrayList<Integer> points){
        int sum = 0;
        for(int i = 0; i< points.size()-1; i++){
            int beforeIdx = points.get(i);
            int afterIdx = points.get(i+1);

            int min = Math.min(height[beforeIdx], height[afterIdx]);
            // System.out.println("beforeIdx == " + beforeIdx);
            // System.out.println("afterIdx == " + afterIdx);
            // System.out.println("min == " + min);

            for(int j = beforeIdx + 1; j < afterIdx; j++){
                if(min >= height[j]){
                    System.out.println("idx == " + j);
                    System.out.println("min - height[j] == " + (min - height[j]));
                    sum += min - height[j];
                }

            }

        }
        return sum;
    }
}
