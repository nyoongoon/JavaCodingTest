package _Theory.Chapter3_NonLinear.NonLinearDS_12.src;// Practice2
// 문자열 배열 dictionary 와 문자열 sentence 가 주어졌을 때
// sentence 내의 단어 중 dictionary 의 단어로 시작하는 경우
// 해당 단어로 변경하여 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 dictionary: "cat", "bat", "rat"
// 입력 sentence = "the cattle was rattled by the battery"
// 출력: "the cat was rat by the bat"

// 입력 dictionary: "a", "b", "c"
// 입력 sentence = "apple banana carrot water"
// 출력: "a b c water"


import java.util.*;

public class Practice2 {
    public static void solution(String[] dictionary, String sentence) {
        //the cattle was rattled by the battery" -> set은 순서보장이 안됨..
        // 순서 보장이 되는 linkedList로..
        Set<String> set = new HashSet<>();
        for(String str : dictionary){
            set.add(str);
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i <words.length ; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(words[i].charAt(j));
                if(set.contains(sb.toString())){
                    words[i] = sb.toString();
                    break;
                }
            }
        }

        for(String str : words){
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        solution(dictionary, sentence);

        dictionary = new String[]{"a", "b", "c"};
        sentence = "apple banana carrot water";
        solution(dictionary, sentence);
    }

}
