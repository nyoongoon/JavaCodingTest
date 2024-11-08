package _0_Theory.Chapter3_NonLinear._07_그래프.src.re;// Practice1

// 인접 리스트를 이용한 그래프 구현

/**
 * 노드는 data와 nextNode 들고 있음 주의..
 */
class Node {
    int idx; //visited와 data연결 시 사용
    Node next; // dfs, bfs시 사용

    public Node(int idx, Node next) {
        this.idx = idx;
        this.next = next;
    }
}

/**
 * 그래프는 노드정보와 간선정보 갖고 있음.
 */
class MyGraphList {
    int idx;
    char[] vertex;
    Node[] edges;

    public MyGraphList(int size) {
        this.idx = 0;
        this.vertex = new char[size];
        this.edges = new Node[size];
    }

    public void addVertex(char data) {
        if (idx == this.vertex.length) {
            System.out.println("vertex is full..");
            return;
        }
        this.vertex[idx++] = data;
    }

    // 간선 정보만 넣을 것.
    public void addEdge(int x, int y) {
        this.edges[x] = new Node(y, this.edges[x]);
        this.edges[y] = new Node(x, this.edges[y]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.vertex.length; i++) {
            System.out.print(this.vertex[i] + "의 인접 노드 : ");
            Node cur = this.edges[i];
            while (cur != null) {
                System.out.print(vertex[cur.idx] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}


public class Practice1 {
    public static void main(String[] args) {
//        // Test code
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
//
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
