package _Theory.Chapter2_Linear._13_선형자료구조_연습문제.src;

import java.util.*;

public class Practice5 {

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
        int[][] map = new int[n][n];
        for (ArrayList ll : apples) {
            int i = (int) ll.get(0);
            int j = (int) ll.get(1);
            map[i - 1][j - 1] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        Snake snake = new Snake(map);

        int result = 0;
        int nowTime = 0;
        char toward = 'D';
        for (ArrayList ll : moves) {
            int nextTime = (int) ll.get(0);


            result = go(snake, map, nowTime, toward, nextTime);
            if (result != -1) {
                return result; //time
            }

            nowTime = nextTime;
            toward = (char) ll.get(1);
        }

        return go(snake, map, nowTime, toward, Integer.MAX_VALUE);
    }

    public static int go(Snake snake, int[][] map, int nowTime, char toward, int nextTime) {
        snake.turn(toward);
        while (nowTime < nextTime) {
            nowTime++;
            if (!snake.move()) {
                return nowTime;
            }
        }
        return -1;
    }

    static class Location {
        int row;
        int col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Location)) {
                return false;
            }
            if (this.row == ((Location) obj).row && this.col == ((Location) obj).col) {
                return true;
            }
            return false;
        }
        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
    }

    static class Snake {
        int[] head;
        Queue<Location> tailQueue;
        Set<Location> body;
        String nowDirection;
        int[][] map;

        Snake(int[][] map) {
            this.head = new int[2];
            this.head[0] = 0;
            this.head[1] = 0;

            tailQueue = new LinkedList<>();
            body = new HashSet<>();

            nowDirection = "UP";
            this.map = map;

            addHead();
        }

        public boolean isSafe() {
            // 범위
            if (0 > head[0] || head[0] >= this.map.length ||
                    0 > head[1] || head[1] >= this.map[0].length) {
                return false;
            }

            // body hash 검사
            if (this.body.contains(new Location(head[0], head[1]))) {
                return false;
            }

            return true;
        }

        public boolean hasApple() {
            if (this.map[head[0]][head[1]] == 1) {
                return true;
            }
            return false;
        }

        public boolean move() {
            if (nowDirection.equals("UP")) {
                //헤드 옮기기
                head[0]--;
            }
            if (nowDirection.equals("LEFT")) {
                head[1]--;
            }
            if (nowDirection.equals("RIGHT")) {
                head[1]++;
            }
            if (nowDirection.equals("DOWN")) {
                head[0]++;
            }

            if (!isSafe()) { // 종료!!
                return false;
            }

            addHead();

            if(!hasApple()){
                cutTail();
            }

            return true;
        }

        public void addHead(){
            Location bodyLocation = new Location(this.head[0], this.head[1]);
            this.body.add(bodyLocation);
            this.tailQueue.add(bodyLocation);
        }

        public void cutTail() {
            Location tail = tailQueue.poll();
            body.remove(tail);
        }


        public void turn(char toward) {
            if (toward == 'L') {
                turnLeft();
            } else { //'D'
                turnRight();
            }
        }

        public void turnRight() {
            if (this.nowDirection.equals("UP")) {
                this.nowDirection = "RIGHT";
                return;
            }
            if (this.nowDirection.equals("RIGHT")) {
                this.nowDirection = "DOWN";
                return;
            }
            if (this.nowDirection.equals("LEFT")) {
                this.nowDirection = "UP";
                return;
            }
            if (this.nowDirection.equals("DOWN")) {
                this.nowDirection = "LEFT";
                return;
            }
        }

        public void turnLeft() {
            if (this.nowDirection.equals("UP")) {
                this.nowDirection = "LEFT";
                return;
            }
            if (this.nowDirection.equals("RIGHT")) {
                this.nowDirection = "UP";
                return;
            }
            if (this.nowDirection.equals("LEFT")) {
                this.nowDirection = "DOWN";
                return;
            }
            if (this.nowDirection.equals("DOWN")) {
                this.nowDirection = "RIGHT";
                return;
            }
        }
    }
}
