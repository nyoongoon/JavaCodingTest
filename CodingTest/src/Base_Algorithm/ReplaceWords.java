package Base_Algorithm;

import java.util.ArrayList;

public class ReplaceWords {
    public static String solution(char[] str, char[] find, char[] to) {

        ArrayList<Character> al = new ArrayList<>();
        for (Character c : str) {
            al.add(c);
        }

        for (int i = 0; i < al.size() - (find.length-1); i++) { //find.length-1 (-1)을 하지 않아서 틀렸었음..! 마지막 케이스는 find.length-1에서 시작 !! (길이를 아에 빼면 안됨)
            int iIdx = i;
            int findIdx = 0;

            while (findIdx < find.length) {

                if (al.get(iIdx) == find[findIdx]) {

                    if (findIdx == find.length - 1) { // 맞음 => 교체
                        iIdx = i;
                        findIdx = 0;

                        while(findIdx < find.length){ // 기존 단어 삭제
                            al.remove(iIdx);    //삭제 되면 기존 값 앞으로 땡겨짐 !!!
                            findIdx++;
                        }
                        iIdx = i;
                        int toIdx = to.length-1;

                        while(toIdx >= 0){ //새로운 단어 추가.
                            al.add(i, to[toIdx]);   //추가되면 기존 값 뒤로 밀린다 !!!
                            toIdx--;
                        }
                    }

                    iIdx++;
                    findIdx++;

                } else {
                    break;
                }
            }
        }

        return al.toString();
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
