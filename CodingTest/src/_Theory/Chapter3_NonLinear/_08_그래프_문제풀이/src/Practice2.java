package _Theory.Chapter3_NonLinear._08_그래프_문제풀이.src;// Practice2
// 주어진 그래프에서 시작 노드에서 끝 노드로 가는 길이 있는지 확인하는 프로그램을 작성하세요.
// path 가 존재하면 true 없으면 false 출력

// 입력 예시)
// 노드 개수 = 3
// 간선 정보  = {{0, 1}, {1, 2}, {2, 0}}
// 출발 노드 = 0
// 종착 노드 = 2
// 출력 : true

import java.util.*;

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class GraphList {
    int[] vertices;
    Node[] nodeList;
    int idx;

    public GraphList(int size) {
        this.vertices = new int[size];
        this.nodeList = new Node[size];
        int idx = 0;
    }

    public void addVertex(int id) {
        if (idx == this.vertices.length) {
            System.out.println("Graph is Full ...");
            return;
        }
        this.vertices[idx++] = id;
    }

    public void addEdges(int x, int y) {
        this.nodeList[x] = new Node(y, this.nodeList[x]);
        this.nodeList[y] = new Node(x, this.nodeList[y]);
    }

    public List<Integer> dfs(int id) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices.length];
        Stack<Integer> stk = new Stack<>();

        stk.push(vertices[id]);
        visited[id] = true;
        result.add(id);

        while (!stk.isEmpty()) {
            Node cur = this.nodeList[stk.pop()];
            while (cur != null) {
                if (!visited[cur.id]) {
                    stk.push(cur.id);
                    visited[cur.id] = true;
                    result.add(cur.id);
                }
                cur = cur.next;
            }
        }

        return result;
    }

    public List<Integer> bfs(int id) { //TODO bfs로도 풀어보기!!
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vertices[id]);
        visited[id] = true;
        result.add(id);

        while (!queue.isEmpty()) {
            Node cur = nodeList[queue.poll()];
            while (cur != null) {
                if (!visited[cur.id]) {
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                    result.add(cur.id);
                }
                cur = cur.next;
            }
        }
        return result;
    }
}

public class Practice2 {
    public static void solution(int n, int[][] edges, int source, int dest) {
        GraphList graphList = new GraphList(n);
        for (int i = 0; i < n; i++) {
            graphList.addVertex(i);
        }

        for (int i = 0; i < edges.length; i++) {
            graphList.addEdges(edges[i][0], edges[i][1]);
        }

//        List<Integer> list = graphList.dfs(source)
        List<Integer> list = graphList.bfs(source);


        if (list.get(0) == source && list.contains(dest)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int dest = 2;
        solution(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        source = 0;
        dest = 5;
        solution(n, edges, source, dest);
    }
}
