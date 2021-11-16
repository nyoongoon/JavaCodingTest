package Greedy;

import java.util.Scanner;
import java.util.Stack;

public class Chain {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Stack<Integer> firstStk = new Stack<Integer>();
		Stack<Integer> secondStk = new Stack<Integer>();
		int n = stdIn.nextInt();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int m = stdIn.nextInt();
			firstStk.push(m);
		}

		while (!firstStk.empty()) {
			// System.out.println(firstStk.peek());
			firstStk.pop();
			// System.out.println();
			if (firstStk.size() >= 2) {
				answer++;
				// System.out.println(firstStk.peek());
				firstStk.pop();
				// System.out.println(firstStk.peek());
				firstStk.pop();
				secondStk.push(0);
				// System.out.println();
			} else if (firstStk.size() == 1) {// 아님 !
				
				if(secondStk.size() >= 4) {
					secondStk.pop();
					secondStk.pop();
					secondStk.push(0);
					answer++;
					
					firstStk.pop();
					secondStk.pop();
					secondStk.pop();
					secondStk.push(0);
					answer++;
				}else if(secondStk.size() == 3) { // 이 밑의 경우의 수는 함수 바로 끝내기 
					
					secondStk.pop();
					secondStk.pop();
					answer++;
					secondStk.push(0);
					firstStk.pop();
					secondStk.pop();
					secondStk.pop();
					answer++;
					System.out.println(answer);
					return;
				}else if(secondStk.size() == 2) {
					secondStk.pop();
					secondStk.pop();
					answer++;
					firstStk.pop();
					answer++;
					System.out.println(answer);
					return;
				}else if(secondStk.size() == 1) {
					secondStk.pop();
					secondStk.push(0);
					answer++;
					firstStk.pop();
					secondStk.pop();
					answer++;
					System.out.println(answer);
					return;
				}else {
					answer++;
					System.out.println(answer);
					return;
				}
				
				
		
			} else { // 남는 firstk size 0
				if (secondStk.size() >= 2) {
					secondStk.pop();
					secondStk.pop();
					answer++;
				}else {
					secondStk.pop();
					answer++;
				}
			}
		}
		// System.out.println();
		// System.out.println(secondStk.peek());
		// System.out.println();
		secondStk.pop(); // 맨 처음
		while (!secondStk.empty()) {
			// System.out.println(secondStk.peek());
			secondStk.pop(); // 하나를 뺴려면 두개 필요
			answer++;
			answer++;
		}

		System.out.println(answer);
	}
}
