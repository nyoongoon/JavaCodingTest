package Sort;

public class MergeSort {

    static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid+1, right);

        merge(arr, tmp, left, right);
    }

    static void merge(int[]arr, int[] tmp, int left, int right){
        int mid = (left + right) / 2;
        int lt = left;
        int rt = mid + 1;
        int idx = left;

        while(lt <= mid && rt <= right){
            if(arr[lt] < arr[rt]){
                tmp[idx++] = arr[lt++];
            }else{
                tmp[idx++] = arr[rt++];
            }
        }

        while(lt<=mid){
            tmp[idx++] = arr[lt++];
        }
        while(rt<=right){
            tmp[idx++] = arr[rt++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int [] tmp = new int[arr.length];
        mergeSort(arr, tmp,  0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
