import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args){
//        6
//        13 5 11 7 23 15
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int [n];

        for(int i = 0 ; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        for(int i = arr.length-1; i>=0; i--){
            int nowIdx = i;
            while(nowIdx+1 < arr.length && arr[nowIdx] > arr[nowIdx+1]){
                int tmp = arr[nowIdx];
                arr[nowIdx] = arr[nowIdx+1];
                arr[nowIdx+1] = tmp;
                nowIdx++;
            }
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
