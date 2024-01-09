package _Theory.Chapter3_NonLinear._07_그래프.src;// Practice3
// 인접 리스트 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList {
    public MyGraphList2(int size) {
        super(size);
    }

    public void dfs(int idx) { // && DFS는 배열&스택(인접 정점들을 스택에 넣는다.)
        boolean[] visited = new boolean[this.vertices.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(idx);
        visited[idx] = true;

        while (!stk.isEmpty()) {
            // 노드 정보 & 간선 정보 분리되어있다는 것 주의
            int i = stk.pop();
            System.out.print(vertices[i] + " ");

            //nodeList의 연결리스트는 연결 순서가 아님 주의 (인접 정점들의 순회 순서)
            Node cur = this.nodeList[i]; // 인접 정점들 스택에 넣기 !
            while (cur != null) {
                if (!visited[cur.id]) {
                    stk.push(cur.id); // 스택에 넣을 때 배열 방문 처리
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int idx) { // BFS는 배열&큐(인접 정점들을 큐에 넣는다.
        boolean[] visited = new boolean[this.vertices.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(vertices[i]+ " ");
            visited[i] = true;

            //nodeList의 연결리스트는 연결 순서가 아님 주의 (인접 정점들의 순회 순서)
            Node cur = nodeList[i]; // 인접 정점들 큐에 넣기
            while (cur != null) {
                if (!visited[cur.id]) {
                    queue.offer(cur.id); // 큐에 넣을 때 배열 방문 처리
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
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
