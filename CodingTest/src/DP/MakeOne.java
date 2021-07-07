package DP;
import java.util.Scanner;
//p.217
//바텀업 방식!
//DP테이블을 사용한다. -> 계수정렬의 컨셉과 비슷
public class MakeOne {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int[] arr = new int[30001];
		int x = stdIn.nextInt();
		//i ==0 일경우는 생각x i == 1일 경우 답은 0 
		//i == 2 부터 계산
		for(int i = 2 ; i<x+1; i++) {
			arr[i] = arr[i-1] + 1; //1을 빼는 경우
			if( i %2 == 0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			if( i %3 == 0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
			if( i %5 == 0) {
				arr[i] = Math.min(arr[i], arr[i/5]+1);
			}
		}
		
		System.out.println(arr[x]);
	}
}
