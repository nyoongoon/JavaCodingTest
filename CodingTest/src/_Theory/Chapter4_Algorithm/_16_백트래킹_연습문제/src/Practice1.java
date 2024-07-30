package _Theory.Chapter4_Algorithm._16_백트래킹_연습문제.src;// Practice1
// 정수형 n과 m이 주어졌을 때,
// 1 부터 n 까지의 정수 중에서 중복 없이 m 개를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 3
// m: 2
// 출력: [1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]


public class Practice1 {
    public static int[] resultArr;

    public static void solution(int n, int m) {
        resultArr = new int[m];

        int[] nArr = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = i + 1;
        }
        pickArr(nArr, visited, 0, m);
    }

    private static void pickArr(int[] nArr, boolean[] visited, int idx, int m) {
        if (idx == m) {
            System.out.print("[");
            for (int i = 0; i < resultArr.length; i++) {
                System.out.print(resultArr[i] +",");
            }
            System.out.print("], ");
            return;
        }

        for (int i = 0; i < nArr.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            resultArr[idx] = nArr[i];
            pickArr(nArr, visited, idx + 1, m);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 2);
        System.out.println();
        solution(4, 3);
    }
}
