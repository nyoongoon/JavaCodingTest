package DFS;
// 인프런 7-6강
// 부분집합 구하기 -> DFS로 풀기
// n이 주어졌을 때, n까지 모든 부분집합을 출력 
public class PrintSubset {
	static int n;
	static int[] ch;
	public static void DFS(int L) {
		if(L==n+1) {
			String tmp = "";
			for(int i = 1; i<=n; i++) {
				if(ch[i] == 1)tmp += i + " ";
			}
			if(tmp.length()>0) {//공집합 출력x
				System.out.println(tmp);
			}
		}else {
			ch[L]=1;//사용한다.
			DFS(L+1);//왼쪽트리
			ch[L]=0;//사용하지 않는다.
			DFS(L+1);//오른쪽트리
		}
		
	}
	public static void main(String[] args) {
		n = 3;  
		ch = new int[n+1];
		DFS(1);
		
		
	}
}
