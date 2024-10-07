package _Theory.Chapter4_Algorithm._21_최소신장트리_연습문제.src.ans;// Practice1
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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 간선 정보부터 만들어야하는 문제임
 * <p>
 * 두 상황의 최소 비교가 필요 간선은 min(|x1-x2|, |y1-y2|, |z1-z2|) 이 되므로
 * -> 각 기준으로 정렬후 계산을 해야 필요한 간선 정보를 얻을 수 있음!
 */
public class Practice1 {
    public static int[] parents;


    public static int solution(int[][] data) {
        parents = new int[data.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        List<Edge> edges = new ArrayList<>();

        Point[] points = new Point[data.length];
        for (int i = 0; i < data.length; i++) {
            points[i] = new Point(i, data[i][0], data[i][1], data[i][2]);
        }

        //정렬이 왜 필요하지?? -> A과 B의 x간선은 최소 x이어야하므로.. x기준하여 계산해서 최소값의 간선이 된다..
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < points.length - 1; i++) {
            edges.add(new Edge(i, i + 1, Math.abs(points[i].x - points[i + 1].x)));
        }

        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < points.length - 1; i++) {
            edges.add(new Edge(i, i + 1, Math.abs(points[i].y - points[i + 1].y)));
        }

        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < points.length - 1; i++) {
            edges.add(new Edge(i, i + 1, Math.abs(points[i].z - points[i + 1].z)));
        }

        Collections.sort(edges);

        int weightSum = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (find(edges.get(i).from) != find(edges.get(i).to)) {
                union(edges.get(i).from, edges.get(i).to);
                weightSum += edges.get(i).weight;
            }
        }

        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}};
        System.out.println(solution(data));
    }

    public static int find(int target) {
        if (parents[target] == target) {
            return target;
        }
        return parents[target] = find(parents[target]);
    }

    public static void union(int a, int b) {
        int resultA = find(a);
        int resultB = find(b);
        parents[resultA] = resultB;
    }

    public static class Point {
        int idx;
        int x;
        int y;
        int z;

        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Edge implements Comparable {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Edge edge = (Edge) o;
            return weight - edge.weight;
        }
    }
}
