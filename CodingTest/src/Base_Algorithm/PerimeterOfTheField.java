package Base_Algorithm;

public class PerimeterOfTheField {
    public static int solution(int[][] grid) {
        int result = 0;
        // 행 x 렬
        int[][] chkArr = {{-1, 0}, {0, +1}, {1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    // 4 더하기
                    // 동서남북 체크해서 1이면 1씩 빼기
                    int[] nowLoc = {i, j};
                    result = chk(grid, chkArr, nowLoc, result);
                }
            }
        }
        return result;
    }

    public static int chk(int[][] grid, int[][] chkArr, int[] nowLoc, int result) {
        for (int i = 0; i < chkArr.length; i++) {
            int row = chkArr[i][0] + nowLoc[0];
            int col = chkArr[i][1] + nowLoc[1];
            if(row >= 0 && row < grid.length && col >= 0 && col <grid[0].length && grid[row][col] == 1){
                //System.out.println("in");
                result -= 1;
            }
        }
        return result;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int[][] directions = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    int result = recursion(grid, directions, i, j);

                    return result;
                }
            }
        }


        return 0;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {
        int[][] chkArr = {{-1, 0}, {0, +1}, {1, 0}, {0, -1}};
        int result = 0;
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0){
            return 1;
        }

        if (directions[i][j] == 1) {
            return 0;
        }else{
            directions[i][j] = 1;
        }


        for (int k = 0; k < chkArr.length; k++) {
            int row = i + chkArr[k][0];
            int col = j + chkArr[k][1];
            result += recursion(grid, directions, row, col);
        }

        return result;
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
