package _0_Theory.Chapter4_Algorithm._18_최단경로_연습문제.src;// Practice2
// N 개의 우주가 있고, N 개의 우주 사이에 M 개의 포탈과 W 개의 웜홀이 있다.
// 각 포탈에는 시간 비용이 있고, 포탈을 통해 우주를 이동했을 때 시간이 흘러 있다.
// 웜홀에도 시간 비용이 있는데, 웜홀을 통해 우주를 이동하는 경우는 시간이 거꾸로 흘러 있다.
// N 개의 우주를 포탈과 웜홀을 통해 이동 한다고 했을 때,
// 출발 했을 때보다 시간이 거꾸로 흘러가 있는 경우가 있는지 판별하는 프로그램을 작성하세요.

// 흘러가 있는 경우가 없으면 false, 있으면 true 를 출력하세요.

// 입출력 예시)
// 입력:
// n: 3 / m: 3 / w: 1
// portal: {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}}
// wormhole: {{3, 1, 3}}

// 출력: false


public class Practice2 {

    private static int INF = 100000000;

    public static void solution(int n, int m, int w, int[][] portal, int[][] wormhole) {
        Edge[] edges = new Edge[m + w];
        for (int i = 0; i < portal.length; i++) {
            Edge edge = new Edge(portal[i][0], portal[i][1], portal[i][2]);
            edges[i] = edge;
        }
        for (int i = 0; i < wormhole.length; i++) {
            Edge edge = new Edge(wormhole[i][0], wormhole[i][1], -wormhole[i][2]);
            edges[portal.length + i] = edge;
        }

        int[] dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = INF;
        }

        dist[0] = 0;

        boolean isMinus = false;
        for (int i = 0; i < edges.length + 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                Edge curEdge = edges[j];
                if (curEdge.from == INF) {
                    continue;
                }

                if (dist[curEdge.to] > curEdge.weight + dist[curEdge.from]) {
                    dist[curEdge.to] = curEdge.weight + dist[curEdge.from];
                    if(i == edges.length){
                        isMinus = true;
                    }
                }
            }
        }

        System.out.println(isMinus);
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int m = 3;
        int w = 1;
        int[][] portal = {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}};
        int[][] wormhole = {{3, 1, 3}};

        solution(n, m, w, portal, wormhole);  // false

        n = 3;
        m = 2;
        w = 1;
        portal = new int[][]{{1, 2, 3}, {2, 3, 4}};
        wormhole = new int[][]{{3, 1, 8}};
        solution(n, m, w, portal, wormhole);  // true
    }

    static class Edge {
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
