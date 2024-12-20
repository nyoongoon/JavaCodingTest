package _0_Theory.Chapter4_Algorithm._17_1_최단경로_다익스트라.src;// 다익스트라 우선순위 큐 사용


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main2 {
    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < data.length; i++) {
            Node node = new Node(data[i][1], data[i][2]);
            graph.get(data[i][0]).add(node);
        }

        int[] dp = new int[v + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (dp[curNode.nextNode] < curNode.weight) {
                continue;
            }

            ArrayList<Node> nodes = graph.get(curNode.nextNode);
            for (Node node : nodes) {
                if (dp[node.nextNode] > curNode.weight + node.weight) {
                    dp[node.nextNode] = curNode.weight + node.weight;
                    pq.add(node);
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
