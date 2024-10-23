package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 최단 경로? 최소 신장 트리?
public class Practice5 {

    public static int solution(int n, int m, int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            int from = data[i][0];
            int to = data[i][1];
            int upDown = data[i][2];
            graph.get(from).add(new Edge(to, upDown));
            graph.get(to).add(new Edge(from, upDown));
        }


        int worst = (int) Math.pow(getWorst(graph, n), 2);
        int best = (int) Math.pow(getBest(graph, n), 2);;


        return worst - best;
    }

    private static int getWorst(List<List<Edge>> graph, int n) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> worstPq = new PriorityQueue<>((x, y) -> x.upDown - y.upDown);
        worstPq.add(new Edge(1, 1));

        int cnt = 0;
        int weightSum = 0;
        int uptimes = 0;
        while (!worstPq.isEmpty()) {
            Edge polled = worstPq.poll();
            if (visited[polled.to]) {
                continue;
            }
            visited[polled.to] = true;

            if (polled.upDown == 1) {
                uptimes = 1;
            } else {
                uptimes = (int) Math.pow(uptimes, 2);
                weightSum += uptimes;
            }
            cnt += 1;
            if (cnt == n) {
                break;
            }

            List<Edge> edges = graph.get(polled.to);
            for (Edge edge : edges) {
                worstPq.add(edge);
            }
        }
        return weightSum;
    }

    private static int getBest(List<List<Edge>> graph, int n) {
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> worstPq = new PriorityQueue<>((x, y) -> y.upDown = x.upDown);
        worstPq.add(new Edge(1, 1));

        int cnt = 0;
        int weightSum = 0;
        int uptimes = 0;
        while (!worstPq.isEmpty()) {
            Edge polled = worstPq.poll();
            if (visited[polled.to]) {
                continue;
            }
            visited[polled.to] = true;

            if (polled.upDown == 1) {
                uptimes = 1;
            } else {
                uptimes = (int) Math.pow(uptimes, 2);
                weightSum += uptimes;
            }
            cnt += 1;
            if (cnt == n) {
                break;
            }

            List<Edge> edges = graph.get(polled.to);
            for (Edge edge : edges) {
                worstPq.add(edge);
            }
        }
        return weightSum;
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
        int upTimes;

        public Edge(int to, int upDown) {
            this.to = to;
            this.upDown = upDown;
        }
    }
}
