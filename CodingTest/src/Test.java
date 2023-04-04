public class Test {


    public static void main(String[] args) {
        String s1 = "baabaa";
        System.out.println(solution(s1));
        System.out.println();
        String s2 = "cdcd";
        System.out.println(solution(s2));
    }


    public static int solution(String s) {
        char[] chars = s.toCharArray();

        while(chars.length > 0){
            if(chars.length == 1) return 0;

            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]){
                    chars = cut(chars, i);
                    break;
                }
                if(i == chars.length-2){
                    return 0;
                }
            }
        }

        return 1;
    }

    public static char[] cut(char[] chars, int targetIdx){
        char[] newChars = new char[chars.length-2];
        int newCharsIdx = 0;
        for (int i = 0; i < targetIdx; i++) {
            newChars[newCharsIdx++] = chars[i];
        }
        for (int i = targetIdx+2; i < chars.length; i++) {
            newChars[newCharsIdx++] = chars[i];
        }
        return newChars;
    }


}
