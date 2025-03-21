package _0_Theory.Chapter3_NonLinear._08_그래프_문제풀이.src;// Practice3
// 주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인 하는 프로그램을 작성하세요.
// 분리 조건: 인접하지 않은 노드끼리 분리

// 모든 노드는 연결되어 있다.
// 분리 가능하면 true, 불가능하면 false 출력

// 예시 입력)
// 그래프: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
// 출력: true

// 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}
// 출력: false

public class Practice3 {
    public static void solution(int[][] graph) { // 인접노드에 대해서 -flag 값 처리 -> 인접노드인데, flag값이 동일하다면 분리가 되지 않는 것
        // int[][] graph는 각 정점에 대한 간선정보
        int[] flags = new int[graph.length];
        System.out.println(checkFlags(graph, 0, flags, 1));
    }

    public static boolean checkFlags(int[][] grapgh, int vertex, int[] flags, int flag){
        if(flags[vertex] != 0){
            return flags[vertex] == flag; //같아야함! -> 다르다면 분리되지 못한 것 !
        }

        // 현재정점 flag 처리
        flags[vertex] = flag;

        // 인접정점 dfs -> -flag 처리
        for (int i = 0; i < grapgh[vertex].length; i++) {
            int neighbor = grapgh[vertex][i];
            if(!checkFlags(grapgh, neighbor, flags, -flag)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        solution(graph);
    }
}
