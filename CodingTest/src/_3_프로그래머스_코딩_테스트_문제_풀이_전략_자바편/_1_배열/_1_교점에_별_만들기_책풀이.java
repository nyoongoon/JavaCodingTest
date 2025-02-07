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


    class Solution {
        class Point{
            long x;
            long y;
            Point(long x, long y){
                this.x = x;
                this.y = y;
            }
        }


        public String[] solution(int[][] line) {
            List<Point> list = getPoints(line);

            Point maxPoint = getMaxPoint(list);
            Point minPoint = getMinPoint(list);

            int hight = (int) (maxPoint.y - minPoint.y) + 1;
            int width = (int) (maxPoint.x - minPoint.x) + 1;

            // System.out.println("hight == " + hight);
            // System.out.println("width == " + width);

            char[][] chars = new char[hight][width];
            for(char[] row : chars){
                Arrays.fill(row, '.');
            }

            for(Point p : list){
                int x = (int) (p.x - minPoint.x); // 이부분 잘 이해 안감!
                int y = (int) (maxPoint.y - p.y);

                chars[y][x] = '*';
            }

            String[] result = new String[chars.length];
            for(int i = 0; i<result.length; i++){
                result[i] = new String(chars[i]); //암기
            }

            return result;
        }

        public Point getMaxPoint(List<Point> list){
            long maxX = Long.MIN_VALUE;
            long maxY = Long.MIN_VALUE;
            for(Point p : list){
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY, p.y);
            }
            return new Point(maxX, maxY);
        }

        public Point getMinPoint(List<Point> list){
            long minX = Long.MAX_VALUE;;
            long minY = Long.MAX_VALUE;
            for(Point p : list){
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
            }
            return new Point(minX, minY);
        }

        public List<Point> getPoints(int[][] line){
            List<Point> list = new ArrayList<>();
            for(int i = 0; i<line.length; i++){
                for(int j = 0; j<line.length; j++){
                    if(i == j) continue;
                    int a = line[i][0];
                    int b = line[i][1];
                    int e = line[i][2];
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];

                    long denominator = (long) a*d - (long) b*c;
                    if(denominator == 0){
                        continue;
                    }
                    long numerator1 = (long) b*f - (long) e*d;
                    long numerator2 = (long) e*c - (long) a*f;

                    if(numerator1 % denominator != 0 || numerator2 % denominator != 0){
                        continue;
                    }
                    long x = numerator1 / denominator;
                    long y = numerator2 / denominator;
                    list.add(new Point(x, y));
                }
            }
            return list;
        }
    }
}
