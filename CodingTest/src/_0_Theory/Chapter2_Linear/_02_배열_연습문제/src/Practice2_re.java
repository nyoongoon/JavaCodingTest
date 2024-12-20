package _0_Theory.Chapter2_Linear._02_배열_연습문제.src;// Practice2
// 배열 arr 에서 target 에 해당하는 값의 인덱스를 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 입출력 예시)
// 배열 arr: 1, 1, 100, 1, 1, 1, 100
// 결과: 6

public class Practice2_re {
    public static void main(String[] args) {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        findMaxIdx(arr, 100);
    }

    public static int findMaxIdx(int[] arr, int target){
        int idx = -1;

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == target){
                idx = i;
            }
        }

        if(idx == -1){
            System.out.println("값을 찾을 수 없음");
            return -1;
        }

        return idx;
    }

}
