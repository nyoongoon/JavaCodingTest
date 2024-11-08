package _0_Theory.Chapter4_Algorithm._21_최소신장트리_연습문제.src;// Practice1
// 2250년, 인류는 지구 뿐 아니라 여러 행성을 다니며 살고 있다.
// 이 행성 간을 빨리 오가기 위해 새롭게 터널을 구축하려 한다.

// 행성은 (x, y, z) 좌표로 주어진다.
// 행성1: (x1, y1, z1), 행성2: (x2, y2, z2)
// 이 때 행성간 터널 연결 비용은 min(|x1-x2|, |y1-y2|, |z1-z2|) 로 계산한다.

// n 개의 행성 사이를 n-1 개의 터널로 연결하는데 드는 최소 비용을 구하는 프로그램을 작성하세요.

// 입출력 예시
// 입력:
// data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}}
// 출력: 4


import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    static int[] parents;

    /**
     * 정렬을 해야지 가중치 마이너스 상황에서 최소값을 뽑는다..?!!
     * 엥 그럼 정렬 안하고.. abs()로 구하면 안됨? -> 된다 ! 하지만 이중 포문 비효율적!
     * -> 애초에 최소 가중치 간선만 간선으로 생성한다면 효율적이게 된다
     * -> 정렬하여 앞뒤 노드의 가중치만 계산한다면 최소 가중치들만 뽑게 되는 것임 !!!
     */
    public static int solution(int[][] data) {
        parents = new int[data.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        /**
         * 이렇게 해도 정답은 나옴 -> 이중 for문 때문에 비효율적
         * -> 정렬하여 최소 간선만 만들기로 효율화 가능
         */
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length; j++) {
//                if (i != j) {
//                    pq.add(new Edge(i, j, Math.abs(data[i][0] - data[j][0])));
//                }
//            }
//        }
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length; j++) {
//                if (i != j) {
//                    pq.add(new Edge(i, j, Math.abs(data[i][1] - data[j][1])));
//                }
//            }
//        }
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length; j++) {
//                if (i != j) {
//                    pq.add(new Edge(i, j, Math.abs(data[i][2] - data[j][2])));
//                }
//            }
//        }

        Arrays.sort(data, (x, y) -> x[0] - y[0]); // 정렬하여 최소 가중치 간선만 생성하여 효율적
        for (int i = 0; i < data.length - 1; i++) {
            pq.add(new Edge(i, i + 1, Math.abs(data[i][0] - data[i + 1][0])));
        }
        Arrays.sort(data, (x, y) -> x[1] - y[1]);
        for (int i = 0; i < data.length - 1; i++) {
            pq.add(new Edge(i, i + 1, Math.abs(data[i][1] - data[i + 1][1])));
        }
        Arrays.sort(data, (x, y) -> x[2] - y[2]);
        for (int i = 0; i < data.length - 1; i++) {
            pq.add(new Edge(i, i + 1, Math.abs(data[i][2] - data[i + 1][2])));
        }


        int weightSum = 0;

        while (!pq.isEmpty()) {
            Edge polled = pq.poll();

            if (find(polled.from) != find(polled.to)) {
                union(polled.from, polled.to);
                weightSum += polled.weight;
            }
        }

        return weightSum;
    }

    public static int find(int target) {
        if (target == parents[target]) {
            return target;
        }
        return parents[target] = find(parents[target]);
    }

    public static void union(int a, int b) {
        int resultA = find(a);
        int resultB = find(b);

        parents[resultA] = resultB;
    }


    public static void main(String[] args) {
        // Test code
        int[][] data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}};
        System.out.println(solution(data));
    }

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
}
