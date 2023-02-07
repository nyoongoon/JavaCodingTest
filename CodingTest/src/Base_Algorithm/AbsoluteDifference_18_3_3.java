package Base_Algorithm;

public class AbsoluteDifference_18_3_3 {
    public static void solution(int[] arr, int k, int x) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int len = Math.min(arr.length, k);
        int[] result = new int[len];
        int basis = x;

        for (int i = 0; i < arr.length; i++) {
            arr[i] -= basis;
        }

        //for (int i = 0; i < arr.length ; i++) { // 절대값 같은 경우 작은 인덱스가 먼저 들어가야함 !
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(Math.abs(arr[i]) < min){
                min = Math.abs(arr[i]);
                minIdx = i;
            }
        }

        // System.out.println(arr[minIdx]);
        //System.out.println(arr[minIdx] + basis);
        result[k/2] = arr[minIdx]+basis;

        int tmp = 1;
        while(k/2 - tmp >= 0 && minIdx - tmp >= 0){
            //while(minIdx - tmp >= 0){
            result[k/2 - tmp] = arr[minIdx - tmp] + basis;
            tmp++;
        }
        tmp = 1;
        //System.out,printLN9
        while(k/2 + tmp < result.length){
            result[k/2 + tmp] = arr[minIdx + tmp] + basis;
            tmp++;
        }

        for(int n : result){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr, 4, 3);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        solution(arr, 5, 5);

        arr = new int[]{2, 4};
        solution(arr, 1, 3);

        arr = new int[]{2, 4};
        solution(arr, 3, 3);
    }
}
