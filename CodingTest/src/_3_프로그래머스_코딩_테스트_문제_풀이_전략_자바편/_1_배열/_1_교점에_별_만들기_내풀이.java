package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1. line을 n^2 비교? -> 1000의 n^2은 시간복잡도 가능 (10000부터 안됨)
// 2. 어떻게 그리지? 상하좌우 최대값?
// x키,y밸류 해시에 저장하고
// x최대 - x최소 & y최대 -y최소
// 동등 비교 쉽게 어떻게 하지?  -> * 그릴때
// 일단 가로 길이 너무 긴 것 같음 현재
// * 엣지케이스만 비교 더 해보면 풀린 듯!
public class _1_교점에_별_만들기_내풀이 {
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
    static class Solution {
        class Coordinate {
            int x;
            int y;
            Coordinate(int x, int y){
                this.x = x;
                this.y = y;
            }
            @Override
            public boolean equals(Object o){
                Coordinate other = (Coordinate) o;
                if(this.x == other.x && this.y == other.y){
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
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        Set<Coordinate> set = new HashSet<>();

        public String[] solution(int[][] line) {
            List<String> list = new ArrayList<>();

            putXy(line);


            for(int i = maxY; i>=minY; i--){

                StringBuilder sb = new StringBuilder();
                // sb.append("\"");

                for(int j = minX; j<=maxX; j++){
                    // System.out.println("x, y == " + j + "," + i);
                    Coordinate co = new Coordinate(j, i);
                    if(set.contains(co)){
                        sb.append("*");
                    }else{
                        sb.append(".");
                    }
                }
                // sb.append("\"");
                list.add(sb.toString());
            }

            // for(String str : list){
            //     System.out.println(str);
            // }

            return list.toArray(new String[0]);
        }

        public void putXy(int[][] line){
            for(int i = 0; i< line.length; i++){
                for(int j = 0; j<line.length; j++){
                    if(i == j ){
                        continue;
                    }
                    int a = line[i][0];
                    int b = line[i][1];
                    int e = line[i][2];
                    int c = line[j][0];
                    int d = line[j][1];
                    int f = line[j][2];


                    if(a*d-d*c == 0){
                        continue;
                    }



                    int 분모 = a*d - b*c;
                    int 분자X = b*f - e*d;
                    int 분자Y = e*c - a*f;

                    if (분모 == 0) continue; // 0으로 나누는 경우 방지

                    if (분자X % 분모 != 0) continue; // X가 정수가 되는지 확인
                    if (분자Y % 분모 != 0) continue; // Y가 정수가 되는지 확인

                    int x = 분자X / 분모;
                    int y = 분자Y / 분모;
                    // int x = (int) doubleX;
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);

                    // int y = (int) doubleY;

                    // System.out.println("x, y == " + x + ", " + y);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                    Coordinate co = new Coordinate(x, y);
                    set.add(co);
                }
            }

        }

    }
}
