package _0_Theory.Chapter2_Linear._13_선형자료구조_연습문제.src;

public class Practice3_ans {
    public static void solution(int[] data) { //선형 탐사법(liner probing) ㄱㅐ념이라서 해시 인가...
        int len = 0;
        LinkedList ll = new LinkedList(data);


        Node node = ll.getHead();
        len++;

        System.out.print(node.idx + " ");
        while (len != data.length) {
            int cnt = 0;
            node.visit = true;
            //int cmd = Math.abs(node.val);
            int cmd = node.val;
            while (cnt != Math.abs(cmd)) {
                if (cmd >= 0) {
                    node = node.next;
                } else {
                    node = node.prev;
                }
                if (!node.visit) {
                    cnt++;
                }
            }
            System.out.print(node.idx + " ");
            len++;
        }

    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }

    static class Node {
        int val;
        int idx;
        boolean visit = false;
        Node next;
        Node prev;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static class LinkedList {
        Node head;

        LinkedList(int[] data) {
            this.head = new Node(data[0], 1);
            Node curNode = this.head;
            for (int i = 1; i < data.length; i++) {
                Node nextNode = new Node(data[i], i + 1);
                nextNode.prev = curNode;
                curNode.next = nextNode;
                curNode = nextNode;
            }
            this.head.prev = curNode;
            curNode.next = this.head;
        }

        Node getHead() {
            return this.head;
        }
    }
}
