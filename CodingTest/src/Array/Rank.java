package prac;

import java.util.Scanner;

public class Rank {
	public static void main(String[] args) {

		// �ݺ����� ������ ���鼭 �ִ밪�� ������ �̱�? -> �̷��� �ؾ� �� ��
		// �ѹ� ���鼭 �����ұ� ?
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int max = 0;
		int preMax = 0;
		int maxIdx = 9999;
		int order = 0;
		int stk = 1;
		int[] rank = new int[n]; // ���� �ִ��� ������ ���� �ε����� �ֱ� (���� �Ǵ�)
		int[] students = new int[n];
		for (int i = 0; i < n; i++) {
			students[i] = stdIn.nextInt();
		}

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {// max ���ϱ�
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

				preMax = max; // ������..?
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
