package _Theory.Chapter4_Algorithm._19_최소신장트리_프루스칼.src.ans;// 알고리즘 - 최소 신장 트리

import java.util.Arrays;

// 크루스칼 알고리즘
public class Main {
    static int parents[];

    public static int example(int[][] data, int v, int e) {
        int weightSum = 0;
        parents = new int[v + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Arrays.sort(data, (x, y) -> x[2] - y[2]);

        for (int i = 0; i < data.length; i++) {
            // find의 결과가 다르면 사이클이 아님
            // find의 결과는 각 요소의 그룹 루트 노드를 찾는 것..
            if (find(data[i][0]) != find(data[i][1])) {
                union(data[i][0], data[i][1]);
                // 크루스칼 알고리즘은 가중치가 작은 간선부터 선택하는 순서를 통해 결과가 항상 최소가 되도록 보장
                weightSum += data[i][2];
            }

            // 결과 같으면 사이클이라 넘김
        }

        return weightSum;
    }


    /**
     * if (find(data[i][0]) != find(data[i][1]))
     * 를 충족한 경우에 union(data[i][0], data[i][1]) 를 하는 것이므로
     * 동일한지에 대한 판단이 필요없지 않을까 했는데
     * (동일 판단은 이미 한 것이지만)
     * find()의 역할은 동일한 *루트노드*를 찾아서 반환하는 것
     * 따라서 합칠 때 루트 노드를 찾아야하는데,
     * 단순히 parents[a] = bResult;는 루트노르를 찾지 않은 상태로 저장하는 것임 !!
     */
//    public static void union(int a, int b) {
//        int bResult = find(b);
//        parents[a] = bResult; // 조건 없이 그냥 합쳐도 될거 같은데? -> 안됨 (집합의 루트를 찾아야함)
//    }

    /**
     * 값의 대소 상관 없이 집합이 같다면 합침 -> 유니온 파인드는 대소관계 관계없이 사이클 방지 체크만 한다
     * <p>
     * - 유니온-파인드는 어떤 두 노드가 같은 집합에 속해 있는지 확인하고, 그렇지 않으면 집합을 합치는 작업만 담당
     * - 즉, 유니온-파인드는 어떤 노드가 부모가 되는지 또는 어떤 순서로 합치는지와는 상관없이,
     * - 두 노드가 같은 집합에 속했는지 여부만 확인하여 집합을 관리..
     */
    public static void union(int a, int b) {
        int aResult = find(a); // a 집합의 루트 노드 찾기
        int bResult = find(b); // b 집합의 루트 노드 찾기

        // 루트 노드를 찾았다면 동일 비교하지 않아도 됨! !!
//        if (aResult != bResult) {
//            parents[aResult] = bResult;
//        }
        parents[aResult] = bResult; // 합칠 때는 대소 관계 없음
    }

    public static int find(int target) {
        //그룹의 최종 부모는 본인 인덱스 == 본인 값
        if (parents[target] == target) {
            return target;
        }
        //재귀로 찾아가서 최종 부모의 값 저장
        parents[target] = find(parents[target]);
        return parents[target];
    }


    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(example(graph, v, e));
    }
}
