package Math;

public class PermutationByRecur_ans_04 {
    public void permutation(int[] arr, int depth, int n, int r){
        if(depth == r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }


    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        PermutationByRecur_ans_04 p = new PermutationByRecur_ans_04();
        p.permutation(arr, 0, 4, 3);
    }
}
