package DP;

import java.util.HashMap;
import java.util.Scanner;

public class SoldierArrangement {   //틀린 듯 왜 틀렸지 ..?
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] arr;
    //int[] overlapSize;

    int minSize = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 재귀적으로 보기
        // n의 값이 n-1보다 큼. //=> n보다 n-1이 큰 경우 => n이 빠지거나 n-1이 빠지거나

        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();

        arr = new int [n];
        //overlapSize = new int [n]; // overlapSize은 i가 빠졌을 때, 빠진 값의 최소 갯수

        for(int i = 0; i<n; i++){
            arr[i] = stdIn.nextInt();
        }

        System.out.println(except(0, 0));

    }

    public static int except(int idx, int size){
        //System.out.println("idx == " + idx + " size == " + size);
        if(map.containsKey(idx)){
            return map.get(idx);
        }else{
            if(idx >= arr.length){
                //System.out.println("idx >= arr.length");
                return size;
            }else if(idx<arr.length-1 && arr[idx] <= arr[idx+1]){
                // except(idx) or except(idx-1) //  n이 빠지거나 n-1이 빠지거나 최적의 값 재귀적 판단...
                //System.out.println("idx<arr.length-1 && arr[idx] <= arr[idx+1]");
                int result = Math.min(except(idx+1, size+1), except(idx+2, size+1));
                map.put(idx, result);
                return result;
            }else{
                //System.out.println("else");
                return except(idx+1, size);
            }
        }

    }
}
