package _Theory.Chapter2_Linear._04_연결리스트_연습문제.src;// Practice2
// Palindrome 연결 리스트
// 추가 자료구조 없이 연결 리스트만으로 풀어보기
// Palindrome: 앞으로 읽어도 뒤로 읽어도 같은 문자열

// 입력 예시)
// 입력 연결 리스트: 1, 3, 5, 3, 1
// 결과: true

// 입력 연결 리스트: 3, 5, 5, 3
// 결과: true

// 입력 연결 리스트: 1, 3, 5, 1
// 결과: false


public class Practice2 {
    public static boolean checkPalindrome(LinkedList list) {
        // head 부터 while문 순회로 마지막 노드 비교 후 삭제 !!!

        while(true){
            if(list.head.next == null){
                return true;
            }

            Node cur = list.head;
            Node prev = list.head;
            int headData = cur.data;

            while(cur.next != null){
                prev = cur;
                cur = cur.next;
            }

            if(headData == cur.data){
                prev.next = null;
                if(list.head.next == null){
                    return true;
                }
                list.head = list.head.next;
            }else{
                return false;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));

    }
}
