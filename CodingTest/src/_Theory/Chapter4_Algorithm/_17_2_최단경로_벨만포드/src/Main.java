package _Theory.Chapter4_Algorithm._17_2_최단경로_벨만포드.src;// 알고리즘 - 최단 경로 알고리즘
// 벨만-포드

public class Main {
    public static void bellmanFord(int v, int e, int[][] data, int start) {
        Edge[] edges = new Edge[e + 1];
        for (int i = 0; i < data.length; i++) {
            edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }
        int[] dist = new int[v + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        boolean isMinus = false;
        for (int i = 0; i < v + 1; i++) { // v + 1번 돌리기
            for (int j = 0; j < edges.length; j++) {
                Edge curEdge = edges[j];
                if (dist[curEdge.to] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[curEdge.from] > dist[curEdge.to] + curEdge.weight) {
                    dist[curEdge.from] = dist[curEdge.to] + curEdge.weight;
                    if (i == v) {
                        isMinus = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }

    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
