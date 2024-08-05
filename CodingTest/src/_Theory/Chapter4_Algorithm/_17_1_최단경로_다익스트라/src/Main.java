package _Theory.Chapter4_Algorithm._17_1_최단경로_다익스트라.src;// 알고리즘 - 최단 경로 알고리즘
// 다익스트라 기본 구현


import java.util.ArrayList;

public class Main {

    public static void dijkstra(int v, int[][] data, int start) {
        //그래프 만들기
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < data.length; i++) {
            int nodeIdx = data[i][0];
            Node node = new Node(data[i][1], data[i][2]);
            graph.get(nodeIdx).add(node);
        }

        //방문 배열 생성
        boolean[] visited = new boolean[v + 1];
        //가중치 dp배열 생성
        int[] dp = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 시작 지점의 가중치 값은 0
        dp[start] = 0;

        for (int i = 0; i < v; i++) { //노드 개수 만큼 반복한다
            int curIdx = 0;
            int minValue = Integer.MAX_VALUE;

            for (int j = 1; j < v + 1; j++) { //방문 안한 곳 중 최소 가중치값 노드 위치 찾기
                if (!visited[j] && minValue > dp[j]) {
                    minValue = dp[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true; //방문처리

            for (Node node : graph.get(curIdx)) { //방문한 노드의 인접노드들 순회하며 dp값 업데이트 -> min(인접노드의 dp값, 현재노드의 가중치값 + 현재노드와 인접노드와의 가중치값)
                if (dp[node.nextNode] > dp[curIdx] + node.weight) {
                    dp[node.nextNode] = dp[curIdx] + node.weight;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dp[i] + " ");
            }

        }
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
