package _Theory.Chapter2_Linear.선형자료구조_코딩테스트;

import java.util.Arrays;

public class Linear_TEST_02_05_ans {

    public static void main(String[] args) { // ans 풀어보기...
        int[][] image = {
                {4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        int K = 3;

        printTwoDimensionArr(solution(image, K));
    }

    public static int[][] solution(int[][] image, int K) {
        int n = (K - 1) / 2;
        int N = K * K;
        int height = image.length;
        int width = image[0].length;
        int sum = 0;
        int[][] result = new int[height][width];

        int[] removed;

        SlidingWindow slidingWindow = new SlidingWindow(K);

        //초기화
        for (int i = 0; i < K - 1; i++) {
            for (int j = 0; j < K; j++) {
                int iImage = i - n;
                int jImage = j - n;
                int[] values = new int[K];
                if (0 <= iImage && iImage < height && 0 <= jImage && jImage < width) {
                    values[j] = image[iImage][jImage];
                }
                removed = slidingWindow.shiftDown(values);

                sum += Arrays.stream(values).sum();
                sum -= Arrays.stream(removed).sum();
            }
        }

        int j = -1;
        for (int i = 0; i < height; i++) {
            // 내려가기
            if (i % 2 == 0) {
                j = 0;
            } else {
                j = width - 1;
            }
            for (int jWin = 0; jWin < K; jWin++) {
                int iImage = i + n;
                int jImage = j - n + jWin;
                int[] values = new int[K];
                // if 조건 인덱싱
                if (0 <= iImage && iImage < height && 0 <= jImage && jImage < width) {
                    values[jWin] = image[iImage][jImage];
                }
                removed = slidingWindow.shiftDown(values);

                sum += Arrays.stream(values).sum();
                sum -= Arrays.stream(removed).sum();
            }
            result[i][j] = sum / N;


            if (i % 2 == 0) {
                //오른쪽
                for (j = 1; j < width; j++) {
                    for (int iWin = 0; iWin < K; iWin++) {
                        int iImage = i - n + iWin;
                        int jImage = j + n;
                        int[] values = new int[K];
                        if (0 <= iImage && iImage < height && 0 <= jImage && jImage < width) {
                            values[iWin] = image[iImage][jImage];
                        }
                        removed = slidingWindow.shiftRight(values);

                        sum += Arrays.stream(values).sum();
                        sum -= Arrays.stream(removed).sum();

                    }
                    result[i][j] = sum / N;
                }

            } else {
                // 왼쪽
                for (j = width - 2; j >= 0; j--) {
                    for (int iWin = 0; iWin < K; iWin++) {
                        int iImage = i - n + iWin;
                        int jImage = j - n;
                        int[] values = new int[K];
                        if (0 <= iImage && iImage < height && 0 <= jImage && jImage < width) {
                            values[i] = image[iImage][jImage];
                        }
                        removed = slidingWindow.shiftLeft(values);

                        sum += Arrays.stream(values).sum();
                        sum -= Arrays.stream(removed).sum();
                    }

                    result[i][j] = sum / N;
                }
            }
        }

        return result;
    }


    public static void printTwoDimensionArr(int[][] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    int value;
    Node right;
    Node bottom;

    Node() {
    }

    Node(int value) {
        this.value = value;
    }
}

class SlidingWindow {
    Node head;
    int K;

    SlidingWindow(int K) {
        this.head = new Node();
        this.K = K;
        Node curr = this.head;
        for (int i = 0; i < K - 1; i++) {
            curr.right = new Node();
            curr = curr.right;
        }


        Node upperFirst = this.head;
        for (int i = 0; i < K - 1; i++) {
            Node upper = upperFirst;
            upper.bottom = new Node();
            curr = upper.bottom;
            for (int j = 0; j < K - 1; j++) {
                upper = upper.right;
                upper.bottom = new Node();

                curr.right = upper.bottom;
                curr = curr.right;
            }
            upperFirst = upperFirst.bottom;
        }
    }

    public int[] shiftDown(int[] values) {
        int[] removed = new int[values.length];
        Node down = this.head;
        for (int i = 0; i < K - 1; i++) {
            down = down.bottom;
        }
        down.bottom = new Node(values[0]);
        Node curr = down.bottom;
        for (int i = 1; i < K; i++) {
            down = down.right;
            down.bottom = new Node(values[i]);

            curr.right = down.bottom;
            curr = curr.right;
        }

        curr = this.head;
        for (int i = 0; i < K - 1; i++) {
            removed[i] = curr.value;
            curr.bottom = null;
            curr = curr.right;
        }

        return removed;
    }

    public int[] shiftRight(int[] values) {
        Node left = this.head;
        for (int i = 0; i < K - 1; i++) {
            left = left.right;
        }

        left.right = new Node(values[0]);
        Node curr = left.right;

        for (int i = 1; i < K; i++) {
            left = left.bottom;
            left.right = new Node(values[i]);
            curr.bottom = left.right;
            curr = left.right;
        }

        int[] removed = new int[values.length];
        curr = this.head;
        for (int i = 0; i < K; i++) {
            removed[i] = curr.value;
            curr.right = null;
            curr = curr.bottom;
        }

        return removed;
    }

    public int[] shiftLeft(int[] values) {
        Node left = this.head;
        for (int i = 0; i < K; i++) {
            left = left.right;
        }

        int[] removed = new int[values.length];
        for (int i = 0; i < K - 1; i++) {
            removed[i] = left.right.value;
            left.right = null;
            left = left.bottom;
        }

        left = new Node(values[0]);
        Node curr = this.head;
        for (int i = 1; i < K; i++) {
            left.right = curr;
            left.bottom = new Node(values[i]);

            left = left.bottom;
            curr = curr.bottom;
        }
        return removed;
    }
}






