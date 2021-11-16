package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightDialer_LeetCode_935 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int answer = knightDialer(stdIn.nextInt());
		System.out.println(answer);
	}

	public static int knightDialer(int n) {
		if (n == 1) {

			return 10;
		} else {
			n -= 2;
		}
		// 0 1 2 3 4 5 6 7 8 9
		int[][] knight = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, { 0 }, { 0, 1, 7 }, { 2, 6 }, { 1, 3 },
				{ 2, 4 } };

		int[] n2 = { 4, 6, 6, 8, 7, 9, 4, 8, 0, 3, 9, 0, 1, 7, 2, 6, 1, 3, 2, 4 };

		for (int k = 0; k < n; k++) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int num : n2) {

				int[] target = knight[num];
				for (int t : target) {
					al.add(t);
				}
			}

			int[] nArr = new int[al.size()];

			for (int j = 0; j < al.size(); j++) {
				nArr[j] = al.get(j);
			}
			n2 = nArr;
		}
		return n2.length;
	}
}
