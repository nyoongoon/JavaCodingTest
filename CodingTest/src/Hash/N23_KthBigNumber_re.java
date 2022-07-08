package Hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class N23_FifthBigNumber_re { // 틀림..
    public static void main(String[] args){
        //HashMap<Integer, Integer> map
        HashSet<Integer> set = new HashSet<>();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        Integer[] arr = new Integer[n];

        int idx = 0;

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());


        for(int i = 0; i<arr.length; i++){
            for(int j = 0 ; j<arr.length; j++){
                for(int k = 0; k<arr.length; k++){
                    if(i != j && j != k && i != k){
                        //arr[i] + arr[j] + arr[k]; //hash !!!
                        if(set.add(arr[i] + arr[j] + arr[k])){
                            idx++;
                        }else{

                        }
                        if(idx == m){
                            System.out.println(arr[i] + arr[j] + arr[k]);
                            return;
                        }

                    }
                }
            }

        }




    }
}
