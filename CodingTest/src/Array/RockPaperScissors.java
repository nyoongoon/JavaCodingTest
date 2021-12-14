package prac;

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		// 가위 == 1 // 1:D // 2:L // 3:W
		// 바위 == 2 // 1:W // 2:D // 3:L
		// 보 == 3 // 1:L // 2:W // 3:D

		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = stdIn.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b[i] = stdIn.nextInt();
		}

		// a의 입장에서 판단
		for (int i = 0; i < n; i++) {
			if (a[i] == 1) {
				if (b[i] == 1) {
					System.out.println("D");
				} else if (b[i] == 2) {
					System.out.println("B");
				} else { // b[i] == 3
					System.out.println("A");
				}
			} else if (a[i] == 2) {
				if (b[i] == 1) {
					System.out.println("A");
				} else if (b[i] == 2) {
					System.out.println("D");
				} else { // b[i] == 3
					System.out.println("B");
				}
			} else {// a[i] == 3
				if (b[i] == 1) {
					System.out.println("B");
				} else if (b[i] == 2) {
					System.out.println("A");
				} else { // b[i] == 3
					System.out.println("D");
				}
			}
		}

	}
}
