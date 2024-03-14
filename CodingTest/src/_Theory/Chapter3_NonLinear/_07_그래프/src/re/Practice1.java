package _Theory.Chapter3_NonLinear._07_그래프.src.re;// Practice1

// 인접 리스트를 이용한 그래프 구현

/**
 * 노드는 data와 nextNode 들고 있음 주의..
 */
class Node {
    int idx;
    Node nextNode;

    public Node(int idx, Node nextNode) {
        this.idx = idx;
        this.nextNode = nextNode;
    }
}

/**
 * 그래프는 노드정보와 간선정보 갖고 있음.
 */
class MyGraphList {
    char[] vertex;
    int idx;
    Node[] edges; //간선정보.. => 간선만 들어감 주의 !

    public MyGraphList(int size) {
//        this.vertex = vertex;
        this.idx = 0;
        this.vertex = new char[size];
        this.edges = new Node[size];
    }


    public void addVertex(char data) {
        if (idx == this.edges.length) {
            System.out.println("graph is full...");
            return;
        }
        vertex[idx++] = data;
    }

    public void addEdge(int x, int y) {
        edges[x] = new Node(y, edges[x]); //y노드는 기본 간선정보(nullable) 맨앞에 추가됨
        edges[y] = new Node(x, edges[y]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.vertex.length; i++) {
            System.out.print(this.vertex[i] + "의 인접노드 : ");
            Node cur = edges[i];
            while (cur != null) {
                System.out.print(vertex[cur.idx] + " ");
                cur = cur.nextNode;
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

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
