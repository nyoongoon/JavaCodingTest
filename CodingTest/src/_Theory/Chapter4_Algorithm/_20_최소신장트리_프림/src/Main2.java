package _Theory.Chapter4_Algorithm._20_최소신장트리_프림.src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 프림 알고리즘
public class Main2 {

    public static int prim(int[][] data, int v, int e) {
        int weightSum = 0;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            List<Edge> edges = graph.get(data[i][0]);
            Edge edge = new Edge(data[i][1], data[i][2]);
            edges.add(edge);
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        //임의의 시작노드 // 첫번째 임의의 노드 방문시 가중치값 들지 않는다는 것 주의
        priorityQueue.add(new Edge(1, 0));
        int cnt = 0; // 연결된 간선 수
        while (!priorityQueue.isEmpty()) {
            Edge curEdge = priorityQueue.poll();
            cnt += 1; // 왜 방문 체크하지 않고 먼저 더함..?
            if (visited[curEdge.to]) {
                continue;
            }
            visited[curEdge.to] = true;
            weightSum += curEdge.weight; // 첫번째 임의의 노드 방문시 가중치값 들지 않는다는 것 주의 (처음 접근 시 가중치 0으로 생성함)

//            cnt += 1;
//            if (cnt == v - 1) // 왜 간선 == 노드수 -1 이 아님?
            if (cnt == v) {
                break;
            }

            List<Edge> edges = graph.get(curEdge.to);
            for (Edge edge : edges) {
//                if(visited[edge.to]){ // 어차피 위에서 방문 체크 하는데 여기서 하면 중복 하닌가..?
//                    continue;
//                }
                priorityQueue.add(edge);
            }
        }


        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(prim(graph, v, e));
    }

    /**
     * Node와 Edge 헷갈리지 말자
     * 아래는 둘 다 Edge
     * to, weight 두 요소
     * to, from, weight 세 요소
     */
    public static class Edge {
        int to;
        //        int from;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
//            this.from = from;
            this.weight = weight;
        }
    }
}
