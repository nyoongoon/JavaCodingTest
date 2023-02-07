package Base_Algorithm;

public class ReplaceWords_re {

    public static String solution(char[] str, char[]find, char[] to) {

        // 같은 단어의 인덱스를 찾아서
        // 인덱스 전까지 복사 -> 같은 단어 대체 -> 후 복사.
        // 인덱스 찾기

        String result = "";

        // 복사

        int idx = findIdx(str, find);
        if(idx == -1){
            return String.valueOf(result);
        }

        String tmp = "";

        char[] newStr = str.clone();
        while(idx != -1){

            tmp = "";
            for (int i = 0; i < idx; i++) {
                tmp += newStr[i];
            }
            for (int i = 0; i < to.length; i++) {
                tmp+= to[i];
            }


            for (int i = idx+find.length; i < newStr.length; i++) {
                tmp += newStr[i];
            }

            System.out.println(tmp);
            idx = findIdx(tmp.toCharArray(), find);
            newStr = tmp.toCharArray().clone();
            System.out.println(idx);
        }


        return result;
    }

    public static int findIdx(char[] str, char[]find){
        boolean isMatch = false;

        for (int i = 0; i < str.length; i++) {
            if(str[i] == find[0]){
                for (int j = 0; j < find.length; j++) {
                    if(str[i+j] == find[j]){
                        if(j == find.length-1){
                            isMatch = true;
                            return i;
                        }
                    }
                }
            }else{
                continue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        //System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}
