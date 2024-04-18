package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

public class Practice4_re {
    static int maxValue = Integer.MIN_VALUE;

    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        boolean[] visited = new boolean[n];

        bfs(speed, efficiency, k, visited, 0, 0, Integer.MAX_VALUE);
        return maxValue;
    }

    public static void bfs(int[] speed, int[] efficency, int k, boolean[] visited, int cnt, int value, int min) {
        if (cnt >= k) {
            maxValue = Math.max(value * min, maxValue);
            return;
        }

        for (int i = 0; i < speed.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(speed, efficency, k, visited, cnt + 1, value + speed[i], Math.min(min, efficency[i]));
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
