package prac;

import java.util.Scanner;

public class ReversePrimeNum_inf_A {
	// ������� �ۼ�Ʈ�� Ȱ���ؼ� ���� ������ ..!!
	
	static int arr [];
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		arr = new int [n];
		for(int i = 0; i<n; i++) {
			arr[i] = stdIn.nextInt();
		}
		
		for(int i = 0; i<n; i++) {
			int arg = reverseInt(i);
			isPrime(arg);
		}
	
	}
	
	public static void isPrime(int arg) {
		
	}
	
	public static int reverseInt(int i) { // ������� �ۼ�Ʈ�� Ȱ���ؼ� ���� ������ ..!!
		int tmp = arr[i]; 
		int res = 0;
		while(tmp>0){
			int t = tmp % 10;
			res = res * 10 + t;
			tmp = tmp / 10;	
		}
		return tmp;
	}
}
