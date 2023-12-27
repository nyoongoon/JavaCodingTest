package _Theory.Chapter1_Math.Math_04.src;// Practice2
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 2

import java.util.Arrays;

public class Practice2_my {
    public void permutation(int[]arr, boolean[] visited, int depth, int r, int[] out){
        if(depth == r){
            //print
            System.out.println(Arrays.toString(out));
            return;
        }
        for (int i = 0; i < arr.length ; i++) {
            if(visited[i] == false){
                out[depth] = arr[i];
                visited[i] = true;
                permutation(arr, visited, depth+1, r, out);
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

        Practice2_my p = new Practice2_my();
        p.permutation(arr, visited, 0, r, out);
//        System.out.println(result);
    }
}
