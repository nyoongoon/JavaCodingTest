package _2_Java_Algo_Interview._3_선형자료구조._5_데크_우선순위큐;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Math.sqrt의 리턴값이 double인 것 주의
 * double의 값으로 Comparator 구할 때 (int) x-y 형식으로 계산하면 안됨
 */
public class _3_원점에서_가장가까운_k개의_점_내풀이 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> pq = new PriorityQueue<>((x, y) -> {
                if (x.distance == y.distance) {
                    return 0;
                } else if (x.distance < y.distance) {
                    return -1;
                } else {
                    return 1;
                }
            });
            for (int i = 0; i < points.length; i++) {
                Point p = new Point(points[i], i);
                pq.add(p);
            }

            List<int[]> result = new ArrayList<>();
            int cnt = 0;
            while (!pq.isEmpty()) {
                Point p = pq.poll();
                if (cnt < k) {
                    result.add(p.position);
                    cnt++;
                } else {
                    break;
                }
            }

            return result.toArray(new int[0][]);
        }

        static class Point {
            int[] position;
            int order;
            double distance;

            Point(int[] position, int order) {
                this.position = position;
                int x = position[0];
                int y = position[1];
                // System.out.println("x == " + x);
                // System.out.println("y == " + y);
                this.distance = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
                // System.out.println("distance == " + distance);
            }
        }
    }
}
