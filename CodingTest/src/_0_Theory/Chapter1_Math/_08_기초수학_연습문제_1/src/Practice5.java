package _0_Theory.Chapter1_Math._08_기초수학_연습문제_1.src;

public class Practice5 { // 재귀로 풀 수 있지 않을까.. visited배열하고 가티 해서...
    static boolean[][] visited;

    public static int solution(int[][] grid) {
        //-1,0 , 0,1  , 1,0  , 0,-1


        visited = new boolean[grid.length][grid[0].length];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, directions, i, j);
                }
            }
        }

        return -1;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] != 1){
                    continue;
                }

                for (int k = 0; k < directions.length; k++) {
                    int row = i + directions[k][0];
                    int col = j + directions[k][1];

                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                    || grid[row][col] == 0){
                        sum++;
                    }
                }

            }
        }


        return sum;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
                grid[i][j] == 0) {
            return 1;
        }
        if (visited[i][j]) {
            return 0;
        }

        int len = 0;
        visited[i][j] = true;

        for (int k = 0; k < directions.length; k++) {
            len += recursion(grid, directions, i + directions[k][0], j + directions[k][1]);
        }

        return len;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
