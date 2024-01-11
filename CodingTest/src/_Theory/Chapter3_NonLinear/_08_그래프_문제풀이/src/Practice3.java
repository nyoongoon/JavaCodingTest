package _Theory.Chapter3_NonLinear._08_그래프_문제풀이.src;// Practice3
// 주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인 하는 프로그램을 작성하세요.
// 분리 조건: 인접하지 않은 노드끼리 분리

// 모든 노드는 연결되어 있다.
// 분리 가능하면 true, 불가능하면 false 출력

// 예시 입력)
// 그래프: {{1, 3}, {0, 2}, {1, 3}, {0, 2}}
// 출력: true

// 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}} i 레벨에서 노드 정도 담기 j레벨에서 간선담기
// 출력: false

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MatrixGraph {
    int[] vertices;
    int[][] matrix;
    int idx;

    public MatrixGraph(int size) {
        this.vertices = new int[size];
        this.matrix = new int[size][size];
        this.idx = 0;
    }

    public void addVertex(int id) {
        if (this.idx == this.vertices.length) {
            System.out.println("graph is full");
            return;
        }
        this.vertices[idx++] = id;
    }

    public void addEdges(int x, int y) {
        matrix[x][y] = 1;
        matrix[y][x] = 1;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[this.vertices.length];
        Stack<Integer> stk = new Stack<>();
        stk.add(vertices[start]);
        visited[vertices[start]] = true;
        result.add(vertices[start]);

        while (!stk.isEmpty()) {
            int vertex = vertices[stk.pop()];
            for (int i = 0; i < vertices.length; i++) {

                if (matrix[vertex][i] == 1 && !visited[i]) {
                    stk.push(i);
                    visited[i] = true;
                    result.add(i);
                }
            }
        }
        return result;
    }
}

public class Practice3 {
    public static void solution(int[][] graph) {



        int max = Integer.MIN_VALUE;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (max < graph[i][j]) {
                    max = graph[i][j];
                }
            }
        }



        MatrixGraph matrixGraph = new MatrixGraph(max + 1);
        for (int i = 0; i <= max; i++) {
            matrixGraph.addVertex(i);
        }


//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                matrixGraph.addEdges(graph[i][j], graph[i][j]);
//            }
//        }
        // 그래프: {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}} i 레벨에서 노드 정도 담기 j레벨에서 간선담기 -> 잘담은듯?
        for (int i = 0; i < graph.length; i++) {
            int vertex = graph[i][0];
            for (int j = 1; j < graph[i].length; j++) {
                matrixGraph.addEdges(vertex, graph[i][j]);
            }
        }

        matrixGraph.print();

        List<Integer> list = matrixGraph.dfs(graph[0][0]);

//        System.out.println();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println();

        for (int i = 0; i <= max; i++) {
            if (!list.contains(i)) {
                System.out.println(true);
                return;
            }
        }

        System.out.println("false");
    }

    public static void main(String[] args) {
        // Test code
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}}; // 3 출력되는 것 맞음,.. -> 1도 출력되기 ㄴ해야할듯.
        solution(graph);

        graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}; //TODO 이곳 확인..
        solution(graph);
    }
}
