package _Theory.Chapter3_NonLinear._15_비선형자료구조_연습문제.src;

public class Practice5 {

    public static int solution(int[] forbidden, int a, int b, int x) {

        return move(0, forbidden, a, b, x, false, 0);
    }

    public static int move(int times, int[] forbidden, int a, int b, int x, boolean wasBackward, int now) {
        if (now == x) { // 목적지 체크
            return times;
        }
        if (now < 0) { //음수 체크
            return -1;
        }
        for (int i = 0; i < forbidden.length; i++) { // 금지 체크
            if (now == forbidden[i]) {
                return -1;
            }
        }
        //범위 넘김 체크    9   > 0   15
        //               1    5    2
        if(now > x + b){
//            System.out.println(times);
            return -1;
        }

        // forward
        int result = forward(times, forbidden, a, b, x, wasBackward, now);
        if (result != -1) {
            return result;
        }
        //backward
        if(!wasBackward){
            result = backward(times, forbidden, a, b, x, wasBackward, now);
            if(result != -1){
                return result;
            }
        }

        return -1;
    }

    public static int forward(int times, int[] forbidden, int a, int b, int x, boolean wasBackward, int now) {
        return move(times + 1, forbidden, a, b, x, false, now + a);
    }

    public static int backward(int times, int[] forbidden, int a, int b, int x, boolean wasBackward, int now) {
        return move(times + 1, forbidden, a, b, x, true, now - b);
    }

    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));
    }
}
