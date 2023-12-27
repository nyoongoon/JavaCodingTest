package _Theory.Chapter2_Linear.LinearDS_03.src;// Practice4
// 배열 arr 에서 peek 값 모두 출력

// 입출력 예시)
// arr: 3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11
// 결과: 3, 6, 5, 10, 11

public class Practice4_re {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        printPeek(arr);

    }

    public static void printPeek(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            if (i == 0 && checkAfter(arr, i)) {
                System.out.print(arr[i] + ", ");
                continue;
            }


            if (checkBefore(arr, i) && checkAfter(arr, i)) {
                System.out.print(arr[i] + ", ");
                continue;
            }


            if (i == arr.length - 1 && checkBefore(arr, i)) {
                System.out.print(arr[i]);
                continue;
            }
        }
    }

    public static boolean checkBefore(int[] arr, int idx) {
        if (idx < 1 || idx >= arr.length) {
            return false;
        }

        if(arr[idx - 1] < arr[idx] ){
            return true;
        }

        return false;
    }

    public static boolean checkAfter(int[] arr, int idx) {
        if (idx < 0 || idx >= arr.length - 1) {
            return false;
        }

        if(arr[idx] > arr[idx + 1]){
            return true;
        }

        return false;
    }
}
