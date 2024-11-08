package _0_Theory.Chapter4_Algorithm._17_3_최단경로_플로이드워셜.src;// 알고리즘 - 최단 경로 알고리즘
// 플로이드-워셜

public class Main {
    public static int INF = 1_000_000_000;

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        int dist[][] = new int[v + 1][v + 1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        }

        // k를 기준으로 k 경유하기
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[i].length; j++) {
                if(dist[i][j] == INF){
                    System.out.printf("%5s", "INF");
                }else{
                    System.out.printf("%5d", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
