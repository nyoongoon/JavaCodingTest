package DFS;
import java.util.Scanner;

//p.149
public class IcedDrink {
	// 재귀를 사용하며 그래프를 탐색했으므로 DFS!!
	public static int n ;
	public static int m ;
	public static int[][] ice ;
	
	
	public static void main(String[] args) {
	
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		ice = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < m; j++) {
				ice[i][j] = stdIn.nextInt();
			}
		}
		int result = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < m; j++) {
				if(dfs(i, j)) {
					result += 1;	
				}
				
			}
		}
		System.out.println(result);
		
	}
	
	public static boolean dfs(int x, int y) {
		if((x-1 < 0) && (x+1>= n) &&(y+1 < 0) &&(y+1 >= n)) {
			return false;
		}
		if(ice[x][y] == 0) {
			ice[x][y] = 1;
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			return true;
		}
		return false;
	}
	
}
