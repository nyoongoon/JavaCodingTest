package _2_Java_Algo_Interview._5_데크_우선순위큐;

public class _3_원점에서_가장가까운_k개의_점_내풀이 {
    class Solution {
        static class Point{
            int[] position;
            int order;
            int distance;
            Point(int[] position, int order){
                this.position = position;
                int x = position[0];
                int y = position[1];
                System.out.println("x == " + x);
                System.out.println("y == " + y);
                this.distance = (int) Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
                System.out.println("distance == " + distance);
            }
        }
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
            for(int[] point: points){
                Point p = new Point(point);
                pq.add(p);
            }

            List<int[]> result = new ArrayList<>();
            int cnt = 0;
            while(!pq.isEmpty()){
                Point p = pq.poll();
                if(cnt < k){
                    result.add(p.position);
                    cnt++;
                }else{
                    break;
                }
            }

            return result.toArray(new int[0][]);
        }
    }
}
