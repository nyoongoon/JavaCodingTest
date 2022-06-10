import java.util.Scanner;

public class N12_Mentoring {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int m = stdIn.nextInt();
        int n = stdIn.nextInt();
        int cnt = 0;

        int[][] examResult = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                examResult[i][j] = stdIn.nextInt();
            }
        }

        // M번의 수학테스트 등수
        // A멘토 B멘티 ==> A가 모두 B 보다 등수 앞 서야 함
        // M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 ?


        // 1이 멘토일 경우 -> 12, 13, 14
        // 2 -> 21, 23, 24
        // 3 -> 31, 32, 34
        // 4 -> 41, 42, 43
        // => 가능성 줄여나가기
        // => 시험성적 a > b 경우 => b가 멘토 a가 멘티가 되는 경우의 수 소거

        boolean[][] chk = new boolean[m][m];
        for (int i = 0; i < chk.length; i++) {
            for (int j = 0; j < chk[i].length; j++) {
                if (i != j) {
                    chk[i][j] = true;
                }
            }
        }

        // i 가 멘토일 경우
        for (int i = 0; i < examResult.length; i++) {
            for (int j = 0; j < examResult[i].length; j++) {
                int mento = examResult[i][j]; // 멘토
                for(int k = j; k<examResult[i].length; k++){
                    int menti = examResult[i][k]; // 멘티
                    if (chk[menti-1][mento-1]) {
                        chk[menti-1][mento-1] = false;
                    }
                }
            }
        }

        for (int i = 0; i < chk.length; i++) {
            for (int j = 0; j < chk[i].length; j++) {

                if (chk[i][j]) {
                    cnt++;
                }else{
                }
            }
        }

        System.out.println(cnt);
    }

}
