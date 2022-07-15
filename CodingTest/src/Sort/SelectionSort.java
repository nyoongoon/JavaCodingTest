import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args){
//        6
//        13 5 11 7 23 15
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int [n];

        for(int i = 0 ; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        for(int i = 0; i<arr.length; i++){
            int nowMin = Integer.MAX_VALUE;
            int minIdx = i;
            for(int j = i; j<arr.length; j++){
                if(nowMin > arr[j]){
                    nowMin = arr[j];
                    minIdx = j;
                }
            }
            arr[minIdx] = arr[i];
            arr[i] = nowMin;

        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
