package _Theory.Chapter3_NonLinear._07_그래프.src;// Practice2
// 인접 행렬 그래프의 DFS, BFS


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix {
    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int idx) { // DFS는 배열&스택(인접 정점들을 스택에 넣는다.)
        boolean[] visited = new boolean[this.vertices.length];
        Stack<Integer> stk = new Stack<>();

        stk.push(idx);
        visited[idx] = true;

        while (!stk.isEmpty()) {
            int i = stk.pop();
            System.out.print(vertices[i] + " -> ");
            for (int j = matrix[i].length - 1; j >= 0; j--) { // 알파벳순 방문하려고 거꾸로
                if (matrix[i][j] == 1 && !visited[j]) {
                    stk.push(j); // 스택에 넣으면서 동시에 방문 체크
                    visited[j] = true;
                }
            }
        }
        System.out.println();
    }

    public void bfs(int idx) { // BFS는 배열&큐(인접 정점들을 큐에 넣는다.)
        boolean[] visited = new boolean[this.vertices.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            visited[i] = true;
            System.out.print(vertices[i] + " -> ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyGraphMatrix2 graph = new MyGraphMatrix2(7);
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.dfs(0);
        graph.bfs(0);
    }
}
