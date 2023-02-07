package Base_Algorithm;

class Node_14 {
    int data;
    int cmd;
    boolean visited;
    Node_14 next;
    Node_14 prev;

    public Node_14(int data, int cmd, boolean visited, Node_14 next, Node_14 prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedList_14 {
    Node_14 head;

    public LinkedList_14() {
        System.out.println("생성");
        this.head = null;
    }

    public void add(int data, int cmd) {
        if (this.head == null) {
            this.head = new Node_14(data, cmd, false, null, null);
            this.head.prev = this.head;
            this.head.next = this.head;
        } else {
            Node_14 cur = this.head;
            while (cur.next != this.head) {
                cur = cur.next;
            }
            cur.next = new Node_14(data, cmd, false, head, cur);
            head.prev = cur.next;
        }
    }
}


public class PoppingBalloon_re_14_1_3 {
    public static void solution(int[] data) {
        LinkedList_14 ll = new LinkedList_14();
        for (int i = 0; i < data.length; i++) {
            ll.add(i + 1, data[i]);
        }

        int cnt = 0;
        int moved = 0;
        int cmd = ll.head.cmd;
        Node_14 cur = ll.head;
        cur.visited = true;
        System.out.print(cur.data + " ");
        while (cnt < data.length) {
            System.out.println(cnt);
            while (moved < Math.abs(cmd)) {
                if(cmd >= 0){
                    cur = cur.next;
                }else{
                    cur = cur.prev;
                }
                if(cur.visited == false){
                    moved++;
                }
            }
            System.out.print(cur.data + " ");
            cmd = cur.cmd;
            cur.visited = true;
            moved = 0;
            cnt++;
        }
        System.out.println("끝");
        return;
    }

    public static void main(String[] args) {
//        int[] balloon = {3, 2, 1, -3, -1};
//        solution(balloon);

        System.out.println();
        //balloon = new int[]{3, 2, -1, -2};
        int[] balloon = {3, 2, -1, -2};
        solution(balloon);
    }
}
