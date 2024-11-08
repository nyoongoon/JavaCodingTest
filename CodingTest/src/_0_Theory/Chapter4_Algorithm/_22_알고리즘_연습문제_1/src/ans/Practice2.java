package _0_Theory.Chapter4_Algorithm._22_알고리즘_연습문제_1.src.ans;

public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }
        int[] selected = new int[types + 1];
        int p1 = 0;
        int p2 = p1 + n - 1;

        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i = p1; i <= p2; i++) {
            if (selected[i] == 0) {
                cnt++;
            }
            selected[i] += 1;
        }

        max = getMax(coupon, selected, max, cnt);

        for (int i = 1; i < plates.length; i++) {
            p1 = i;
            p2 = (p1 + n - 1) % plates.length;

            //p1-1에 -1 하기
            selected[p1 - 1] -= 1;
            if (selected[p1 - 1] == 0) {
                cnt--;
            }

            //p2에 +1 하기
            if (selected[p2] == 0) {
                cnt++;
            }
            selected[p2] += 1;

            max = getMax(coupon, selected, max, cnt);
        }


        return max;
    }

    private static int getMax(int coupon, int[] selected, int max, int cnt) {
        if (selected[coupon] == 0) {
            max = Math.max(max, cnt + 1);
        } else {
            max = Math.max(max, cnt);
        }
        return max;
    }


    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
