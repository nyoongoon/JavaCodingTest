package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

import java.util.ArrayList;
import java.util.List;

public class _3_거리두기_확인하기_내풀이 {
    public static void main(String[] args) {

    }
    class Solution {
        //동서남북
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int[] solution(String[][] places) {
            List<char[][]> list = new ArrayList<>();

            for(int i = 0; i < 5; i++){
                char[][] chars = new char[5][5];
                for(int j = 0; j < 5; j++){
                    String row = places[i][j];
                    for(int k = 0; k < 5; k++){
                        chars[j][k] = row.charAt(k);
                    }
                }
                list.add(chars);
            }

            int[] answer = new int[5];
            for(int i = 0; i<list.size(); i++){
                char[][] chars = list.get(i);
                int result = check(chars);
                answer[i] = result;
            }

            return answer;
        }

        public int check(char[][] chars){
            for(int i = 0; i < chars.length; i ++){
                for(int j = 0; j< chars[i].length; j++){
                    char c = chars[i][j];
                    if(c == 'P'){
                        boolean[][] visit = new boolean[5][5];
                        boolean result = isSafe(chars, i, j, visit, 0);
                        if(!result){
                            return 0;
                        }
                    }
                }
            }
            return 1;
        }

        public boolean isSafe(char[][] chars, int row, int col, boolean[][] visit, int recurCnt){
            if(recurCnt > 1){
                return true;
            }
            visit[row][col] = true;

            for(int i = 0; i < 4; i++){
                int nextRow = row + direction[i][0];
                int nextCol = col + direction[i][1];

                if(nextRow < 0 || nextRow >= chars.length || nextCol < 0 || nextCol >= chars[0].length || visit[nextRow][nextCol]){
                    continue;
                }

                char nextPlace = chars[nextRow][nextCol];
                // System.out.println("nextRow == " + nextRow + ", nextCol == " + nextCol);
                // System.out.println("nextPlace == " + nextPlace);
                if(nextPlace == 'P'){
                    visit[row][col] = false;
                    return false;
                }else if(nextPlace == 'X'){
                    continue;
                }else{ // 'O'
                    if(!isSafe(chars, nextRow, nextCol, visit, recurCnt + 1)){
                        visit[row][col] = false;
                        return false;
                    }
                }
            }
            visit[row][col] = false;
            return true;
        }
    }
}
