package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * numerator % denominator != 0 --> 정수 판단
 */
public class _1_교점에_별_만들기_내풀이_다시풀이 { // 틀림
    public static void main(String[] args) {
        int[] arr1 = {1, 0};
        int[] arr2 = {1, 0};
        Set<int[]> set = new HashSet<>();
        set.add(arr1);
        set.add(arr2);
        System.out.println(set.size());

//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//        Solution s = new Solution();
//        s.solution(line);
    }

    class Solution {
        class Point{
            long x;
            long y;
            Point(long x, long y){
                this.x = x;
                this.y = y;
            }
            @Override
            public boolean equals(Object o){
                Point p = (Point) o;
                if(this.x == p.x && this.y == p.y){
                    return true;
                }else{
                    return false;
                }
            }
            @Override
            public int hashCode(){
                return 1;
            }
        }

        Set<Point> set = new HashSet<>();
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        public String[] solution(int[][] line) {
            List<String> list = new ArrayList<>();
            putXy(line);

            for(long i = maxY; i >= minY; i--){
                StringBuilder sb = new StringBuilder();
                for(long j = minX; j<= maxX; j++){

                    if(set.contains(new Point(j, i))){
                        sb.append("*");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }

            return list.toArray(new String[0]);
        }

        void putXy(int[][] line){
            for(int i = 0; i<line.length; i++){
                for(int j = 0; j<line.length; j++){
                    if(i == j){
                        continue;
                    }

                    int a = line[i][0];
                    int b = line[i][1];
                    int e = line[i][2];
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];

                    long denominator = (long)a*d - (long)b*c;
                    if(denominator == 0) continue;

                    long numeratorX = (long) b*f - (long) e*d;
                    long numeratorY = (long) e*c - (long) a*f;

                    if(numeratorX%denominator != 0 || numeratorY % denominator != 0){
                        continue;
                    }

                    long x = numeratorX / denominator;
                    long y = numeratorY / denominator;
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                    set.add(new Point(x, y));
                }
            }
        }
    }
}
