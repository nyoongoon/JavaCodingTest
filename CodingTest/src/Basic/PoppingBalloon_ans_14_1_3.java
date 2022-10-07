package Basic;

import java.util.LinkedList;

class Node14{
    int data;
    int cmd;
    boolean visited;
    Node14 next;
    Node14 prev;

    public Node14(int data, int cmd, boolean visited, Node14 next, Node14 prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedList14{
    Node14 head;
    public void add(int data, int cmd){
        if(this.head == null){
            this.head = new Node14(data, cmd, false, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
        }else{
            Node14 cur = this.head;
            while(cur.next != this.head){
                cur = cur.next;
            }
            cur.next = new Node14(data, cmd, false, cur.next, cur);
            this.head.prev = cur.next;
        }
    }
}

public class PoppingBalloon_ans_14_1_3 {
    public static void solution(int[] data) {
        LinkedList14 linkedList = new LinkedList14();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i+1, data[i]);
        }

        Node14 cur = linkedList.head;
        int visitCnt = 0;
        int cmd = 0;
        while(visitCnt != data.length){
            int cnt = 0;
            while(cnt != Math.abs(cmd)){
                if(cmd > 0){
                    cur = cur.next;
                }else{
                    cur = cur.prev;
                }
                if(cur.visited == false){ // 이부분의 구현이 특이함.
                    cnt++;
                }
            }
            System.out.println(cur.data + " ");
            cur.visited = true;
            visitCnt++;
            cmd = cur.cmd;
        }

    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
