package DFS;
import java.util.Scanner;

public class SameSum {
	static String answer = "NO";
	static int[] intSet;
	static int total = 0;
	static boolean flag = false;
	public static void dfs(int index, int sum) {
		if(flag == true) {
		return;
		}
		if(sum > total/2) {
			return; 
		}
		// 종료조건 마지막 인덱스
		if(index == intSet.length) {
			if(total-sum == sum) {
				answer = "YES";
				flag = true;	// 이후에 계산안하기 위해서 flag 설정!!!
			}
		}else {
		
		dfs(index+1, sum);	//해당 인덱스 더하지 않음
		dfs(index+1, sum+intSet[index]); //해당 인덱스 더함
		}
	}
	
	public static void main() {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		intSet = new int[n];
		for (int i = 0; i < n; i++) {
			intSet[i] = stdIn.nextInt();
			total += intSet[i];
		}
		
		
		dfs(0, 0);
		System.out.println(answer);
	}
}
