package BaseCorrection;

import java.util.Arrays;

public class Week2_2_my {
    public static void main(String[] args) {


    }

    public int[] solution(int[] a, int[] b) {
        int[] bg;
        int[] sm;
        if(a.length >= a.length){ //
            bg = a; //a가 더 김
            sm = b;
        }else{
            bg = b;
            sm = a;
        }


        int[] answer = new int[bg.length];
        int len = answer.length - 1;

        boolean isMoreTen = false;
        int bgIdx = bg.length - 1;
        int smIdx = sm.length - 1;
        while(bgIdx >= 0 && smIdx >= 0){
            int cur = bg[bgIdx--] + sm[smIdx--];
            if(isMoreTen){
                cur += 1;
                isMoreTen = false;
            }
            if(cur >= 10){
                isMoreTen = true;
                cur = cur % 10;
            }
            answer[len--] = cur;
        }

        System.out.println(len);

        while(isMoreTen){

            if(len < 0){
                int[] newAnswer = new int[answer.length +1];
                newAnswer[0] = 1;
                for(int i = 1; i<newAnswer.length; i++){
                    newAnswer[i] = answer[i-1];
                }
                isMoreTen = false;
                return newAnswer;
            }else{
                int cur = bg[len] + 1;
                System.out.println("cur == " + cur);
                if(cur >= 10){
                    System.out.println("cur>=10");
                    answer[len--] = cur % 10;
                }else{
                    answer[len--] = cur;
                    isMoreTen = false;
                    while(len>=0){
                        answer[len--] = bg[len];
                    }
                }
            }
        }

        return answer;
    }
}
