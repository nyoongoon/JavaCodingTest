package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 체크 배열을 생성해서 성능을 높인다!
public class FindCow2 {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int s = in.nextInt();
	    int e = in.nextInt();
	    int result = bfs(s, e);
	    
	    System.out.println(result);
	  }
	
	public static int bfs(int s, int e) {
		Queue<Integer> queue = new LinkedList<>();
		int[] ch = new int[10001];	//<- 한번 계산한 값은 체크해서 성능을 높이기!
		int[] nextLevel = {1, -1, 5};
		//1. 루트 노드 삽입
		queue.offer(s);
		int count = 0; 
		while(true) { // s == e일 경우 중지
			int size = queue.size();
			 // 현재 위치
			for(int i =0; i<size; i++) {
				int curLoc = queue.poll();
				for(int j =0; j<3; j++) {	
					int nextLoc = curLoc + nextLevel[j];
					if(nextLoc == e) return count + 1 ;
					if(ch[nextLoc] != 1 && nextLoc>=0 && nextLoc<=10000) {
						ch[nextLoc] = 1;
						queue.offer(nextLoc);
					}
				}
			}
		
			 // 큐에서 꺼낸값 더하기
			count++;
		}
	}
}
