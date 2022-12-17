package Sort;

public class MergeSort_re {

    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, right, mid);
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int idx = left;
        int lt = left;
        int rt = mid + 1;
        while (lt < rt && lt <= mid && rt <= right) {
            if (arr[lt] > arr[rt]) {
                tmp[idx++] = arr[rt++];
            } else {
                tmp[idx++] = arr[lt++];
            }
        }

        while (lt <= mid) {
            tmp[idx++] = arr[lt++];
        }
        while (rt <= right) {
            tmp[idx++] = arr[rt++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
