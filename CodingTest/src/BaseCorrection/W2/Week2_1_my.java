package BaseCorrection;

public class Week2_1_my {
    public static void main(String[] args){

    }
    public static int solution(int[] numbers) {
        int answer = 0;
        boolean[] chomchom = new boolean[100001];

        for(int i = 0; i<numbers.length; i++){
            chomchom[numbers[i]] = true;
        }

        int minIdx = -1;

        for(int i = 0; i<chomchom.length; i++){
            if(chomchom[i] == true){
                minIdx = i;
                break;
            }
        }

        int resultIdx = -1;
        for(int i = minIdx; i<chomchom.length; i++){
            if(chomchom[i] == false){
                resultIdx = i;
                break;
            }
        }


        return resultIdx;
    }
}
