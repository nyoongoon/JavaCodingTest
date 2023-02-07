package Base_Algorithm;

import java.util.Random;

public class ElectionSimulation {
    public static void main(String[] args) {
        Random random = new Random();
        String[] name = {"이재명", "윤석열", "심상정", "안철수"};
        int[] candidate = {0, 0, 0, 0};


        for (int i = 0; i < 100001; i++) {
            int idx = random.nextInt(4);
            candidate[idx] = candidate[idx] + 1;
            System.out.printf("[투표진행율]: %2.2f%%, %d명 투표 => %s%n", i / 100000f * 100, i, name[idx]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("[기호:%d] %s: %2.2f%%, (투표수: %d)%n", j + 1, name[j], candidate[j] / 100000f * 100, candidate[j]);
            }
            System.out.println();
        }


        int maxIdx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < candidate.length; i++) {
            if (candidate[i] > max) {
                maxIdx = i;
                max = candidate[i];
            }
        }

        System.out.println("[투표결과] 당선인: " + name[maxIdx]);
    }
}
