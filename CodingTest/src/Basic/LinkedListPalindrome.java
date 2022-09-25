package Basic;

;// Practice2
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


public class LinkedListPalindrome {
    public static boolean checkPalindrome(LinkedList list) {

        int len = 0;
        Node cur = list.head;

        while(cur != null){
            len++;
            cur = cur.next;
        }

        //System.out.println("len == " + len);
        //int mid = 0;

//        if(len % 2 == 0){
//          len = len / 2;
//        }else{
//            len = len / 2 - 1;
//        }

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        cur = list.head;
        int i = 0;
        while(cur != null){

            //System.out.println("i == "+ i);
            if(len % 2 == 0){
                if(i < len/2){
                    list1.addData(cur.data);
                }else{
                    list2.head = new Node(cur.data, list2.head);
                }
            }else{
                if(i < len/2){
                    list1.addData(cur.data);
                }else if (i > len/2){
                    //System.out.println("i==" + i);
                    //Node tmp = list2.head;
                    list2.head = new Node(cur.data, list2.head);
                    //list2.head.next = tmp;

                }else{
                    //continue;
                }
            }
            cur = cur.next;
            i++;
        }

        Node cur1 = list1.head;
        Node cur2 = list2.head;


//        while(cur1 != null){
//            System.out.println(cur1.data);
//            cur1 = cur1.next;
//
//        }
//        System.out.println("----");
//        while(cur2 != null){
//            System.out.println(cur2.data);
//            cur2 = cur2.next;
//        }


        while(cur1 != null){
            if(cur1.data != cur2.data){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;
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
