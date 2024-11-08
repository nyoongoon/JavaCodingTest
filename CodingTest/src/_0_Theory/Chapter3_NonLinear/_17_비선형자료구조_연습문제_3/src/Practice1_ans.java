package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

public class Practice1_ans {

    static boolean[][] normalView;
    static boolean[][] rgView;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void solution(char[][] picture) {
        normalView = new boolean[picture.length][picture[0].length];
        rgView = new boolean[picture.length][picture[0].length];

        int nomalCnt = 0;
        int rgCnt = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                char color = picture[i][j];

                if (!normalView[i][j]) { // 방문한적 없음
                    normalDfs(picture, color, i, j);
                    nomalCnt++;
                }

                if (!rgView[i][j]) {
                    rgDfs(picture, color, i, j);
                    rgCnt++;
                    System.out.println("i == " + i + " j == " + j);
                }
            }
        }

        System.out.println("일반: " + nomalCnt);
        System.out.println("정녹: " + rgCnt);
    }

    private static void normalDfs(char[][] picture, char color, int i, int j) {
        //들어오면 true
        normalView[i][j] = true;

        //4번 순회
        for (int k = 0; k < dir.length; k++) {
            int nextI = i + dir[k][0];
            int nextJ = j + dir[k][1];



            // 숫자 범위 체크
            if (nextI < 0 || nextI >= picture.length || nextJ < 0 || nextJ >= picture[0].length) {
                continue;
            }

            if(normalView[nextI][nextJ]){
                continue;
            }

            System.out.println("nextI == " + nextI + " nextJ == " + nextJ);

            // 색깔 체크
            char nextColor = picture[nextI][nextJ];
            if (color == nextColor) {
                normalDfs(picture, color, nextI, nextJ);
            }

            //  -> dfs
        }
    }

    private static void rgDfs(char[][] picture, char color, int i, int j) {
        //들어오면 true
        rgView[i][j] = true;

        //4번 순회
        for (int k = 0; k < dir.length; k++) {
            int nextI = i + dir[k][0];
            int nextJ = j + dir[k][1];

            // 숫자 범위 체크
            if (nextI < 0 || nextI >= picture.length || nextJ < 0 || nextJ >= picture[0].length) {
                continue;
            }

            if(rgView[nextI][nextJ]){
                continue;
            }

            // 색깔 체크
            //  -> dfs
            char nextColor = picture[nextI][nextJ];
            if (color == nextColor || (color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')) {
                rgDfs(picture, color, nextI, nextJ);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] pictures = {
                {'R', 'R', 'R', 'B', 'B'},
                {'G', 'G', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'},
                {'R', 'R', 'R', 'R', 'R'}};
        solution(pictures); // 4 3
    }
}
