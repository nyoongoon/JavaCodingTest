package Hash;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class N23_KthBigNumber_inf { //TreeSet 활용 !!! => set에 넣을때 정렬까지 !
    public static void main(String[] args){
        // treeSet 메소드 예시
        // treeSet.remove();
        // treeSet.size();
        // treeSet.first(); 맨 앞의 값. //treeSet.last();

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());  //TreeSet 활용 !!! => set에 넣을때 정렬까지 !

        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<arr.length; i++){
            arr[i] = stdIn.nextInt();
        }

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){ // j = i+1 주의 (나는 j = 0) => 이미 뽑았던 수들을 다시 뽑게 됨.
                for(int l = j+1; l<n; l++){
                    tSet.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int cnt = 0;
        int answer = -1;
        for(int x : tSet){
            cnt++;
            if(cnt == k) {
                answer = x;
                System.out.println(answer);
                return;
            }
        }
        System.out.println(answer);

    }
}
