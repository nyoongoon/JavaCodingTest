package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.*;

// 1. line을 n^2 비교? -> 1000의 n^2은 시간복잡도 가능 (10000부터 안됨)
// 2. 어떻게 그리지? 상하좌우 최대값?
// x키,y밸류 해시에 저장하고
// x최대 - x최소 & y최대 -y최소
// 동등 비교 쉽게 어떻게 하지?  -> * 그릴때
// 일단 가로 길이 너무 긴 것 같음 현재
// --> 틀린 주된 이유, 숫자형에 대해 미숙 long, double ..

/**
 * numerator % denominator != 0 --> 정수 판단
 */
public class _1_교점에_별_만들기_내풀이 { // 틀림
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
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        Set<Coordinate> set = new HashSet<>();

        public String[] solution(int[][] line) {

            List<String> list = new ArrayList<>();

            putXy(line);


            for (long i = maxY; i >= minY; i--) {

                StringBuilder sb = new StringBuilder();

                for (long j = minX; j <= maxX; j++) {
                    // System.out.println("x, y == " + j + "," + i);
                    Coordinate co = new Coordinate(j, i);
                    if (set.contains(co)) {
                        sb.append("*");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }

            // for(String str : list){
            //     System.out.println(str);
            // }

            return list.toArray(new String[0]);
        }

        public void putXy(int[][] line) {
            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < line.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int a = line[i][0];
                    int b = line[i][1];
                    int e = line[i][2];
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];


                    // if(a*d-d*c == 0){
                    // continue;
                    // }


                    // long 분모 = a*d - b*c;
                    // long 분자X = b*f - e*d;
                    // long 분자Y = e*c - a*f;

                    // if (분모 == 0) continue; // 0으로 나누는 경우 방지

                    // if (분자X % 분모 != 0) continue; // X가 정수가 되는지 확인
                    // if (분자Y % 분모 != 0) continue; // Y가 정수가 되는지 확인


                    //여기가 일차로 틀림!
                    long denominator = (long) a * d - (long) b * c;
                    if (denominator == 0) continue;
                    //여기서 이차로 틀림 (각각을 형변환 후 계산)
                    long numeratorX = (long) b * f - (long) e * d;
                    long numeratorY = (long) e * c - (long) a * f;

                    if (numeratorX % denominator != 0 || numeratorY % denominator != 0) continue;

                    long x = numeratorX / denominator;
                    long y = numeratorY / denominator;

                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);

                    set.add(new Coordinate(x, y));

                }
            }

        }

        class Coordinate {
            long x;
            long y;

            Coordinate(long x, long y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                Coordinate other = (Coordinate) o;
                if (this.x == other.x && this.y == other.y) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

    }
}
