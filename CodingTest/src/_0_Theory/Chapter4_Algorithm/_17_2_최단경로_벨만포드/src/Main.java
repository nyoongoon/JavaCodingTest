package _0_Theory.Chapter4_Algorithm._17_2_최단경로_벨만포드.src;// 알고리즘 - 최단 경로 알고리즘
// 벨만-포드

public class Main {
    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellmanFord(int v, int e, int[][] data, int start) {
        Edge[] edges = new Edge[e];
        for (int i = 0; i < data.length; i++) {
            edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        int[] dist = new int[v + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        boolean isMinus = false;
        // v번(노드개수+1) * edge 개수로 이중for문 순회
        for (int i = 0; i < v + 1; i++) { // v-1번 순회시 최소값 만들어짐. v번 일 때 값 업데이트 되면 음수 사이클이 있다는 것
            for (int j = 0; j < edges.length; j++) { //edge에 상관없이 차례대로 비교

                //to에 대한 값을 업데이트 할 것이므로 이곳에선 from을 걸러내야하는 것을 주의
                if (dist[edges[j].from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[edges[j].to] > dist[edges[j].from] + edges[j].weight) {
                    dist[edges[j].to] = dist[edges[j].from] + edges[j].weight;
                    if (i == v) {
                        isMinus = true;
                    }
                }
            }
        }

        System.out.println("isMinus : " + isMinus);
        for (int i = 0; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF ");
            }else{
                System.out.print(dist[i] + " ");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }
}