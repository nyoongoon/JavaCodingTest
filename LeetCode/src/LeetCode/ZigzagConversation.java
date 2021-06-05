package LeetCode;

public class ZigzagConversation {
	
	    public static String convert(String s, int numRows) {
	        //연결 리스트의 개념을 활용하여 다음에 나올 위치를 즉시 찾아보자
	        char[] result = new char[s.length()];
	        int curIdx = 0; //작업 중인 인덱스
	        int startIdx = 0;//반복할 시작 인덱스== 현재로우-1
	        int resultIdx = 0; //결과 배열의 인덱스

	        while(startIdx<numRows) {
	            int jump1 = (numRows * 2 - 2) - startIdx*2 ;//첫번째 점프
	            int jump2 = (numRows * 2 - 2) - jump1;//두번쨰점프
	            result[resultIdx++]= s.charAt(curIdx);
	            System.out.println(result);
	            if(jump1 != 0) {
	                curIdx += jump1;
	                if (curIdx > s.length() - 1) {//인덱스 범위를 넘었으면 다음row로 넘어가기.
	                    curIdx = startIdx++;
	                    continue;
	                }
	                result[resultIdx++]= s.charAt(curIdx);
	                System.out.println(result);
	            }else{
	                curIdx += jump2;
	                if (curIdx > s.length() - 1) {//인덱스 범위를 넘었으면 다음row로 넘어가기.
	                    curIdx = startIdx++;
	                    continue;
	                }
	            }

	            if(jump2 != 0) {
	                curIdx += jump2;
	                if (curIdx > s.length() - 1) {//인덱스 범위를 넘었으면 다음row로 넘어가기.
	                    curIdx = startIdx++;
	                    continue;
	                }
	                result[resultIdx++]= s.charAt(curIdx);
	                System.out.println(result);
	            }else{
	                curIdx += jump1;
	                if (curIdx > s.length() - 1) {//인덱스 범위를 넘었으면 다음row로 넘어가기.
	                    curIdx = startIdx++;
	                    continue;
	                }
	            }


	        }

	        String answer = new String(result);
	        return answer;
	    }
	
}
