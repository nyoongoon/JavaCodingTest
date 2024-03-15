package _Theory.Chapter3_NonLinear._07_그래프.src.re;// Practice3
// 인접 리스트 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList {
    public MyGraphList2(int size) {
        super(size);
    }

    public void dfs(int idx) {
        boolean[] visited = new boolean[this.vertex.length];
        Stack<Integer> stk = new Stack<>();
        visited[idx] = true;
        stk.add(idx);

        while (!stk.isEmpty()) {
            Integer popped = stk.pop();
            System.out.print(this.vertex[popped] + " ");
            Node cur = this.edges[popped];
            while (cur != null) {
                if (!visited[cur.idx]) {
                    visited[cur.idx] = true;
                    stk.add(cur.idx);
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int idx) {
        boolean[] visited = new boolean[this.vertex.length];
        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.add(idx);

        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            System.out.print(this.vertex[polled] + " ");
            Node cur = this.edges[polled];
            while (cur != null) {
                if (!visited[cur.idx]) {
                    visited[cur.idx] = true;
                    queue.add(cur.idx);
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class Practice3 {
    public static void main(String[] args) {
//        // Test code
        MyGraphList2 graph = new MyGraphList2(7);
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
