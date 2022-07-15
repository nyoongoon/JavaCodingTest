import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args){
//        6
//        13 5 11 7 23 15
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int [n];

        for(int i = 0 ; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        for(int i = 1;  i<arr.length; i++){
            int nowIdx = i;

            while(nowIdx-1 >= 0 && arr[nowIdx-1] > arr[nowIdx] ){
                int tmp = arr[nowIdx];
                arr[nowIdx] = arr[nowIdx-1];
                arr[nowIdx-1] = tmp;
                nowIdx--;
            }
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
