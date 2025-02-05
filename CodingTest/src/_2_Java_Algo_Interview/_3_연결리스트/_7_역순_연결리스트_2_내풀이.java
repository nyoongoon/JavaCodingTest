package _2_Java_Algo_Interview._3_연결리스트;

public class _7_역순_연결리스트_2_내풀이 {
    public static void main(String[] args) {

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        int idx = 1;
        ListNode beforeLeft = null;
        ListNode leftNode = null;
        ListNode afterRight = null;
        ListNode rightNode = null;
        ListNode curNode = head;
        ListNode prevNode = null;
        while(curNode != null){
            if(idx == left){
                beforeLeft = prevNode; //beforeLeft null 인상황 주의
                leftNode = curNode;
            }
            if(idx == right){
                rightNode = curNode;
                afterRight = curNode.next;
            }
            idx++;
            prevNode = curNode;
            curNode = curNode.next;
        }

        // if(beforeLeft == null){
        //     System.out.println("beforeLeft == " + null);
        // }else{
        //     System.out.println("beforeLeft == " + beforeLeft.val);
        // }


        // System.out.println("leftNode == " + leftNode.val);
        // System.out.println("rightNode == " + rightNode.val);
        // if(afterRight == null){
        //     System.out.println("afterRight == " + null);
        // }else{
        //     System.out.println("afterRight == " + afterRight.val);
        // }


        prevNode = leftNode;
        curNode = leftNode.next;
        while(curNode != null && curNode != rightNode){
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        if(beforeLeft == null){
            head = leftNode;
        }else{
            beforeLeft.next = rightNode;
        }

        leftNode.next = afterRight;

        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
