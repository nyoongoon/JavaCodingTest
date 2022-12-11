package LinearDS_03.src;// Practice7
// 2차원 배열 arr 을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5


public class Practice7 {
    public static void main(String[] args) {
        int[][] arr = new int[3][5];
        int[][] reversed = new int[5][3];
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n++;
            }
        }

        for (int i = 0; i < reversed.length; i++) {
            for (int j = 0; j < reversed[i].length; j++) {
                reversed[i][reversed[i].length-1-j] = arr[j][i];
            }
        }

        for (int i = 0; i < reversed.length; i++) {
            for (int j = 0; j < reversed[i].length; j++) {
                System.out.print(reversed[i][j] + " ");
            }
            System.out.println();
        }
    }
}
