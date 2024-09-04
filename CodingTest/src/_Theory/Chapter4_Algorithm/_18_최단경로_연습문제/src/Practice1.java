package _Theory.Chapter4_Algorithm._18_최단경로_연습문제.src;// Practice1
// 2차원 배열 data 에 그래프 데이터가 주어졌다.
// 무방향이고 간선에 가중치 값이 있는 그래프이다.
// 1번 정점에서 N 번 정점으로 최단 경로로 이동하려고 하는데,
// 두 정점을 경유해서 가려고 한다.
// 1번 점점에서 출발하여 두 정점을 경유하여 N 번 정점으로 가는 최단 경로를 구하세요.

// 입출력 예시)
// 입력 data: {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}}
// 출력: 7


import java.util.ArrayList;

public class Practice1 {

    /**
     * start -> via1 & via1 -> via2 & via2 -> n
     * start -> via2 & via2 -> via1 & via1 -> n
     * -> 다익스트라 세 번 씩 두 상황을 비교
     */
    public static int solution(int[][] data, int v, int via1, int via2, int start, int n) {
        int result1 = 0;
        result1 += dijkstra(data, start, via1);
        result1 += dijkstra(data, via1, via2);
        result1 += dijkstra(data, via2, n);

        int result2 = 0;
        result2 += dijkstra(data, start, via1);
        result2 += dijkstra(data, via1, via2);
        result2 += dijkstra(data, via2, n);

        return Math.min(result1, result2);
    }


    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}};
        int v = 4;
        int via1 = 2;
        int via2 = 3;
        int start = 1;
        int n = 4;
        System.out.println(solution(data, v, via1, via2, start, n));
    }

    public static int dijkstra(int[][] data, int start, int end) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < data.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <data.length; i++) {
            Node node = new Node(data[i][1], data[i][2]);
            graph.get(data[i][0]).add(node);
        }

        boolean[] visited = new boolean[data.length + 1];
        int[] dist = new int[data.length + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        // loop 마다 방문하지 않은 최소 거리 노드로 초기화
        Node curNode;
        for (int i = 0; i < data.length; i++) {

            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 1; j < dist.length; j++) {
                if(!visited[j] && minValue > dist[j]){
                    minValue = dist[j];
                    minIdx = j;
                }
            }

            if(minValue == Integer.MAX_VALUE){
                break; //
            }
            visited[minIdx] = true;

            ArrayList<Node> nodes = graph.get(minIdx);
            for(Node node : nodes){
                if(dist[node.to] > dist[minIdx] + node.weight){
                    dist[node.to] = dist[minIdx] + node.weight;
                }
            }
        }

        return dist[end];
    }

    public static class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
