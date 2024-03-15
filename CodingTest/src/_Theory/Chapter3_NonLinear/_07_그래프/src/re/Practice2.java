package _Theory.Chapter3_NonLinear._07_그래프.src.re;// Practice2
// 인접 행렬 그래프의 DFS, BFS


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix {

    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int idx) {
        boolean[] visited = new boolean[this.vertex.length];
        Stack<Integer> stack = new Stack<>();
        int curIdx = idx;
        stack.add(curIdx);
        visited[curIdx] = true;

        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            System.out.print(this.vertex[popped] + " -> ");


            for (int i = this.graph[popped].length - 1; i >= 0; i--) {
                if (graph[popped][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.add(i);
                }
            }
        }
        System.out.println();
    }

    public void bfs(int idx) {
        boolean[] visited = new boolean[this.vertex.length];
        Queue<Integer> queue = new LinkedList<>();
        int curIdx = idx;
        queue.add(curIdx);
        visited[curIdx] = true;

        while (!queue.isEmpty()) {
            Integer popped = queue.poll();
            System.out.print(this.vertex[popped] + " -> ");
            for (int i = 0; i < this.graph[popped].length; i++) {
                if (graph[popped][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
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
