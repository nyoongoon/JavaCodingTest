package String;

import java.util.Scanner;

public class CompressString_inf_11 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String strs = stdIn.nextLine();
		char[] chars = strs.toCharArray();
		
		char[] result = new char[chars.length];
		int idx = 1 ;
	
		result[0] = chars[0];
		for(int i = 1; i<chars.length; i++) {

			if(chars[i-1] == chars[i]) { //이전과 같음
				if(Character.isAlphabetic(result[idx-1])) {
					//System.out.println("idx==" + idx);
					//System.out.println("case1: chars["+(i-1)+"] == chars["+(i)+"] : " + chars[(i-1)] +"=="+chars[i]);
					//System.out.println("result["+(idx-1)+"] is Alphabet");
					//System.out.println("result["+(idx)+"] == 2");
					//idx++;
					result[idx++] = '2';
				}else { // 숫자인경우 int로 변환 후 + 1 다시 char 변환. 
					//System.out.println("idx==" + idx);
					//System.out.println("case1: chars["+(i-1)+"] == chars["+(i)+"] : " + chars[(i-1)] +"=="+chars[i]);
					//System.out.println("result["+(idx-1)+"] is NOT Alphabet ("+ result[idx-1] +")");
					
					if(result[idx-1] != '2') {
						idx--;
					}
					
					int temp = (int)(result[idx-1]-'0'); // int ~ char 변환 시 -0 주
					
					
					
					//System.out.println("result["+(idx-1)+"] == " + (temp+1));
					result[idx-1] = (char)(temp+1+'0');
					idx++;
					
				}
			}else { //이전과 다른 경
				//System.out.println("idx==" + idx);
				//System.out.println("case3: chars["+(i-1)+"] != chars["+(i)+"] : " + chars[(i-1)] +"!="+chars[i]);
				//System.out.println("chars["+(i)+"] == " + chars[i]);
					
				
					result[idx++] = chars[i];
			
			}
		}
		System.out.println(result);
	}
}
