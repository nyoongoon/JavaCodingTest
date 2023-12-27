package _Theory.Chapter2_Linear;

public class Linear_TEST_02_02 {

    public static void main(String[] args) {
        int[] a = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b = {2, 0, 0, 6, 3, 4, 5, 3, 6, 7}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result = solution(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        int[] a1 = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b1 = {0}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result1 = solution(a1, b1);

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        int[] a2 = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b2 = {}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result2 = solution(a2, b2);

        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] a, int[] b) {

        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }

        int size;
        // ㅂㅐ열 길이가 증가하는 경우 체크
        if (a.length == b.length && a[0] + b[0] >= 10) {
            size = a.length + 1;
        } else {
            if (a.length > b.length) {
                size = a.length;
            } else if (a.length < b.length) {
                size = b.length;
            } else {//a.length == b.length
                size = a.length;
            }
        }
        int[] result = new int[size];

        int aIdx = a.length - 1;
        int bIdx = b.length - 1;
        int resultIdx = size - 1;
        while (aIdx >= 0 || bIdx >= 0) {
            int aValue = aIdx >= 0 ? a[aIdx] : 0;
            int bValue = bIdx >= 0 ? b[bIdx] : 0;


            result[resultIdx] += (aValue + bValue) % 10;
//            System.out.println("resultIdx  " + resultIdx);
//            System.out.println("aIdx  " + aIdx);
//            System.out.println("bIdx  " + bIdx);
            if (resultIdx - 1 >= 0) {
                result[resultIdx - 1] += (resultIdx != 0 && aValue + bValue >= 10) ? 1 : 0;
            }

            aIdx--;
            bIdx--;
            resultIdx--;
        }
        return result;
    }
}




