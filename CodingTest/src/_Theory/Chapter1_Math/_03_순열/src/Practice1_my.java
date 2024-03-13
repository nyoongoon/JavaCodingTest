package _Theory.Chapter1_Math._03_순열.src;// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 1

public class Practice1_my {
    static int result; //결과 개수

    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        //swap을 이용한 풀이
        result = 0;
        Practice1_my p = new Practice1_my();
        p.permutationBySwap(arr, 0, 4, 3);
        System.out.println("result == " + result);

    }

    // swap을 이용한 풀이..
    public void permutationBySwap(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            result++;
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutationBySwap(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }


    public void swap(int[] arr, int a, int b) {
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }


}
