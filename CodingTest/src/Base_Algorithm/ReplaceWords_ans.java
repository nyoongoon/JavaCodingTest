package Base_Algorithm;

public class ReplaceWords_ans {
    public static String solution(char[] str, char[] find, char[] to){
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();

        do{
            idx = findIdx(replaceBucket, find); // 같은 단어 있는지 하나씩 계속 찾기

            if(idx != -1){
                for (int i = 0; i < idx; i++) {
                    // 찾은 인덱스 이전까지 그대로 붙여넣기. 
                    replaceStr += replaceBucket[i];
                }
                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }

                for (int i = idx+find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }

                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }
        }while(idx != -1); // 더이상 매칭되는 것이 없을 떄까지.

        replaceStr = new String(replaceBucket);

        return replaceStr;
    }

    public static int findIdx(char[] str, char[]find){
        int idx = -1;
        boolean isMatch = false;
        for(int i = 0; i<str.length;i++){
            if(str[i] == find[0] && str.length - i >= find.length){
                isMatch = true;
                for(int j = 1; j<find.length; j++){
                    if(str[i+j] != find[j]){
                        isMatch = false;
                        break;
                    }
                }
            }
            if(isMatch){
                idx = i;
                break;
            }
        }
        return idx; //
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
