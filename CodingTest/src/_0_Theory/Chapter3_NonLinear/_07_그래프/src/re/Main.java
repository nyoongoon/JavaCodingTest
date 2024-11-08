package _0_Theory.Chapter3_NonLinear._07_그래프.src.re;// 비선형 자료구조 - 그래프
// 인접 행렬을 이용한 그래프 구현

class MyGraphMatrix {
    int idx;
    char[] vertex;
    int[][] graph;

    public MyGraphMatrix(int size) {
        this.idx = 0;
        this.vertex = new char[size];
        this.graph = new int[size][size];
    }

    public void addVertex(char data) {
        if(idx == this.vertex.length){
            System.out.println("vertex is full..");
            return;
        }
        this.vertex[idx++] = data;
    }

    public void addEdge(int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (int i = 0; i < vertex.length; i++) {
            System.out.print(vertex[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < vertex.length; i++) {
            System.out.print(vertex[i] + " ");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
////
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();
    }
}
