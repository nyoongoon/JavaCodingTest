package _Theory.Chapter3_NonLinear._07_그래프.src;// Practice1
// 인접 리스트를 이용한 그래프 구현


class MyGraphList {
    char[] vertexes;
    int[][] matrix;
    int idx;

    MyGraphList(int size) {
        vertexes = new char[size];
        matrix = new int[size][size];
        idx = 0;
    }

    public void addVertex(char c) {
        this.vertexes[this.idx++] = c;
    }

    public void addEdge(int x, int y) {
        this.matrix[x][y] = 1;
        this.matrix[y][x] = 1;
    }

    public void printAdjacentList() {
        System.out.print("  ");
        for (int i = 0; i < this.vertexes.length; i++) {
            System.out.print(vertexes[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < this.vertexes.length; i++) {
            System.out.print(vertexes[i] + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
