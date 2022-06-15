package Array.TwoPointers;

import java.util.*;

public class N14_FindCommonElement {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>();

        int n = stdIn.nextInt();
        int[] arrA = new int[n];
        for(int i = 0 ; i<arrA.length; i++){
            arrA[i] = stdIn.nextInt();
        }
        int m = stdIn.nextInt();
        int[] arrB = new int[m];
        for(int i = 0 ; i<arrB.length; i++){
            arrB[i] = stdIn.nextInt();
        }


        for(int i = 0 ; i<arrA.length; i++){
            set.add(arrA[i]);
        }

        for(int i = 0 ; i<arrB.length; i++){
            if(!set.add(arrB[i])){
                al.add(arrB[i]);
            }
        }

        Collections.sort(al); // ArrayList 정렬 !

        for(int listNum : al){
            System.out.print(listNum + " ");
        }

    }
}
