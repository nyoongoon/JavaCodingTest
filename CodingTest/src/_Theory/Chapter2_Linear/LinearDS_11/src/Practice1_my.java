package _Theory.Chapter2_Linear.LinearDS_11.src;// Practice1
// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터: 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터: 1 -> 5 -> 2 -> 4 -> 3


public class Practice1_my {
    public static void reorderData(int[] arr) {
        int[] result = new int[arr.length];
        int lt = 0;
        int rt = arr.length - 1;
        int idx = 0;
        while (lt <= rt) {
            result[idx] = (idx++ % 2 == 0) ? arr[lt++] : arr[rt--];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);   // 1 -> 5 -> 2 -> 4 -> 3
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);  // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
