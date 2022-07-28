package Math;

import java.util.ArrayList;

public class PermutationPrintLowerNum_9_1_2 {
    public static void solution(int[] arr) {
        int[] result = new int[arr.length];
        //int result = -1;
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i] < arr[j]){
                    swap(arr, i, j);
                    for (int k = 0; k < arr.length; k++) {
                        result[k] = arr[k];
                    }
                    break;
                }
            }
            if(result[0] != 0){
                break;
            }
        }

        if(result[0] != 0){
            //System.out.println(result);
            for(int a : result){
                System.out.print(a +" ");
            }
        }else{
            for(int a : arr){
                System.out.print(a +" ");
            }
        }
        System.out.println();
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
