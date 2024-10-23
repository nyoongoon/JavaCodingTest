package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src.ans;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 최단 경로? 최소 신장 트리?
public class Practice5_my {

    public static int solution(int n, int m, int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Edge(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Edge(data[i][0], data[i][2]));
        }

        // 정렬 요구사항
        // 최악 경로에서 오르막우선
        // 최적 경로에서 내리막길 우선
        PriorityQueue<Edge> pqAsc = new PriorityQueue<>((x, y) -> x.upDown - y.upDown);
        PriorityQueue<Edge> pqDesc = new PriorityQueue<>((x, y) -> y.upDown - x.upDown);

        int worst = (int) Math.pow(getMstResult(graph, n, pqAsc), 2);
        System.out.println("worst : " + worst);
        int best = (int) Math.pow(getMstResult(graph, n, pqDesc), 2);
        System.out.println("best : " + best);
        return worst - best;
    }

    private static int getMstResult(List<List<Edge>> graph, int n, PriorityQueue<Edge> pq) {
        boolean[] visited = new boolean[n + 1];
        pq.add(new Edge(1, 1));
        int result = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            if (visited[curEdge.to]) {
                continue;
            }
            visited[curEdge.to] = true;
            cnt++;

            if (curEdge.upDown == 0) {
                result += 1;
            }

            if (cnt == n) {
                break;
            }

            List<Edge> edges = graph.get(curEdge.to);
            for (Edge edge : edges) {
                pq.add(edge);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int m = 5;
        int[][] data = {{1, 2, 0}, {1, 4, 0}, {2, 3, 0}, {3, 4, 1}, {4, 2, 1}};

        System.out.println(solution(n, m, data));
    }

    public static class Edge {
        int to;
        int upDown;

        public Edge(int to, int upDown) {
            this.to = to;
            this.upDown = upDown;
        }
    }
}
