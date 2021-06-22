package Greedy;

import java.util.Scanner;
// 거스름돈을 배열의 요소로 선언하여 깔끔하게 정리!
public class ChangeMoney2 {
	public void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();	//거슬러 줘야할 돈
		int[] array = {500, 100, 50, 10}; 
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			count += n / array[i];
			n %= array[i];
		}
		System.out.println(count);
	}
}
