package _2_Java_Algo_Interview._6_해시테이블;

public class _1_해시맵_디자인_책풀이 {
    static class MyHashMap {
        static class Node{
            int key;
            int value;
            Node next;
            Node(int key, int value, Node next){
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        Node[] nodes;

        public MyHashMap() {
            nodes = new Node[1000000];
        }

        public void put(int key, int value) {
            int idx = key % nodes.length;
            if(nodes[idx] == null){
                nodes[idx] = new Node(key, value, null);
                return;
            }
            Node curNode = nodes[idx];
            while(curNode != null){
                if(curNode.key == key){
                    curNode.value = value;
                    return;
                }
                if(curNode.next == null){
                    curNode.next = new Node(key, value, null);
                    return;
                }
                curNode = curNode.next;
            }
        }

        public int get(int key) {
            int idx = key % nodes.length;
            if(nodes[idx] == null){
                return -1;
            }

            Node curNode = nodes[idx];
            while(curNode != null){
                if(curNode.key == key){
                    return curNode.value;
                }
                curNode = curNode.next;
            }
            return -1;
        }

        public void remove(int key) {
            int idx = key % nodes.length;
            if(nodes[idx] == null) return;

            Node curNode = nodes[idx];
            if(curNode.key == key){
                if(curNode.next == null){
                    nodes[idx] = null;
                }else{
                    nodes[idx] = curNode.next;
                }
                return;
            }
            Node prevNode = nodes[idx];
            while(curNode != null){
                if(curNode.key == key){
                    if(curNode.next == null){
                        prevNode.next = null;
                    }else{
                        prevNode.next = curNode.next;
                    }
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }

        }
    }
}
