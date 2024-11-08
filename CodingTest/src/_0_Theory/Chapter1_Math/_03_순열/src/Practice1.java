package _0_Theory.Chapter1_Math._03_순열.src;// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 1

public class Practice1 {
    static int result = 0;
    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        Practice1 p = new Practice1();
        p.permutation(arr, 0, 4, 3);
        System.out.println(result);
    }

    void permutation(int[] arr, int depth, int n, int r) { // 순열 출력하기
        if(depth == r ){
            result++;
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int a, int b){
        int tmp  = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
