package Base_CodingTest.W2;

import java.util.Arrays;

public class Week2_1_ans {
    public static void main(String[] args) {
        int[] numbers = {10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35, 36, 37, 38, 40, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 72, 73, 74, 75, 76, 77, 79, 81, 82, 83, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 96, 97, 98, 99};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] + 1 != numbers[i + 1]){
                return numbers[i] + 1;
            }
        }

        return -1;
    }
}
