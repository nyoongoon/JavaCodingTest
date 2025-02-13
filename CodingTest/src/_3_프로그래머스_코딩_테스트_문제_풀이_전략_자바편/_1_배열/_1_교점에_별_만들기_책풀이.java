package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.*;

/**
 * 암기 포인트
 * 1. Set 에서의 동등 비교 -> equals & hashCode
 * 2. 나누어 떨어지지 않는 수 비교 -> 분모 분자 각각 체크 (나눠보기 전에) //주로 틀린 곳
 * 3. 큰 수 long 처리 -> long denominator = (long)a*d - (long)b*c; //이런경우 (long)(a*d)하면 틀림 주의! --> (long)a * d에서 a가 long으로 변환되면, d도 자동으로 long으로 변환된 후 곱셈이 수행됩니다.
 * 4. 배열 <-> 좌표 변환 공식 암기 --> x = x - minX, y = maxY - y;
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
        public String[] solution(int[][] line) {
            List<Point> list = getPoints(line);

            Point maxPoint = getMaxPoint(list);
            Point minPoint = getMinPoint(list);

            int hight = (int) (maxPoint.y - minPoint.y) + 1;
            int width = (int) (maxPoint.x - minPoint.x) + 1;

            // System.out.println("hight == " + hight);
            // System.out.println("width == " + width);

            char[][] chars = new char[hight][width];
            for (char[] row : chars) {
                Arrays.fill(row, '.');
            }
            /**
             * Y 좌표 변환
             * java
             * 복사
             * 편집
             * int y = (int) (maxPoint.y - p.y);
             * 여기서는 maxPoint.y에서 현재 p.y 값을 빼줍니다.
             *
             * 왜냐하면 좌표 평면과 배열의 행(y) 인덱스는 반대로 되어 있기 때문입니다.
             *
             * 좌표계에서는 y 값이 클수록 위쪽.
             * 배열에서는 인덱스가 작을수록 위쪽.
             * 예를 들어 maxPoint.y = 5이고 p.y = 3이라면:
             *
             * ini
             * 복사
             * 편집
             * y = 5 - 3 = 2
             * 이렇게 하면 y 좌표를 배열의 인덱스로 올바르게 변환할 수 있습니다.
             */
            for (Point p : list) {
                int x = (int) (p.x - minPoint.x); // 이부분 잘 이해 안감!
                // (p.y -maxPoint.y)의 상황의 역 (*-1)
                int y = (int) (maxPoint.y - p.y);

                chars[y][x] = '*';
            }

            String[] result = new String[chars.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = new String(chars[i]); //암기
            }

            return result;
        }

        public Point getMaxPoint(List<Point> list) {
            long maxX = Long.MIN_VALUE;
            long maxY = Long.MIN_VALUE;
            for (Point p : list) {
                maxX = Math.max(maxX, p.x);
                maxY = Math.max(maxY, p.y);
            }
            return new Point(maxX, maxY);
        }

        public Point getMinPoint(List<Point> list) {
            long minX = Long.MAX_VALUE;
            ;
            long minY = Long.MAX_VALUE;
            for (Point p : list) {
                minX = Math.min(minX, p.x);
                minY = Math.min(minY, p.y);
            }
            return new Point(minX, minY);
        }

        public List<Point> getPoints(int[][] line) {
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < line.length; j++) {
                    if (i == j) continue;
                    int a = line[i][0];
                    int b = line[i][1];
                    int e = line[i][2];
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];

                    long denominator = (long) a * d - (long) b * c;
                    if (denominator == 0) {
                        continue;
                    }
                    long numerator1 = (long) b * f - (long) e * d;
                    long numerator2 = (long) e * c - (long) a * f;

                    if (numerator1 % denominator != 0 || numerator2 % denominator != 0) {
                        continue;
                    }
                    long x = numerator1 / denominator;
                    long y = numerator2 / denominator;
                    list.add(new Point(x, y));
                }
            }
            return list;
        }

        class Point {
            long x;
            long y;

            Point(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
