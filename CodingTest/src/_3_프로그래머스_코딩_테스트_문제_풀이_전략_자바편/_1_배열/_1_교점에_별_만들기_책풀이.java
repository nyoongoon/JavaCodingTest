package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.*;

/**
 * 암기 포인트
 * 1. Set 에서의 동등 비교 -> equals & hashCode
 * 2. 나누어 떨어지지 않는 수 비교 -> 분모 분자 각각 체크 (나눠보기 전에) //주로 틀린 곳
 * 3. 큰 수 long 처리
 */
public class _1_교점에_별_만들기_책풀이 {
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
    public class Solution {
        private class Point {
            public final long x, y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }

        }
        private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
            double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
            double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

            if(x%1 != 0 || y%1 != 0){
                return null;
            }
            return new Point((long) x, (long) y);
        }
        private Point getMininumPoint(List<Point> points){
            long x = Long.MAX_VALUE;
            long y = Long.MAX_VALUE;
            for(Point p : points){
                if(p.x < x) x = p.x;
                if(p.y < y) y = p.y;
            }

            return new Point(x, y);
        }
        private Point getMaximumPoint(List<Point> points){
            long x = Long.MIN_VALUE;
            long y = Long.MIN_VALUE;
            for(Point p : points){
                if(p.x > x) x = p.x;
                if(p.y > y) y = p.y;
            }

            return new Point(x, y);
        }
        public String [] solution(int[][]line){
            List<Point> points = new ArrayList<>();
            for(int i = 0; i< line.length; i++){
                for(int j = i+1; j<line.length; j++){
                    long a1 = line[i][0];
                    long b1 = line[i][1];
                    long c1 = line[i][2];
                    long a2 = line[j][0];
                    long b2 = line[j][1];
                    long c2 = line[j][2];

                    Point intersection = intersection(a1, b1, c1, a2, b2, c2);
                    if(intersection != null){
                        points.add(intersection);
                    }
                }
            }
            Point minPoint = getMininumPoint(points);
            Point maxPoint = getMaximumPoint(points);
            int width = (int) (maxPoint.x - minPoint.x + 1);
            int height = (int) (maxPoint.y - minPoint.y + 1);
            char[][] arr = new char[height][width];
            for(char[] row : arr){
                Arrays.fill(row, '.');
            }

            /**
             * 이제 잘 이해가 안가네 .. 가독성 좋은 코드로 좀 바꾸기..
             */
            for(Point p : points){
                arr[(int) (maxPoint.y - p.y)][(int) (p.x - minPoint.x)] = '*';
            }
            String[] result = new String[height];
            for(int i = 0; i<result.length; i++){
                result[i] = String.valueOf(arr[i]);
            }
            return result;
        }
    }
}
