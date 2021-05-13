
import java.util.LinkedList;
import java.util.List;
//5.13 프로그래머스 다시보기

public class May13th_Sol3 {
	    public String[] solution(String[] s) {
	        String[] answer = {};
	        int idx= 0;
	        for(String str : s){
	            char[] charArr = str.toCharArray();
	            for(int i = charArr.length; i>1; i--) {
	                if(charArr[i] == '0'){
	                    if(charArr[i-1] =='1'){
	                        if(charArr[i-2]=='1'){
	                            idx = i;
	                        }
	                    }
	                }
	                //인덱스를 찾았으니 110을 뽑은 후 당기기
	                for(int j =i-2; j<charArr.length-3;j++){
	                    charArr[j] = charArr[j+3];
	                }
	                //검사

	            }


	        
	    }
			return answer;
	}


	/*
	            for(int i = str.length()-1; i < 1; i--){
	                String result = str.substring(i-2, i);
	                if(result.equals("110")){
	                    check(str);
	                }
	            }*/


	/*
	        List<Integer> list = new LinkedList<>();
	        for(String str : s){
	            char[] charArr = str.toCharArray();
	            for(char ch : charArr){
	                list.add(ch-0);
	            }
	            for(int i = list.size()-1; i>1; i++){
	                int x = list.get(i);
	                if(x)
	            }
	        }
	         */
}

