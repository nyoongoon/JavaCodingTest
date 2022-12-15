package Sort;

public class HeapSort_re {

    public static void heapSort(int [] arr){
        for (int i = arr.length / 2 - 1; i >=0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr ,int parentIdx, int size){
        int maxIdx = parentIdx;
        int left = parentIdx * 2 + 1;
        int right = parentIdx * 2 + 2;

        if(left < size && arr[maxIdx] < arr[left]){

            maxIdx = left;
        }
        if(right < size && arr[maxIdx] < arr[right]){

            maxIdx = right;
        }

        if(maxIdx != parentIdx){
            swap(arr, parentIdx, maxIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
