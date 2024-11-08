package _0_Theory.Chapter3_NonLinear._07_그래프.src;// 비선형 자료구조 - 그래프
// 인접 행렬을 이용한 그래프 구현

class MyGraphMatrix {
    char[] vertices;
    int[][] matrix;
    int idx;

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.matrix = new int[size][size];
        this.idx = 0;
    }
    public boolean isFull(){
        return this.vertices.length == idx;
    }

    public void addVertex(char c) {
        if(isFull()){
            System.out.println("Graph is full");
            return;
        }
        this.vertices[this.idx++] = c;
    }

    public void addEdge(int x, int y) {
        this.matrix[x][y] = 1;
        this.matrix[y][x] = 1;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (int i = 0; i < this.vertices.length; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < this.vertices.length; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
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

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();
    }
}
