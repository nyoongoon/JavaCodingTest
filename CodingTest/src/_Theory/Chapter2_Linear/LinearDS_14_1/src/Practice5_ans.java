package _Theory.Chapter2_Linear.LinearDS_14_1.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5_ans {

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList();
        apples.add(new ArrayList<>(Arrays.asList(3, 4)));
        apples.add(new ArrayList<>(Arrays.asList(2, 5)));
        apples.add(new ArrayList<>(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList();
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(7, 'D')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 4;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 4)));
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 5;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 6)));
        apples.add(new ArrayList<>(Arrays.asList(1, 7)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));
    }

    public static Integer solution(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {
        int[][] map = new int[n + 1][n + 1];
        for (ArrayList list : apples) {
            int i = (int) list.get(0);
            int j = (int) list.get(1);
            map[i][j] = 1;
        }

        ArrayList<ArrayList<Integer>> direction = new ArrayList<>();
        direction.add(new ArrayList<>(Arrays.asList(0, 1))); // right
        direction.add(new ArrayList<>(Arrays.asList(1, 0))); // down
        direction.add(new ArrayList<>(Arrays.asList(0, -1))); // left
        direction.add(new ArrayList<>(Arrays.asList(-1, 0))); // up

        Queue<ArrayList<Integer>> snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1, 1)));

        int idx = 0;
        int nowTime = 0;
        int row = 1;
        int col = 1;

        while (true) {
            nowTime++;
            row += direction.get(idx).get(0);
            col += direction.get(idx).get(1);

            ArrayList<Integer> head = new ArrayList<>(Arrays.asList(row, col));
            if (1 > row || row >= map.length || 1 > col || col >= map[0].length) {
                return nowTime;
            }
            if (snake.contains(head)) { //동등비교가 되네..
                return nowTime;
            }

            snake.add(head);

            if (map[row][col] == 1) {
                map[row][col] = 0;
            } else {
                snake.poll();
            }

            if(moves.size() > 0 && nowTime == (int) moves.peek().get(0)){
                char dir = (char) moves.peek().get(1);
                if(dir == 'D'){ // 오
                    idx = (idx + 1) % direction.size();
                }else{ //왼
                    idx = (idx - 1 + direction.size()) % direction.size();
                }
                moves.poll();
            }
        }
    }
}
