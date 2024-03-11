package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제_1.src;

import java.util.*;

public class Practice4 {

    public static int solution(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));

        Queue<Lock> queue = new LinkedList<>();
        int[] initArr = new int[]{0, 0, 0, 0};

        if (addArrToSet(initArr, visited)) {
            queue.add(new Lock(initArr, 0));
        }

        return bfs(queue, deadendsSet, target, visited);
    }

    private static boolean addArrToSet(int[] initArr, Set<String> visited) {
        StringBuffer sb = new StringBuffer();
        for (int i : initArr) {
            sb.append(i);
        }
        return visited.add(sb.toString());
    }

    private static boolean containsArrToSet(int[] curArr, Set<String> deadendsSet) {
        StringBuffer sb = new StringBuffer();
        for (int i : curArr) {
            sb.append(i);
        }
        return deadendsSet.contains(sb.toString());
    }

    public static int bfs(Queue<Lock> queue, Set<String> deadendsSet, String target, Set<String> visited) {

        while (!queue.isEmpty()) {
            Lock curLock = queue.poll();
            int[] curArr = curLock.arr;

//            System.out.println(Arrays.toString(curArr));

            if (isTarget(curArr, target)) {
//                System.out.println("isTarget() == " + Arrays.toString(curArr));
                return curLock.moves;
            }

            if (containsArrToSet(curArr, deadendsSet)) {
                continue;
            }

            for (int i = 0; i < curArr.length; i++) {

                int[] copyPlus = curArr.clone();
                int[] copyMinus = curArr.clone();
                copyPlus[i] = copyPlus[i] + 1 == 10 ? 0 : copyPlus[i] + 1;
                copyMinus[i] = copyMinus[i] - 1 == -1 ? 9 : copyMinus[i] - 1;

                if (addArrToSet(copyPlus, visited)) {
                    queue.add(new Lock(copyPlus, curLock.moves + 1));
                }
                if (addArrToSet(copyMinus, visited)) {
                    queue.add(new Lock(copyMinus, curLock.moves + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isTarget(int[] curArr, String target) {
        StringBuffer sb = new StringBuffer();
        for (int i : curArr) {
            sb.append(i);
        }
        return target.equals(sb.toString());
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));

    }

    public static class Lock {
        int[] arr;
        int moves;

        public Lock(int[] arr, int moves) {
            this.arr = arr;
            this.moves = moves;
        }
    }
}
