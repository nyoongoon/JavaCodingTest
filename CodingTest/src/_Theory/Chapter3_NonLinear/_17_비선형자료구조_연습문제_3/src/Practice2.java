package _Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice2 {
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int roomCnt;
    static int maxResult = 0;

    // 방
    // 간선
    // visit 여부 (불키기)
    public static int solution(int n, int[][] switches) {
        roomCnt = n;
        // n이 3이면 3x3 사이즈의 방
        // ㅁ ㅁ ㅁ
        // ㅁ ㅁ ㅁ
        // ㅁ ㅁ ㅁ
        Room[][] rooms = new Room[n + 1][n + 1];
        for (int i = 1; i < rooms.length; i++) {
            for (int j = 1; j < rooms[i].length; j++) {
                rooms[i][j] = new Room(i, j);
            }
        }
        rooms[1][1].canVisit = true;
        maxResult++;


        for (int[] edges : switches) {
            int i = edges[0];
            int j = edges[1];
            rooms[i][j].addLights(edges[2], edges[3]);
        }

        for (int i = 1; i < rooms.length; i++) {
            for (int j = 1; j < rooms[i].length; j++) {
                bfs(rooms, rooms[i][j]);
            }
        }


        return maxResult;
    }


    public static void bfs(Room[][] rooms, Room start) {
        boolean[][] visited = new boolean[rooms.length][rooms.length];
        int result = 0;
        Queue<Room> queue = new LinkedList<>();
        queue.add(start);
        System.out.println("시작방 : " + start.i + ", " + start.j);

        while (!queue.isEmpty()) {
            Room room = queue.poll();
            if (!room.canVisit) {
                continue;
            }
            if (visited[room.i][room.j]) {
                continue;
            }

            // 현재 방 방문
            visited[room.i][room.j] = true;
            System.out.println("방문한 방 [" + room.i + "][" + room.j + "]");

            for (int[] light : room.lights) {
                if (!rooms[light[0]][light[1]].canVisit) {
                    rooms[light[0]][light[1]].canVisit = true;
                    maxResult++;
                }
            }

            for (int[] edge : room.edges) {
                Room nextRoom = rooms[edge[0]][edge[1]];
                queue.add(nextRoom);
            }
        }
//        maxResult = Math.max(maxResult, result);
        System.out.println();
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

    static class Room {
        int i;
        int j;
        List<int[]> edges;
        List<int[]> lights;
        boolean canVisit;

        public Room(int i, int j) {
            this.i = i;
            this.j = j;
            this.canVisit = false;
            edges = new ArrayList<>();
            lights = new ArrayList<>();
            for (int k = 0; k < moves.length; k++) {
                int nextI = i + moves[k][0];
                int nextJ = j + moves[k][1];
                if (nextI >= 1 && nextI <= roomCnt && nextJ >= 1 && nextJ <= roomCnt) {
                    edges.add(new int[]{nextI, nextJ});
                }
            }
        }

        public void addLights(int i, int j) {
            lights.add(new int[]{i, j});
        }

    }
}
