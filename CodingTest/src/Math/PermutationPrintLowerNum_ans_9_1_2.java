package Math;

import java.util.Arrays;

public class PermutationPrintLowerNum_ans_9_1_2 { // 강의 풀이
    // arr[i] < arr[i-1] 을 찾고 == idx
    // arr[idx] > arr[i] && arr[i-1] != arr[i] 을 찾아야함. arr[i-1] != arr[i]인 경우 높은 자리수로 바꾸어야하기 때문.  
    public static void solution(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int idx = -1;

        for (int i = arr.length-1; i >= 1 ; i--) {
            if(arr[i] < arr[i-1]){
                idx = i - 1;
                break;
            }
        }
        if(idx == -1){ // 못찾은 경우
            System.out.println(Arrays.toString(arr));
        }
        // 찾았으면 오른쪽 중에서 어떤 숫자랑 교체해야할지 찾기
        for (int i = arr.length-1; i > idx; i--) {
            if(arr[i] < arr[idx] && arr[i] != arr[i-1]){
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }




    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
