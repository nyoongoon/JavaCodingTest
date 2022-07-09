package Hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class N23_KthBigNumber { // 런타임 초과 !!!
    public static void main(String[] args){

        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        int[] arr = new int[n];
        Integer[] sumArr = new Integer[n*(n-1)*(n-2)];
        int idx = 0;

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }


        for(int i = 0; i<arr.length; i++){
            for(int j = 0 ; j<arr.length; j++){
                for(int k = 0; k<arr.length; k++){
                    if(i != j && j != k && i != k){
                        sumArr[idx++] = arr[i] + arr[j] + arr[k];
                    }
                }
            }

        }

        int sumIdx = 1;
        Arrays.sort(sumArr, Collections.reverseOrder());

        // for(int i = 0; i<sumArr.length; i++){
        // 	System.out.print(sumArr[i] + " ");
        // }


        for(int i = 1; i<sumArr.length; i++){
            if(sumIdx == m){
                // System.out.println();
                System.out.println(sumArr[i]);
                break;
            }
            if(!sumArr[i-1].equals(sumArr[i])){
                //System.out.println(sumArr[i-1] + " != " + sumArr[i]);
                sumIdx++;
                continue;
            }
            if(i == sumArr.length-1){
                System.out.println(-1);
            }

        }


    }
}
