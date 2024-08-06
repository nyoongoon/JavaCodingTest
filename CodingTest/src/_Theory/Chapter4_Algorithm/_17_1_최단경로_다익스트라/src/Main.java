package _Theory.Chapter4_Algorithm._17_1_최단경로_다익스트라.src;// 알고리즘 - 최단 경로 알고리즘
// 다익스트라 기본 구현


import java.util.ArrayList;

public class Main {
    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < data.length; i++) {
            Node node = new Node(data[i][1], data[i][2]);
            graph.get(data[i][0]).add(node);
        }

        boolean[] visited = new boolean[v + 1];
        int[] dp = new int[v + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[start] = 0;

        for (int i = 0; i < v; i++) {
            int minValue = Integer.MAX_VALUE;
            int curIdx = start;
            for (int j = 1; j < v + 1; j++) {
                if (!visited[j] && minValue > dp[j]) {
                    minValue = dp[j];
                    curIdx = j;
                }
            }

            if (minValue == Integer.MAX_VALUE) {
                break;
            }

            visited[curIdx] = true;

            for (Node node : graph.get(curIdx)) {
                if (dp[node.nextNode] > dp[curIdx] + node.weight) {
                    dp[node.nextNode] = dp[curIdx] + node.weight;
                }
            }
        }


        for (int j = 1; j < dp.length; j++) {
            if (dp[j] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dp[j] + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }

    public static class Node {
        int nextNode;
        int weight;

        public Node(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }
}
