package Base_Algorithm.Chapter2_Linear.LinearDS_03.src;// Practice3
// 배열 arr 의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

// 입출력 예시)
// arr: 1, 3, 5, 7, 9
// 결과: 9, 7, 5, 3, 1

public class Practice3 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;

            left++;
            right--;
        }

        for(int n : arr){
            System.out.print(n + " ");
        }
    }
}
