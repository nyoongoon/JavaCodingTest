package Greedy;

import java.util.Scanner;

public class ChangeMoney {
	public void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();	//거슬러 줘야할 돈
		int count = 0; //동전의 갯수
		while(n>=500) {
			n -= 500;
			count++;
		}
		while(n>=100) {
			n -= 100;
			count++;
		}
		while(n>=50) {
			n -= 50;
			count++;
		}
		while(n>=10) {
			n -= 10;
			count++;
		}
		
		System.out.println(count);
		
	}
}
