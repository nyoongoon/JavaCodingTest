package _0_Theory.Chapter4_Algorithm._19_최소신장트리_크루스칼.src;// 알고리즘 - 최소 신장 트리

import java.util.Arrays;

// 크루스칼 알고리즘 - 간선 중심의 알고리즘
public class Main {
    static int parents[];

    public static int example(int[][] data, int v, int e) {
        int weightSum = 0;
        parents = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            parents[i] = i;
        }

        Arrays.sort(data, (x, y) -> x[2] - y[2]);

        for (int i = 0; i < data.length; i++) {

            if(find(data[i][0]) != find(data[i][1])){
                // 같지 않아야 사이클 아님
                union(data[i][0], data[i][1]);

                weightSum += data[i][2];
            }
        }

        return weightSum;
    }

    public static int find(int target){
        if(target == parents[target]){
            return target;
        }

        return parents[target] = find(parents[target]);
    }

    public static void union(int a, int b){
        int resultA = find(a);
        int resultB = find(b);

        parents[resultA] = resultB;
    }


    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};
        System.out.println(example(graph, v, e));
    }
}
