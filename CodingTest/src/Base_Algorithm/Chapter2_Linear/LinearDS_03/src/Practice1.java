package Base_Algorithm.Chapter2_Linear.LinearDS_03.src;// Practice1
// 배열 arr 의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        float[] result = arrayMean(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static float[] arrayMean(int[] arr) {
        float[] resultArr = new float[2];
        float oddSum = 0;
        int oddSize = 0;
        float evenSum = 0;
        int evenSize = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0){
                System.out.println("i== " + i);
                oddSum += arr[i];
                oddSize++;
            }else{
                System.out.println("i!= " + i);
                evenSum += arr[i];
                evenSize++;
            }
        }

        resultArr[0] = oddSum / oddSize;
        resultArr[1] = evenSum / evenSize;

        return resultArr;
    }
}
