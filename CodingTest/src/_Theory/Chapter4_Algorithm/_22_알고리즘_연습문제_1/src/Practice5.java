package _Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src;


import java.util.Arrays;

// 최단 경로? 최소 신장 트리?
public class Practice5 {
    private static int[] parents;

    public static int solution(int n, int m, int[][] data) {

        Arrays.sort(data, (x, y) -> x[2] - y[2]); // 최악 경우 정렬
        int worst = (int) Math.pow(getMstResult(n, data), 2);
        Arrays.sort(data, (x, y) -> y[2] - x[2]); // 최악 경우 정렬
        int best = (int) Math.pow(getMstResult(n, data), 2);

        return worst - best;
    }

    private static int getMstResult(int n, int[][] data) {
        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            // find의 결과가 다르면 사이클이 아님..
            if (find(data[i][0]) != find(data[i][1])) {
                union(data[i][0], data[i][1]);
                if (data[i][2] == 0) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private static int find(int target) {
        if (parents[target] == target) {
            return target;
        }
        return parents[target] = find(parents[target]);
    }

    private static void union(int a, int b) {
        int resultA = find(a);
        int resultB = find(b);
        parents[resultA] = resultB;
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
