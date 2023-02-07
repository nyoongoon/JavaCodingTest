package Base_Algorithm;

import java.util.ArrayList;

public class KeyLoging_18_2_4 {
    public static String solution(int[] keyLog) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        ArrayList<Character> al = new ArrayList<>();
        int idx = 0;
        boolean upper = false;
        boolean shift = false;
        boolean insert = false;

        for (int key : keyLog) {
            if (key == 8) {//idx -1 remove
                if (idx - 1 >= 0) {
                    al.remove(idx - 1);
                    if(al.size() < idx){
                        idx--;
                    }
                }
            } else if (key == 16) { // boolean shift
                shift = true; // 쉬프트 상태에서 특정값 처리 ?
            } else if (key == 20) { // boolean capLock
                if (upper == false) {
                    upper = true;
                } else {
                    upper = false;
                }
            } else if (key == 32) { // insert whitespace
                al.add(idx, ' ');
                idx++;
            } else if (key == 37) { // idx-=1
                if (idx - 1 >= 0) {
                    idx -= 1;
                }
            } else if (key == 39) {// idx+=1
                if (idx + 1 <= al.size()) {
                    idx += 1;
                }
            } else if (key == 155) { //insert at idx
                if (insert == true) {
                    insert = false;
                } else {
                    insert = true;
                }
            } else if (key == 127) { //remove at idx
                if (idx < al.size()) {
                    al.remove(idx);
                }
            } else {
                //upper check
                //shift check
                //insert check
                int upAscii = 0; // 32?
                if (shift == true) {
                    upper = !upper;
                }

                if (upper == true) {
                    if(key>=49 && key <=57){
                        System.out.println("특수문자"); // 특수문자일 경우 쉬프트만 영향 !!!
                        upAscii = -16;
                    }else{
                        upAscii = -32;
                    }
                } else {
                    upAscii = 0;
                }

                if (insert == true) {
                    //현재 인덱스 삭제 후 삽입 // < al.size
                    if (idx < al.size()) {
                        al.remove(idx);
                        al.add(idx, (char) (key + upAscii));
                    } else {
                        al.add(idx, (char) (key + upAscii));

                    }
                } else {
                    al.add(idx, (char) (key + upAscii));
                }

                idx++;

                if (shift == true) {
                    upper = !upper;
                    shift = false;
                }
            }
        }

        return String.valueOf(al);
    }

    public static void main(String[] args) {
        // Test code
        //int[] keyLog;
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97};
        System.out.println(solution(keyLog));

        keyLog = new int[]{49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        //keyLog = new int[]{20, 65, 66, 16, 67, 16, 68, 49, 50, 51};
        System.out.println(solution(keyLog));
    }
}
