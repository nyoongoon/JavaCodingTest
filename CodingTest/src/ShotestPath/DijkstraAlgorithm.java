package ShotestPath;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgorithm {
	static final int INF = 987654321;
	static final int MAX_N = 10;
	static int N, E;
	static int[][] Graph = new int [MAX_N][MAX_N];
	static int[] Dist = new int[MAX_N];
	
	static void dijkstra(int src) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0] - b[0]);
		boolean [] visited = new boolean[MAX_N];
		for(int i = 0; i<N; ++i) {
			Dist[i] = INF;
		}
		Dist[src] = 0;
		pq.add(new int[] {0, src});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int u = curr[1];
			if(visited[u]) {
				continue;
			}
			
			visited[u] = true;
			for(int v = 0; v < N; ++v) {
				if(Dist[v] > Dist[u] + Graph[u][v]) {
					Dist[v] = Dist[u] + Graph[u][v];
					pq.add(new int[]{Dist[v], v});
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(i == j) { 
					Graph[i][j] = 0;
				}else {
					Graph[i][j] = INF;
				}
			}
		}
		for(int i = 0; i < E; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int cost = sc.nextInt();
			Graph[u][v] = Graph[v][u] = cost;
		}
		
		dijkstra(0);
		for(int i = 0; i<N; ++i) {
			System.out.print(Dist[i] + " ");
		}
		
	}
}
