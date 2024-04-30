package _Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2_ans {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int n, int[][] switches) {
        ArrayList<Room>[][] graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int[] arr : switches) {
            graph[arr[0] - 1][arr[1] - 1].add(new Room(arr[2] - 1, arr[3] - 1));
        }

        boolean[][] lights = new boolean[n][n];
        lights[0][0] = true;

        return bfs(n, lights, graph) + 1; //1,1에 대한 라이트
    }

    public static int bfs(int n, boolean[][] lights, ArrayList<Room>[][] graph) {
        int result = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<Room> queue = new LinkedList<>();
        queue.add(new Room(0, 0));


        while (!queue.isEmpty()) {
            Room nowRoom = queue.poll();

            if (nowRoom.i < 0 || nowRoom.i >= n || nowRoom.j < 0 || nowRoom.j >= n) {
                continue;
            }

            if (!lights[nowRoom.i][nowRoom.j]) { //불이 켜져 있어야함.
                continue;
            }
            if (visited[nowRoom.i][nowRoom.j]) { //처음 방문해야함
                continue;
            }
            visited[nowRoom.i][nowRoom.j] = true;

            // 불 키기 -> 그래프
            for (Room room : graph[nowRoom.i][nowRoom.j]) {
                // 불이 꺼진 것만 킨다.

                if (!lights[room.i][room.j]) {
                    lights[room.i][room.j] = true;
                    result++;
                }
            }

            // 방 이동하기 -> 상하좌우
            for (int[] move : moves) {
                int nextI = nowRoom.i + move[0];
                int nextJ = nowRoom.j + move[1];

                queue.add(new Room(nextI, nextJ));
            }
        }

        System.out.println("result == " + result);
        // 0이 아니면 추가로 bfs 돌려서 접근 가능해진 방의 불을 추가로 킨다.. --> visited배열 초기화
        return result == 0 ? 0 : bfs(n, lights, graph) + result;
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
        int i;
        int j;

        public Room(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
