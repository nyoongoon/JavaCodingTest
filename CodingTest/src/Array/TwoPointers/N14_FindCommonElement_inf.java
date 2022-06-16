package Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N14_FindCommonElement_inf {
    // 인프런 문제풀이
    // 먼저 정렬 하고
    // 투포인터로 비교. -> 셋 사용 안할 수 있음.
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = stdIn.nextInt();
        }

        int m = stdIn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = stdIn.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int idx1 = 0;
        int idx2 = 0;
        ArrayList<Integer> al = new ArrayList<>();

        while (idx1 < n && idx2 < m) {
            int val1 = arr1[idx1]; //한번씩 올라가며 체크
            int val2 = arr2[idx2];

            if (val1 == val2) {
                al.add(val1);
                idx1++;
                idx2++;
            } else if (val1 > val2) {
                idx2++;
            } else {
                idx1++;
            }
        }

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}
