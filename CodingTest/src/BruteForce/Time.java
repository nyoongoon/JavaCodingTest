package BruteForce;
import java.util.Scanner;

//p.113
public class Time {
	//전체 데이터수가 100만개 이하일때 --> 완전탐색 가능!!!
	//왜 틀렸지..?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 0;
		for(int i = 0; i<=n; i++) {
			if(i ==3 || i == 13 || i == 23) {
				result += 60*60;
			}else {
				result += (45* 15) + (15*60);
			}
		}
		
		System.out.println(result);
	}
}
