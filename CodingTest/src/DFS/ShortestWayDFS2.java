package DFS;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortestWayDFS2 {
	static int n, m, answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;

	public static void DFS(int v ) {
		if(v == n) {
			answer++;
		}else {
			for(int nv : graph.get(v)) {
				if(ch[nv]==0) {
					ch[nv] = 1;
					DFS(nv);
					ch[nv] = 0;
				}
			}
		}
		
			
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
 			graph.add(new ArrayList<Integer>());
			//ArrayList를 인덱스로 접근하기 위해 get(idx)으로 접근
		}
		ch = new int[n+1];
		for(int i = 0; i<m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph.get(a).add(b);
			//get(a)a번 arrayList에 접근
		}
		ch[1] = 1;
		DFS(1);
	}
}
