

public class May13th_Sol2 {
	//5.13 프로그래머스 다시보기
    //자바 int는 4바이트 이므로 16비트. (16자리 숫자) -> 이진수 변환후 0채우기.
    public static void main(String[] args){
        int a = 2;
        String str = Integer.toBinaryString(a);
        System.out.println(String.format("%016d", Integer.parseInt(str)));

    }
}
