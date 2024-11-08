package _0_Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src;// 퀵 정렬

public class Main3 {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int lo = left; //arr[lo]가 arr[pivot]보다 큰 값 찾기
        int hi = right; //arr[hi]가 arr[pivot]보다 작거나 같은 값 찾기

        while (lo < hi) {
            // lo를 먼저 찾으면 안되는 이유 -> 제자리 스왑 이슈
            // -> 왼쪽 피벗인 경우 arr[pivot]은 스왑후의 arr[lo]보다 항상 커야함. 스왑후의 arr[hi]보다 작은 경우는 ㄱㅊ -> 피벗과 최종스왑은 lo와 하므로

            // ex) 3 2 4 의 경우
            // lo를 먼저 찾으면 4가 lo와 hi로서 제자리 스왑-> 스왑 후에도 arr[lo]가 arr[pivot]보다 큰 경우가 발생 -> 정상적인 경우 스왑이 이루어져서 arr[lo]는 arr[pivot]보다 작아짐
            // hi를 먼저찾으면 2가 lo와 hi로서 제자리 스뢉 -> 스왑 후에도 arr[hi]가 arr[pivot]보다 작아지는 경우 발생 -> 하지만 스왑은 lo와 하므로
            // -> 스왑 후에도 arr[hi]가 arr[pivot]보다 작아지는 경우가 발생하여도 이상 없음

//            while (arr[lo] <= arr[pivot] && lo < hi) { 왼쪽 피벗의 경우 lo를 먼저 찾으면 안됨 !
//                lo++;
//            }

            // arr[hi]가 arr[pivot] 보다 작거나 같은 것 찾기  --> hi를 반드시 먼저 찾아야함!
            while (arr[hi] > arr[pivot] && lo < hi) {
                hi--;
            }

            // arr[lo]가 arr[pivot] 보다 큰 것 찾기
            while (arr[lo] <= arr[pivot] && lo < hi) {
                lo++;
            }

            swap(arr, lo, hi);
        }

        swap(arr, pivot, lo);

        return lo;
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("[swap] " + arr[i] + "(" + i + ") <->" + arr[j] + "(" + j + ")");
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
    }
}
