package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class KindsOfSales {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();

        int[] arr = new int [n];
        int[] resultArr = new int[n-k+1];

        for(int i = 0; i<n; i++){
            arr[i] = stdIn.nextInt();
        }

        int cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }
        resultArr[0] = map.size();

        for(int i = 1; i<n-k+1; i++){ // i는 시작idx
            map.put(arr[i-1], map.getOrDefault(arr[i-1], 1) - 1);
            if(map.get(arr[i-1]) == 0){
                map.remove(arr[i-1]);
                //System.out.println("remove => " + arr[i-1]);
            }

            map.put(arr[i+k-1], map.getOrDefault(arr[i+k-1], 0) + 1);
            //System.out.println("add => " + arr[i+k-1]);
            resultArr[i] = map.size();
        }

        for(int i = 0; i<resultArr.length; i++){
            System.out.print(resultArr[i] + " ");
        }
    }
}
