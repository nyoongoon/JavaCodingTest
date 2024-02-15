package _Theory.Chapter1_Math._03_순열.src;// Practice2
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 2

public class Practice2_my {
    static int result = 0;

    public static void main(String[] args) {
//      Test code
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];

        Practice2_my p = new Practice2_my();
        p.permutationByVisited(arr, visited, out, 0, n, r);
        System.out.println("result == " + result);
    }

    //visit 배열을 이용한 풀이
    public void permutationByVisited(int[] arr, boolean[] visited, int[] out, int depth, int n, int r) {
        if (depth == r) {
            result++;
            for (int i = 0; i < r; i++) {
                System.out.print(out[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {  // i가 depth부터가 아니고 0 부터임을 주의하기.. -> visited배열 이므로..
            if (!visited[i]) {
                out[depth] = arr[i];
                visited[i] = true;
                permutationByVisited(arr, visited, out, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
