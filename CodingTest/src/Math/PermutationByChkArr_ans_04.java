package Math;

import java.util.Arrays;

public class PermutationByChkArr_ans_04 {
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) { // 다시풀기 너무 어렵,,,
        if(depth == r){
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] != true){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
//      Test code
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[4];

        PermutationByChkArr_ans_04 p = new PermutationByChkArr_ans_04();
        p.permutation(arr, 0, n, r, visited, out);
    }
}
