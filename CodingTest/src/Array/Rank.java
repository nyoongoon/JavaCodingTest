package prac;

import java.util.Scanner;

public class Rank {
	public static void main(String[] args) {

		// 반복문을 여러번 돌면서 최대값을 여러번 뽑기? -> 이렇게 해야 할 듯
		// 한번 돌면서 가능할까 ?
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int max = 0;
		int preMax = 0;
		int maxIdx = 9999;
		int order = 0;
		int stk = 1;
		int[] rank = new int[n]; // 뽑은 최댓값의 순위를 같은 인덱스에 넣기 (동급 판단)
		int[] students = new int[n];
		for (int i = 0; i < n; i++) {
			students[i] = stdIn.nextInt();
		}

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {// max 구하기
				if (max <= students[i]) {
					max = students[i];
					maxIdx = i;
				}
			}
			students[maxIdx] = 0;
			if (preMax == max) {
				rank[maxIdx] = order;
				stk++;
			} else {

				preMax = max; // 이전값..?
				order = order + stk;
				rank[maxIdx] = order;
				stk = 1;
			}
			max = 0;
		}
		
		for(int i = 0; i<rank.length; i++) {
			System.out.print(rank[i] + " ");
		}

	}
}
