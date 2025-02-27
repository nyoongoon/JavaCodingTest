package _3_프로그래머스_코딩_테스트_문제_풀이_전략_자바편._1_배열;

/**
 * - private static final int dy[] = {-1, 0, 0, 1};
 * 방향인덱스가 상-0하-3좌-1우-2 ==> 반대방향인덱스끼리 더하면 3으로 고정하는 스킬 암기!
 * -> i + distance) % 3 == 0 -> 이 조건 안됨 0+0인 경우 틀림
 * -> 3-distance == i -> 이 조건으로 변경
 *
 * - String[] <-> char[][] 변환 과정 암기
 * - char[x][] = str.toCharArray();
 */
public class _3_거리두기_확인하기_책풀이 {
    public static void main(String[] args) {
        System.out.println(0 % 3);
    }
    class Solution {
        // 상 좌 우 하
        int[] dRow = {-1, 0, 0, 1};
        int[] dCol = {0, -1, 1, 0};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            for(int i = 0; i<places.length; i++){
                String[] place = places[i];
                char[][] room = new char[places.length][];
                for(int j = 0; j < room.length; j++){
                    room[j] = place[j].toCharArray();
                }
                if(isDistance(room)){
                    answer[i] = 1;
                }
            }
            return answer;
        }

        public boolean isDistance(char[][] room){
            for(int i = 0; i< room.length; i++){
                for(int j = 0; j<room[i].length; j++){
                    if(room[i][j] == 'P'){
                        if(!isDistance(room, i, j)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean isDistance(char[][] room, int row, int col){
            for(int i = 0; i < 4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                if(nextRow < 0 || nextRow >= room.length || nextCol < 0 || nextCol >= room[0].length){
                    continue;
                }
                char c = room[nextRow][nextCol];
                if(c == 'P'){
                    return false;
                }else if(c == 'X'){
                    continue;
                }else { //c == 'O'
                    if(!isNextDistance(room, nextRow, nextCol, i)){
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isNextDistance(char[][] room, int row, int col, int distance){
            for(int i = 0; i < 4; i++){
                if(i == 3 - distance){ // (i + distance) % 3 == 0 -> 이 조건 안됨 0+0인 경우?
                    continue;
                }
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                if(nextRow < 0 || nextRow >= room.length || nextCol < 0 || nextCol >= room[0].length){
                    continue;
                }
                char c = room[nextRow][nextCol];
                if(c == 'P'){
                    return false;
                }
            }
            return true;
        }
    }
}
