package _Theory.Chapter1_Math._03_순열.src;// Practice1
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 1

public class Practice1_my {
    static int result = 0;
    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        Practice1_my p = new Practice1_my();
        p.permutation(arr, 3, 0);
        System.out.println(result);
    }


    public void permutation(int[] arr, int r, int depth){
        if(depth == r){
            // 출력
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " "); 
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, r, depth + 1);
            swap(arr, depth, i);
        }

    }

    public void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



}
