package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src.re;// 퀵 정렬

public class Main3 {
    public static void quickSort(int[] arr, int left, int right) {


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
