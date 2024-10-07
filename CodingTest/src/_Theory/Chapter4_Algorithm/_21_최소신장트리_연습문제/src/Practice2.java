package _Theory.Chapter4_Algorithm._21_최소신장트리_연습문제.src;// Practice2
// V 개의 건물과 E 개의 도로로 구성된 도시가 있다.
// 도로는 양방향이고 연결된 도로는 유지하는데 비용이 든다.

// 새롭게 도시 계획을 개편하며 기존의 도시를 두 개의 도시로 분할해서 관리하고자 한다.
// 도시에는 하나 이상의 건물이 있어야 하고,
// 도시 내의 임의의 두 건물은 도로를 통해 이동 가능해야 한다.
// 두 건물 간 도로가 직접 연결이 되지 않고 다른 건물을 통해서 이동해도 가능하다.
// 새롭게 개편하는 도시 계획에 따라 구성했을 때 최소한의 도로 유지비 비용 계산 프로그램을 작성하세요.

// 입출력 예시
// 입력:
// v: 7
// e: 12
// data: {{1, 2, 3}, {1, 3, 2}, {1, 6, 2}, {2, 5, 2},
//        {3, 2, 1}, {3, 4, 4}, {4, 5, 3}, {5, 1, 5},
//        {6, 4, 1}, {6, 5, 3}, {6, 7, 4}, {7, 3, 6}}
// 출력: 8


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Practice2 {

    public static void solution(int v, int e, int[][] data) {
        List<Edge>[] graph = new List[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < data.length; i++) {
            graph[data[i][0]].add(new Edge(data[i][1], data[i][2]));
            graph[data[i][1]].add(new Edge(data[i][0], data[i][2]));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Edge(1, 0));
        int weightSum = 0;
        int maxWeight = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            Edge poll = pq.poll();
            if(visited[poll.to]){
                continue;
            }
            visited[poll.to] = true;
            weightSum += poll.weight;
            maxWeight = Math.max(maxWeight, poll.weight);

            List<Edge> edges = graph[poll.to];
            for (Edge edge : edges) {
                pq.add(edge);
            }
        }

        System.out.println(weightSum - maxWeight);
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 12;
        int[][] data = {{1, 2, 3}, {1, 3, 2}, {1, 6, 2}, {2, 5, 2},
                {3, 2, 1}, {3, 4, 4}, {4, 5, 3}, {5, 1, 5},
                {6, 4, 1}, {6, 5, 3}, {6, 7, 4}, {7, 3, 6}};
        solution(v, e, data);
    }

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
