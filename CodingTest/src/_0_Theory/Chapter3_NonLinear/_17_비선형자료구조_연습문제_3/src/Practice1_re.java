package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

public class Practice1_re {
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void solution(char[][] picture) {
        boolean[][] standardVisited = new boolean[picture.length][picture[0].length];
        int cnt = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                cnt = search(picture, standardVisited, i, j, false, cnt);
            }
        }
        System.out.println("일반: " + cnt);
        boolean[][] colorlessVisited = new boolean[picture.length][picture[0].length];
        cnt = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                cnt = search(picture, colorlessVisited, i, j, true, cnt);
            }
        }
        System.out.println("적록색약: " + cnt);
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

    public static int search(char[][] picture, boolean[][] visited, int i, int j, boolean isColorless, int cnt) {
        if (dfs(picture, visited, i, j, picture[i][j], isColorless, false)) {
            cnt++;
        }
        return cnt;
    }

    public static boolean dfs(char[][] picture, boolean[][] visited, int i, int j, char color, boolean isColorless, boolean isSearched) {
        if (i < 0 || i >= picture.length || j < 0 || j >= picture[i].length) {
            return isSearched;
        }
        if (!isColorless && picture[i][j] != color) {
            return isSearched;
        }
        if (isColorless && !isColorlessMatch(picture[i][j], color)) {
            return isSearched;
        }

        if (visited[i][j]) {
            return isSearched;
        }

        visited[i][j] = true;
        for (int k = 0; k < moves.length; k++) {
            int nextI = i + moves[k][0];
            int nextJ = j + moves[k][1];
            isSearched = dfs(picture, visited, nextI, nextJ, color, isColorless, true);
        }

        return isSearched;
    }

    private static boolean isColorlessMatch(char picture, char color) {
        if (picture == color) {
            return true;
        }
        if (picture == 'R' && color == 'G') {
            return true;
        }
        if (picture == 'G' && color == 'R') {
            return true;
        }

        return false;
    }


}
