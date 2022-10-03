package Basic;

import java.util.Arrays;

public class ReverseHash_ans_14_1_1 {

    public static int[] solution(int[] arr){
        int[] arrNew = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arrNew[index] == 0){
                    break;
                }
                index = (index + 1) % arr.length;
            }
            arrNew[index] = arr[i];
            index = (index + arr[i]) % arr.length;
        }
        return arrNew;
        
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx]; //첫번째 인덱스 값부터.

        while (cnt < arr.length) {
            while (val == 0) { // 값이 0일떄
                idx = (idx + 1) % arr.length; //idx + 1 (마지막인경우0으로)
                val = arr[idx];  // //idx + 1 (마지막인경우0으로) 의 값
            } // 값이 0 일때, 다음 인덱스의 값을 새로 생성된 배열에 add
            arrNew[cnt++] = val; //처음 인덱스의 값을 새로 생성된 배열에 add
            arr[idx] = 0; // 처리된 값
            idx = (val + idx) % arr.length; // 새로운 idx ?    // 새로운 배열의 key는 (val+idx)%len
            val = arr[idx];
        }
        return arrNew;
    }


    public static void main(String[] args) {
        // Test code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5};
        int[] arrNew = modification(arr); //arrNew의 값은 (idx+val)%len의 값, 충돌하면 하나 다음값.
        System.out.println(Arrays.toString(arrNew));

        // Revert data
        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
    }
}
