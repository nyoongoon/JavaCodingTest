package LeetCode;

public class AddTwoNumbers_2 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//시작 노드 만들기
		ListNode prev = new ListNode(0);//기본값으로 0
		ListNode head = prev;
		//계산값
		int carry = 0;
		//l1과 l2가 null 이더라도 carry(10의자리)값이 남아있으면 안된다!!
		while(l1 != null || l2 != null || carry != 0) {
			ListNode cur = new ListNode(0);
			int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
			cur.val = sum % 10;  //현재 노드의 값에 sum의 1의 자리 값만 저장
			carry = sum / 10; // sum의 값이 10이 넘었을 경우를 체
			//이전 노드의next를 현재 노드 가리키기!!
			prev.next = cur;
			prev = cur;
			//현재 노드가 null 이면 납두
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return head.next;
	}
}


