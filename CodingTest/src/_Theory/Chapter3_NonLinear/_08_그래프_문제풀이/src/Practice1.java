package _Theory.Chapter3_NonLinear._08_그래프_문제풀이.src;// Practice1
// Center Node 찾기
// Undirected 그래프에서 center node 를 출력하세요.
// Center node 는 다른 모든 노드와 연결된 노드를 의미
// 다른 노드와 연결된 노드는 하나라고 가정

// 입력 그래프: {{1, 2}, {2, 3}, {4, 2}}
// 출력: 2

// 입력 그래프: {{1,2}, {5,1}, {1,3}, {1,4}}
// 출력: 1

class MyGraphMatrix {
    int[] vertices;
    int[][] matrix;
    int idx;

    public MyGraphMatrix(int size) {
        this.vertices = new int[size];
        this.matrix = new int[size][size];
        this.idx = 0;
    }

    public MyGraphMatrix(int[][] edges) {
        // 가장 큰 수 찾아서 -> size로
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (max < edges[i][j]) {
                    max = edges[i][j];
                }
            }
        }
        this.vertices = new int[max + 1];
        this.matrix = new int[max + 1][max + 1];
        this.idx = 0;

        for (int i = 1; i < max; i++) {
            addVertex(i);
        }
    }

    public void addVertex(int vertex) {
        if (idx == vertices.length) {
            System.out.println("Graph is full ...");
            return;
        }
        vertices[idx++] = vertex;
    }

    public void addEdges(int x, int y) {
        matrix[x][y] = 1;
        matrix[y][x] = 1;
    }

    public int findCenter() {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < matrix.length; i++) {
            int tmp = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    tmp++;
                }
            }
            if (max < tmp) {
                max = tmp;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


public class Practice1 {
    public static int solution(int[][] e) {
        MyGraphMatrix graphMatrix = new MyGraphMatrix(e);
        for (int i = 0; i < e.length; i++) {
            graphMatrix.addEdges(e[i][0], e[i][1]);
        }
        graphMatrix.print();

        return graphMatrix.findCenter();

    }

    public static int solution2(int[][] e) { // 풀이 2
        // 간선의 총 개수는 노드의 개수 -1
        // 모든 노드는 연결되어 있다.
        // 위의 제약조건이 있는 경우 풀 수 있는 풀이! (센터 노드가 아닌 노드들은 센터 노드와만 연결되어있는 상황)
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public static void main(String[] args) {
        // Test code
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println("answer : " + solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println("answer : " + solution(edges));
        System.out.println(solution2(edges));
    }
}

