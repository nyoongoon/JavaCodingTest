package LinearDS_05.src;// Practice3
// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시)
// 입력 연결 리스트: 1, 2, 3, 4, 5
// 시작 위치: 2
// 끝 위치: 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트: 1, 4, 3, 2, 5


public class Practice3 {
    public static LinkedList reverseList(LinkedList list, int left, int right) {
        LinkedList reversed = new LinkedList();
        int idx = 1;
        Node cur = list.head;

        Node leftNodePrev = list.head;
        Node rightNodeNext = list.head;
        Node leftNode = list.head;
        //Node rightNode = list.head;
        while(cur != null){

            if(idx < left){
                leftNodePrev = cur;
            }

            if(idx == left){
                Node node = new Node(cur.data, reversed.head);
                reversed.head = node;
                leftNode = node;
            }

            if(idx>left && idx <right){
                Node node = new Node(cur.data, reversed.head);
                reversed.head = node;
            }


            if(idx == right){
                Node node = new Node(cur.data, reversed.head);
                reversed.head = node;
                leftNodePrev.next = node;
                //rightNodeNext = node.next;
                rightNodeNext = cur.next;
                break;
            }

            cur = cur.next;
            idx++;
        }

        leftNode.next = rightNodeNext;


//        cur = list.head;
//
//        while(cur != null){
//            System.out.print(cur.data + " ");
//            cur = cur.next;
//        }

        return list;
    }



    
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();


        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.addData(7);
        linkedList2.showData();

        linkedList2 = reverseList(linkedList2, 3, 5);
        linkedList2.showData();

    }
}
