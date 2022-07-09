package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class N21_KindsOfSales_inf {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();

        int[] arr = new int [n];


        for(int i = 0; i<n; i++){
            arr[i] = stdIn.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for(int rt = k-1; rt<n; rt++){ // i 대신 rt로 슬라이딩 윈도우의 마지막 인덱스를 끌고 올라옴 주목 !!! ( 더 보기 편함)
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            lt++;
        }
    }
}
