package _0_Theory.Chapter4_Algorithm._18_최단경로_연습문제.src;// Practice3
// n 개의 도시와, 한 도시에서 출발하여 다른 도시에 도착하는 m 개의 버스가 있다.
// 각 버스는 한 번 사용할 때 필요한 비용이 있다.
// 모든 도시의 쌍 (A, B) 에 대해서 도시 A 에서 B 로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
// 갈수 없는 경로는 0을 출력하세요.

// 입출력 예시)
// 입력 busInfo: {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2}, {3, 4, 1}, {3, 5, 1},
//              {4, 5, 3}, {3, 5, 10}, {3, 1, 8}, {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}}
// 출력:
//    0     2     3     1     4
//   12     0    15     2     5
//    8     5     0     1     1
//   10     7    13     0     3
//    7     4    10     6     0

public class Practice3 {

    static final int INF = 1000000000;
    static int[][] dist;

    public static void solution(int city, int bus, int[][] busInfo) {
        dist = new int[city + 1][city + 1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }

            }
        }

        for (int i = 0; i < busInfo.length; i++) {
            int to = busInfo[i][0];
            int from = busInfo[i][1];
            int weight = busInfo[i][2];
            dist[to][from] = Math.min(weight, dist[to][from]);
        }

        for (int k = 1; k < city + 1; k++) {
            for (int i = 1; i < city + 1; i++) {
                for (int j = 1; j < city + 1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int v) {

    }

    public static void main(String[] args) {
        // Test code
        int city = 5;
        int bus = 14;
        int[][] busInfo = {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2}, {3, 4, 1}, {3, 5, 1},
                {4, 5, 3}, {3, 5, 10}, {3, 1, 8}, {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}};
        solution(city, bus, busInfo);
    }
}
