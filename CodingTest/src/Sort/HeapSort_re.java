package Sort;

public class HeapSort_re {
    static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, 0, arr.length);
        }

        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
        
    }
    
    static void heapify(int[] arr, int parentIdx, int size){
        int maxIdx = parentIdx;
        int lt = parentIdx * 2 + 1;
        int rt = parentIdx * 2 + 2;
        
        if(lt < size && arr[maxIdx] < arr[lt]){
            maxIdx = lt;
        }

        if(rt < size && arr[maxIdx] < arr[rt]){
            maxIdx = rt;
        }
        
        if(maxIdx != parentIdx){
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    static void swap(int[] arr, int a, int b){
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
