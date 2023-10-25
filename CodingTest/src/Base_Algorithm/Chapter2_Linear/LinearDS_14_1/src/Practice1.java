package Base_Algorithm.Chapter2_Linear.LinearDS_14_1.src;

import java.util.Arrays;

public class Practice1 {
    //변경한 데이터들을 다시 원래의 배열 순서로 변경

    // 1 3 5 7 9 -> mod -> 1, 3, 7, 9, 5

    // 3 6 8 2 -> mod -> 3 2 6 8
    public static int[] solution(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        int[] origin = new int[arr.length];
        // 인덱스를 해시로 관리... 혹은 visited 불리언 배열로
        // 첫번째는 무조건 첫번째...
        int cnt = 0;
        int idx = 0;
        while (cnt < arr.length) {
            int val = arr[cnt];

            while (visited[idx]) {
                idx = (idx + 1) % arr.length;
            }

            origin[idx] = val;
            visited[idx] = true;
            idx = (arr[cnt] + cnt) % arr.length;

            cnt++;
        }
        return origin;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length]; //1 3 5 7 9 //-> 1,3,9
        int idx = 0;
        int cnt = 0;
        int val = arr[idx]; // val == 9
        while (cnt < arr.length) {
            while (val == 0) { //값이 0이면 다음 값 가져옴
                idx = (idx + 1) % arr.length; // 인덱스 하나씩 올리면서
                val = arr[idx]; //
            }
            arrNew[cnt++] = val; // 맨처음 값 맨처음으로..
            arr[idx] = 0; // 현재 idx에 0값 넣기..
            idx = (val + idx) % arr.length; // val + idx .. 현재 인덱스의 값 + 인덱스 -> 인덱스
            val = arr[idx];
        } //arr[(x + 0) % arr.length] == 1
        return arrNew;
    }


    public static void main(String[] args) {
        // Test code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5};
        // idx0 = 1+1, idx1 =
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew)); // 1 3 5 7 9

        // Revert data
//        arr = new int[]{1, 3, 7, 9, 5};// 1 3 5 7 9
          arr = new int[]{1, 3, 5, 7, 9}; // 1 3 5 7 9
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin)); // 1 3 7 9 5

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin)); // 3 6 8 2 -> mod -> 3 2 6 8
    }
}
