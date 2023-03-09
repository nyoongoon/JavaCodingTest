package Base_Algorithm.Chapter1_Math.Math_09_1.src;

public class Practice2_my {
    public static void solution(int[] arr) { /// 기준 수와 같은 값의 수에 대한 판단 로직 빠져있음 !
        int n = arr.length - 1;

        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= i; j--) {
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                    printArr(arr);
                    return;
                }
            }
        }
        printArr(arr);
    }

    public static void printArr(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
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
