package BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestWayBFS3 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList();
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int[] ch = new int[n + 1];
		int[] result = new int[n + 1];

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list.add(new ArrayList<Integer>());
			// 인덱스가 되는 객체 생성
		}

		for (int i = 0; i < m; i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			list.get(a).add(b);
		}
		int count = 1;
		queue.add(1);
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int cur = queue.poll();
				// for(int j = 0; j<n; j++) {
				// if(list.get(cur).get(j) != null) { //어레이리스트 안에서 하나씩 살펴보기!
				for (int nv : list.get(cur)) { // 향상된 for문으로 어레이리스트 탐색하기!
					if (ch[nv] == 0) {
						ch[nv] = 1;
						queue.add(nv);
						// result[nv] = count;
						result[nv] = result[cur] + 1; // 이렇게 구현 가능
					}
				}
			}
		}
		// count++;
		for (int i = 2; i < n+1; i++) {
			System.out.println(result[i]);
		}

	}
}
