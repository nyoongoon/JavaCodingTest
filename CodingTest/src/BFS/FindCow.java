package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//인프런 7-8
public class FindCow {
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int s = in.nextInt();
	    int e = in.nextInt();
	    int result = bfs(s, e);
	    
	    System.out.println(result);
	  }
	
	public static int bfs(int s, int e) {
		Queue<Integer> queue = new LinkedList<>();
		//1. 루트 노드 삽입
		queue.offer(s);
		int count = 0; 
		while(true) { // s == e일 경우 중지
			int size = queue.size();
			 // 현재 위치
			for(int i =0; i<size; i++) {
				int curLoc = queue.poll();
				if(curLoc == e) {
					return count;
				}
				queue.offer(curLoc + 1);
				queue.offer(curLoc + (-1));
				queue.offer(curLoc + 5);
				
			}
			 // 큐에서 꺼낸값 더하기
			count++;
		}
	}
}
