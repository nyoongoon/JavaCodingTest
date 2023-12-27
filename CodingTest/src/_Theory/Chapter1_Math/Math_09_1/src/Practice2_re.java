package _Theory.Chapter1_Math.Math_09_1.src;

public class Practice2_re {
    public static void solution(int[] arr) {
        int target = -1;
        for (int i = arr.length-1; i >= 1; i--) {
            if(arr[i] < arr[i-1]){
                target = i-1;
                break;
            }
        }

        if(target != -1){
            for (int i = arr.length-1; i >= 1; i--) {
                if(arr[target] > arr[i] && arr[i] != arr[i-1]){
                    swap(arr, target, i);
                }
            }
        }

        printArr(arr);
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void printArr(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }






    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);

        arr = new int[]{5, 7, 3, 4, 5};
        solution(arr);
    }
}
