package _Theory.Chapter2_Linear._02_배열_연습문제.src;
// 배열 arr 의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr: 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과:
// 짝수 평균: 5.0
// 홀수 평균: 5.0

public class Practice1_re {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double evenMean = getEvenMean(arr);
        System.out.println(evenMean);
        double oddMean = getOddMean(arr);
        System.out.println(oddMean);
    }

    public static double getEvenMean(int[] arr) {
        int idx;
        int sum = 0;
        for (idx = 1; idx < arr.length; idx += 2) {
            sum += arr[idx];
        }
        double denominator = (idx - 1) / 2.0;
        System.out.println("denominator == " + denominator);
        return sum / denominator;
    }

    public static double getOddMean(int[] arr) {
        int idx;
        int sum = 0;
        for (idx = 0; idx < arr.length; idx += 2) {
            sum += arr[idx];
        }
        double denominator = (idx) / 2;
        System.out.println("denominator == " + denominator);
        return sum / denominator;
    }


}
