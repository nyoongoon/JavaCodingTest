package Sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) { // 종료조건 주의... 마지막 리프노드의 부모노드 부터 시작된 것..! //
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }
    public static void heapify(int[] arr, int parentIdx, int size) {//힙으로 바꿔줌
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]){
            maxIdx = leftIdx;
        }
        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]){
            maxIdx = rightIdx;
        }
        if(parentIdx != maxIdx){ // 교체가 되었을 경우
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size); // 추가적으로 자리교체 필요할 수 있음 ?? 왜지 ??
        }

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
    }
}
