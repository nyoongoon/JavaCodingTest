package _Theory.Chapter4_Algorithm._11_분할정복.src;

public class Main {

    public static int getMax(int[] arr, int left, int right) {
        if (right == left) {
            return arr[left];
        }

        int m = (left + right) / 2;

        int leftMax = getMax(arr, left, m);
        int rightMax = getMax(arr, m + 1, right);

        return leftMax > rightMax ? leftMax : rightMax;
    }


    public static void main(String[] args) {
        int arr[] = {6, 2, 9, 8, 1, 4, 17, 5};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
