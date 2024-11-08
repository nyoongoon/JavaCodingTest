package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.List;

/**
 * 틀렸던 문제 -> dfs 상하좌우 호출 순서에 따라 결과가 달라짐...
 */
public class Practice2_re {
    static int lightCnt = 0;
    //    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int n, int[][] switches) {


        Room[][] rooms = new Room[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                rooms[i][j] = new Room();
            }
        }
        System.out.println("turnOn  -> " + 1 + ", " + 1);
        rooms[1][1].hasLight = true;
        lightCnt++;

        for (int i = 0; i < switches.length; i++) {
            int row = switches[i][0];
            int col = switches[i][1];
            int[] target = {switches[i][2], switches[i][3]};
            rooms[row][col].tunrOnList.add(target);
        }

        // 특정 상황에서만 visted가 초기화 필요...
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                dfs(new boolean[n + 1][n + 1], rooms, 1, 1);
            }
        }


        return lightCnt;
    }

    public static void dfs(boolean[][] visited, Room[][] rooms, int row, int col) {
        if (row < 1 || row >= rooms.length || col < 1 || col >= rooms[row].length) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        if (!rooms[row][col].hasLight) {
            return;
        }

        System.out.println("room -> " + row + ", " + col);


        visited[row][col] = true;
        List<int[]> turnOnList = rooms[row][col].tunrOnList;
        turnOn(rooms, turnOnList);

        for (int i = 0; i < moves.length; i++) {
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            dfs(visited, rooms, nextRow, nextCol);
        }
    }

    public static void turnOn(Room[][] rooms, List<int[]> turnOnList) {
        for (int[] location : turnOnList) {

            Room room = rooms[location[0]][location[1]];
            if (!room.hasLight) {
                System.out.println("turnOn  -> " + location[0] + ", " + location[1]);
                room.hasLight = true;
                lightCnt++;
            }
        }
    }


    public static void main(String[] args) {
        // Test code
        int[][] switches = {
                {1, 1, 1, 2},
                {2, 1, 2, 2},
                {1, 1, 1, 3},
                {2, 3, 3, 1},
                {1, 3, 1, 2},
                {1, 3, 2, 1}};
        System.out.println(solution(3, switches));  // 5
    }

    public static class Room {
        boolean hasLight = false;
        List<int[]> tunrOnList = new ArrayList<>();
    }

}
