package BaseCorrection.W4;

import java.util.Arrays;

public class Week4_2_ans {
    public static void main(String[] args) {
        Week4_2_ans w = new Week4_2_ans();
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hell*", "goo*", "*able", "qua*"};

        System.out.println(w.solution(words, queries));
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            boolean searchLeft = true;
            String search = "";
            if(queries[i].charAt(0) == '*'){
                search = queries[i].substring(1);
            }else{
                search = queries[i].substring(0, queries[1].length()-1);
                searchLeft = false;
            }
            System.out.println(search);
            for(int j = 0; j<words.length; j++){
                if(words[j].indexOf(search) != -1){
                    if(searchLeft){

                        if(words[j].indexOf(search) == words[j].length()-search.length()){
                            answer[i] += 1;
                        }
                    }else{
                        if(words[j].indexOf(search) == 0){
                            answer[i] += 1;
                        }
                    }

                }

            }

        }

        return answer;
    }
}
