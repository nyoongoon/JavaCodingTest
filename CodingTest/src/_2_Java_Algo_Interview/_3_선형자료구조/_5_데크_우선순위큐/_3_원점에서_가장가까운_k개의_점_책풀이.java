package _2_Java_Algo_Interview._3_선형자료구조._5_데크_우선순위큐;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 유클리드 거리 생략하여 계산하기
 * -> 계산법으로 거리 차제값을 응요하는 것이 아니라 서로 비교하는 것이기 때문에
 * -> 완전한 거리 계산을 하지 않아도 된다는 개념..
 *
 * - Comparator.comparingDouble(p->p.distance)로도 가능
 */
public class _3_원점에서_가장가까운_k개의_점_책풀이 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(p->p.distance));
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
//            double distance;
            long distance;

            Point(int[] position, int order) {
                this.position = position;
                int x = position[0];
                int y = position[1];
                this.distance = (long) (Math.pow(x, 2) + Math.pow(y, 2));
            }
        }
    }
}
