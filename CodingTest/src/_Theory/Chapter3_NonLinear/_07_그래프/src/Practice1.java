package _Theory.Chapter3_NonLinear._07_그래프.src;// Practice1
// 인접 리스트를 이용한 그래프 구현

class Node {
    int id; // 노드가 id 들고 있음 주의 -> 추후 dfs,bfs 시 방문배열체크용
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList {
    char[] vertices;
    Node[] nodeList;
    int idx;

    public MyGraphList(int size) {
        this.vertices = new char[size];
        nodeList = new Node[size];
        idx = 0;
    }

    public void addVertex(char c) {
        if (idx == this.vertices.length) {
            System.out.println("Graph is full");
            return;
        }
        this.vertices[idx++] = c;
    }

    public void addEdge(int x, int y) { // vertex와 간선 정보는 따로 관리 !!!
//        Node newNode = new Node(y, null); // 새로 만들고
//        newNode.next = this.nodeList[x]; // 새로 만든 노드 간선으로 현재 노드(nullable)을 지정
//        nodeList[x] = newNode; // 새로 만든 노드를 노드 배열에 저장
        nodeList[x] = new Node(y, this.nodeList[x]);
        nodeList[y] = new Node(x, this.nodeList[y]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.vertices.length; i++) {
            System.out.print(vertices[i] + ": ");
            Node cur = this.nodeList[i];
            while(cur != null){
                System.out.print(vertices[cur.id] + " ");
                cur = cur.next;
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
