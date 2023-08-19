package Base_Algorithm.Chapter2_Linear.LinearDS_05.src;// Practice3
// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시)
// 입력 연결 리스트: 1, 2, 3, 4, 5
// 시작 위치: 2
// 끝 위치: 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트: 1, 4, 3, 2, 5 //팰린드롬이랑 같은 논리로 cnt/2번 순회하면 될듯 !


public class Practice3 {
    public static LinkedList reverseList(LinkedList list, int left, int right) {
        int cnt = right - left + 1;
        Node leftNode = list.head;
        Node prevLeftNode = list.head;

        for (int i = 1; i < left; i++) {
            prevLeftNode = leftNode;
            leftNode = leftNode.next;
        }

        Node rightNode = leftNode;
        Node prevRightNode = leftNode;

        for (int i = 0; i < right- left; i++) {
            prevRightNode = rightNode;
            rightNode = rightNode.next;
        }

        for (int i = 0; i < cnt / 2; i++) {
            Node nextRightNode = null;
            if(rightNode.next != null){
                nextRightNode = rightNode.next;
            }
            Node nextLeftNode = leftNode.next;


            Node tmpNode = rightNode;//swap
            rightNode = leftNode;
            leftNode = tmpNode;


            prevLeftNode.next = leftNode;
            leftNode.next = nextLeftNode;

            prevRightNode.next = rightNode;
            rightNode.next = nextRightNode;


            //Node 초기화
            nextRightNode = rightNode;
            rightNode = leftNode;
            prevRightNode = leftNode;

            while(rightNode.next != nextRightNode){
                prevRightNode = rightNode;
                rightNode = rightNode.next;
            }

            leftNode = leftNode.next;
        }


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
