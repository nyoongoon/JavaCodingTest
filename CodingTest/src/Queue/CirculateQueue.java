package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CirculateQueue {

	static int result = 0;
	public static Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int count = 1;
		while (count <= n) {
			queue.add(count++);
		}
		// 값 뺄때 판단하기 -> 찾는 값과 첫값, 끝값의 길이를 비교

		int[] targets = new int[m];
		for (int i = 0; i < m; i++) {
			targets[i] = stdIn.nextInt();
		}

		for (int i = 0; i < m; i++) {
			// targets[i] 와
			Deque<Integer> qTemp = new ArrayDeque<>(queue); //인자로 큐를 주면 복사의 개념.
			int targetIdx = 0;
			while(targets[i]!=qTemp.peek()) {
				qTemp.poll();
				targetIdx++;
			}
			
			while (targets[i] != queue.peek()) {
				
				if (targetIdx <= queue.size()/2) {   // 여기부분에서 엄청 헤맴 !!! 짝수인 경우와 홀수인 경우 항상 조심하기!!!
					moveLeft();
				} else {
					moveRight();
				}
			}
			queue.poll();
		}
		System.out.println(result);
	}

	public static void moveLeft() {
		result++;
		int temp = queue.poll();
		queue.add(temp);
	}

	public static void moveRight() {
		result++;
		int temp = queue.pollLast();
		queue.addFirst(temp);
	}

}
