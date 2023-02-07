package Base_CodingTest.W9;

import java.util.ArrayList;

public class Week9_1_my {
    public static void main(String[] args) { // 틀림 다시보기...
        Week9_1_my w = new Week9_1_my();
        int N = 5;
        int[][] friend = {{1, 2, 3, 4}, {2, 3, 4}, {0, 1, 3}, {4}, {1, 2, 3}};
        int[][] time = {{13, 14, 7, 3}, {14, 15, 10}, {7, 4, 20}, {11}, {9, 13, 13}};
        System.out.println(w.solution(N, friend, time)); //14
    }

    public int solution(int N, int[][] friend, int[][] time) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                graph.get(i).add(new Node(friend[i][j], time[i][j]));
            }
        }

        boolean[] visited = new boolean[N];
        int[] dist = new int [N];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < N; j++) {
                if(!visited[i] && dist[i] < min){
                    min = dist[i];
                    minIdx = i;
                }
            }
            for (int j = 0; j < graph.get(i).size(); j++) {
                Node adjNode = graph.get(i).get(j); //인접 노드
                if(dist[adjNode.to] > dist[minIdx] + adjNode.weight){
                    dist[adjNode.to] = dist[minIdx] + adjNode.weight;
                }
            }
            visited[minIdx] = true;
        }

        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if(maxResult < dist[i]){
                maxResult = dist[i];
            }
        }
        return maxResult;
    }

    public static class Node{ // 일단 우선순위 큐 적용 x
        //int from;
        int to;
        int weight;
        //public Node(int from, int to, int weight) {
        public Node(int to, int weight) {
            //this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
