package _Theory.Chapter4_Algorithm._20_최소신장트리_프림.src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 기존 답안이나, 잘못 설명된 것이 많은 것 같아서 의아한 점은 주석으로 남김
 */
// 프림 알고리즘
public class Main2 {

    public static int prim(int[][] data, int v, int e) {
        int weightSum = 0;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        /**
         * 이부분 틀림 주의 !! -> 간선 정보를 단방향으로 설정해서 틀림
         */
//        for (int i = 0; i < data.length; i++) {
//            List<Node> nodes = graph.get(data[i][0]);
//            Node node = new Node(data[i][1], data[i][2]);
//            nodes.add(node);
//        }
        for (int i = 0; i < e; i++) { //간선 정보 표기할 때 from <-> to 양방향으로 간선 정보 입력 주의!!!
            graph.get(data[i][0]).add(new Edge(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Edge(data[i][0], data[i][2]));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        //임의의 시작노드 // 첫번째 임의의 노드 방문시 가중치값 들지 않는다는 것 주의 !!
        priorityQueue.add(new Edge(1, 0));
        int cnt = 0; // 연결된 간선 수 -> 사실 연결된 간선 수 -1임! (첫 접근 노드에 대한 접근은 간선이 아니므로)

        while (!priorityQueue.isEmpty()) {
            Edge curEdge = priorityQueue.poll();
//            cnt += 1; // 왜 방문 체크하지 않고 먼저 더함..? <-- 이부분 수정 OK !!
            if (visited[curEdge.to]) {
                continue;
            }
            visited[curEdge.to] = true;
            weightSum += curEdge.weight; // 첫번째 임의의 노드 방문시 가중치값 들지 않는다는 것 주의 (처음 접근 시 가중치 0으로 생성함)
            cnt += 1; // 방문 후에 카운트 하는 것이 올바르다!

            /**
             * 이 부분 특히 주의 ->  엄밀히 말해서 cnt는 간선 수가 아니라 간선수 -1 !!
             */
            if (cnt == v) { // 첫 시작 노드는 간선으로 추가하지 말아야하므로 !!!
                break;
            }

            List<Edge> edges = graph.get(curEdge.to);
            for (Edge edge : edges) {
                // 어차피 위에서 방문 체크 하는데 여기서 하면 중복 하닌가..?
//                if (visited[node.to]) {   <-- 이부분 수정 OK !!
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
//    public static class Node {
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
