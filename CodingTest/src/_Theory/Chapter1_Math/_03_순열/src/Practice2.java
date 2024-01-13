package _Theory.Chapter1_Math._03_순열.src;// Practice2
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 2

import java.util.Arrays;

public class Practice2 {
    static int result = 0;
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {
        if(depth == r){
//            for (int i = 0; i <r ; i++) {
//                System.out.print(out[i] + " ");
//            }
            System.out.println(Arrays.toString(out));
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] == false){
                visited[i] = true;
                out[depth] = arr[i]; // outOfIndex....!!??... -> 재귀 종료조건 설정으로 해결
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
        int[] out = new int[r];

        Practice2 p = new Practice2();
        p.permutation(arr, 0, n, r, visited, out);
        System.out.println(result);
    }
}
