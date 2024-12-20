package _0_Theory.Chapter2_Linear._10_데크_연습문제.src;// Practice1
// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터: 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터: 1 -> 5 -> 2 -> 4 -> 3


import java.util.stream.IntStream;

public class Practice1 {
    public static void reorderData(int[] arr) {
        int front = 0;
        int rear = arr.length- 1;
        int[] result = new int[arr.length];
        int idx = 0;

        while(front <= rear){
            result[idx++] = arr[front++];

            if(idx < arr.length - 1){
                result[idx++] = arr[rear--];
            }
        }

        IntStream.range(0, result.length).forEach((x)-> System.out.print(result[x] + " "));
        System.out.println();
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr);   // 1 -> 5 -> 2 -> 4 -> 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);  // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
    }
}
